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
        // ???????????????????????????, ????????????????????????????????????????????????????????????(????????????????????????????????????)
        if (Objects.equals(status, "8")) {
            recycleOrderMapper.updateOrderStatusWithTimeOut(UserCache.get("userId"));
        }

        // ?????????????????????????????????
        List<RecycleOrder> recycleOrders = recycleOrderMapper.selectListByStatusAndOrderType("10", status);
        return commonConditionsSelectHandlerList(recycleOrders);
    }


    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public boolean deleteById(String id) {
        selectById(id);
        // ??????????????????????????????
        recycleOrderDetailService.deleteByOrderId(id);

        // ?????????????????????
        return recycleOrderMapper.deleteById(id) > 0;
    }

    @Override
    @Transactional(rollbackFor = TransactionalException.class)
    public boolean create(RecycleOrder recycleOrder) {
        // ????????????ID
        String orderId = UuidUtil.generator();

        // ??????????????????????????????
        List<RecycleOrderDetail> recycleOrderDetails = recycleOrder.getRecycleOrderDetails().stream().peek(order -> {
            // ?????????????????????ID????????????ID
            order.setId(UuidUtil.generator());
            order.setOrderId(orderId);
        }).collect(Collectors.toList());
        recycleOrderDetailService.insert(recycleOrderDetails);

        // ????????????????????????
        recycleOrder.setId(orderId);
        return recycleOrderMapper.insert(recycleOrder) > 0;
    }

    @Override
    public boolean updateOrderStatus(RecycleOrderUpdateDto recycleOrderUpdateDto) {
        selectById(recycleOrderUpdateDto.getId());
        return recycleOrderMapper.updateOrderStatus(recycleOrderUpdateDto.getId(), recycleOrderUpdateDto.getStatus(), recycleOrderUpdateDto.getReceiveUserId()) > 0;
    }


    // ??????????????????????????????????????? ??????
    @Override
    public List<RecycleOrder> commonConditionsSelectHandlerList(List<RecycleOrder> recycleOrders) {
        recycleOrders.forEach(recycleOrder -> recycleOrder = commonConditionsSelectHandlerSingle(recycleOrder));
        return recycleOrders;
    }


    // ??????????????????????????????????????? ??????
    @Override
    public RecycleOrder commonConditionsSelectHandlerSingle(RecycleOrder recycleOrder) {
        // ??????????????????
        String driverId = recycleOrder.getReceiveUserId();
        if (StringUtils.hasText(driverId)) {
            User user = userService.findUserById(driverId);
            recycleOrder.setReceiveUser(user);
        }
        // ????????????????????????
        String noteAttachmentIds = recycleOrder.getNoteAttachmentIds();
        if (StringUtils.hasText(noteAttachmentIds)) {
            for (String attachmentId : noteAttachmentIds.split(",")) {
                Attachment attachment = attachmentService.selectById(attachmentId);
                // attachments ?????????null ????????????
                if (Objects.isNull(recycleOrder.getAttachments())) recycleOrder.setAttachments(new ArrayList<>());
                recycleOrder.getAttachments().add(attachment);
            }
        }
        // ????????????????????????
        List<RecycleOrderDetail> recycleOrderDetails = recycleOrderDetailService.selectListByOrderId(recycleOrder.getId());
        recycleOrder.setRecycleOrderDetails(recycleOrderDetails);
        return recycleOrder;
    }
}
