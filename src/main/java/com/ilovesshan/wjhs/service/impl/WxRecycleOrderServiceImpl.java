package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.dto.RecycleOrderUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.Attachment;
import com.ilovesshan.wjhs.beans.pojo.RecycleOrder;
import com.ilovesshan.wjhs.beans.pojo.RecycleOrderDetail;
import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.core.exception.TransactionalException;
import com.ilovesshan.wjhs.mapper.RecycleOrderMapper;
import com.ilovesshan.wjhs.service.AttachmentService;
import com.ilovesshan.wjhs.service.UserService;
import com.ilovesshan.wjhs.service.WxRecycleOrderService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/16
 * @description:
 */

@Service
public class WxRecycleOrderServiceImpl implements WxRecycleOrderService {
    @Autowired
    private RecycleOrderMapper recycleOrderMapper;

    @Autowired
    private RecycleOrderDetailServiceImpl recycleOrderDetailService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private UserService userService;

    @Override
    public RecycleOrder selectById(String id) {
        RecycleOrder findRecycleOrder = recycleOrderMapper.selectById(id);
        if (Objects.isNull(findRecycleOrder)) {
            throw new CustomException(R.ERROR_RESOURCES_NOTFOUND);
        }
        return commonConditionsSelectHandlerSingle(findRecycleOrder);
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public List<RecycleOrder> selectListByStatus(String status) {
        // 如果是查询超时订单, 需要处理超时的订单状态并且更新数据库状态(注意更新当前用户相关订单)
        if (Objects.equals(status, "8")) {
            recycleOrderMapper.updateOrderStatusWithTimeOut(UserCache.get("userId"));
        }

        // 再根据相关状态查询订单
        List<RecycleOrder> recycleOrders = recycleOrderMapper.selectListByStatusAndOrderType("10", status);
        return commonConditionsSelectHandlerList(recycleOrders);
    }


    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public boolean deleteById(String id) {
        selectById(id);
        // 删除订单详情表的数据
        recycleOrderDetailService.deleteByOrderId(id);

        // 删除订单表数据
        return recycleOrderMapper.deleteById(id) > 0;
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public boolean create(RecycleOrder recycleOrder) {
        // 生成订单ID
        String orderId = UuidUtil.generator();

        // 向订单详情表插入数据
        List<RecycleOrderDetail> recycleOrderDetails = recycleOrder.getRecycleOrderDetails().stream().peek(order -> {
            // 设置关联的订单ID以及数据ID
            order.setId(UuidUtil.generator());
            order.setOrderId(orderId);
        }).collect(Collectors.toList());
        recycleOrderDetailService.insert(recycleOrderDetails);

        // 向订单表插入数据
        recycleOrder.setId(orderId);
        return recycleOrderMapper.insert(recycleOrder) > 0;
    }

    @Override
    public boolean updateOrderStatus(RecycleOrderUpdateDto recycleOrderUpdateDto) {
        selectById(recycleOrderUpdateDto.getId());
        return recycleOrderMapper.updateOrderStatus(recycleOrderUpdateDto.getId(), recycleOrderUpdateDto.getStatus(), recycleOrderUpdateDto.getReceiveUserId()) > 0;
    }


    // 订单相关信息的通用查询方法 列表
    @Override
    public List<RecycleOrder> commonConditionsSelectHandlerList(List<RecycleOrder> recycleOrders) {
        recycleOrders.forEach(recycleOrder -> recycleOrder = commonConditionsSelectHandlerSingle(recycleOrder));
        return recycleOrders;
    }


    // 订单相关信息的通用查询方法 单个
    @Override
    public RecycleOrder commonConditionsSelectHandlerSingle(RecycleOrder recycleOrder) {
        // 查询骑手信息
        String driverId = recycleOrder.getReceiveUserId();
        if (StringUtils.hasText(driverId)) {
            User user = userService.findUserById(driverId);
            recycleOrder.setReceiveUser(user);
        }
        // 查询订单附件列表
        String noteAttachmentIds = recycleOrder.getNoteAttachmentIds();
        if (StringUtils.hasText(noteAttachmentIds)) {
            for (String attachmentId : noteAttachmentIds.split(",")) {
                Attachment attachment = attachmentService.selectById(attachmentId);
                // attachments 默认是null 先初始化
                if (Objects.isNull(recycleOrder.getAttachments())) recycleOrder.setAttachments(new ArrayList<>());
                recycleOrder.getAttachments().add(attachment);
            }
        }
        // 查询商品详情信息
        List<RecycleOrderDetail> recycleOrderDetails = recycleOrderDetailService.selectListByOrderId(recycleOrder.getId());
        recycleOrder.setRecycleOrderDetails(recycleOrderDetails);
        return recycleOrder;
    }
}
