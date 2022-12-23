package com.ilovesshan.wjhs.utils;

import com.ilovesshan.wjhs.beans.converter.*;
import com.ilovesshan.wjhs.beans.pojo.Attachment;
import com.ilovesshan.wjhs.beans.pojo.RecycleOrder;
import com.ilovesshan.wjhs.beans.pojo.User;
import com.ilovesshan.wjhs.beans.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collections;
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

@Component
public class OrderVoParseUtil {
    @Autowired
    private RecycleOrderConverter recycleOrderConverter;

    @Autowired
    private RecycleOrderDetailConverter recycleOrderDetailConverter;

    @Autowired
    private AttachmentConverter attachmentConverter;

    @Autowired
    private AddressConverter addressConverter;

    @Autowired
    private RecycleGoodsConverter recycleGoodsConverter;

    @Autowired
    private UserConverter userConverter;


    public RecycleOrderVo parseSingle(RecycleOrder recycleOrder) {
        RecycleOrderVo recycleOrderVo = recycleOrderConverter.po2vo(recycleOrder);
        // 解析骑手信息
        if (StringUtils.hasText(recycleOrder.getReceiveUserId())) {
            User receiveUser = recycleOrder.getReceiveUser();
            Attachment attachment = receiveUser.getAttachment();
            UserVo userVo = userConverter.po2vo(receiveUser);
            userVo.setAttachment(attachmentConverter.po2vo(attachment));
            recycleOrderVo.setReceiveUser(userVo);
        }
        // 解析订单商品详情列表
        List<RecycleOrderDetailVo> recycleOrderDetailVos = recycleOrder.getRecycleOrderDetails().stream().map(recycleOrderDetail -> {
            RecycleOrderDetailVo recycleOrderDetailVo = recycleOrderDetailConverter.po2vo(recycleOrderDetail);
            // 解析商品详情
            RecycleGoodsVo recycleGoodsVo = recycleGoodsConverter.po2vo(recycleOrderDetail.getRecycleGoods());
            // 商品 附件
            recycleGoodsVo.setAttachment(attachmentConverter.po2vo(recycleOrderDetail.getRecycleGoods().getAttachment()));
            recycleOrderDetailVo.setRecycleGoods(recycleGoodsVo);
            return recycleOrderDetailVo;
        }).collect(Collectors.toList());
        recycleOrderVo.setRecycleOrderDetails(recycleOrderDetailVos);
        // 解析订单附件列表
        if (!Objects.isNull(recycleOrder.getAttachments())) {
            List<AttachmentVo> attachmentVos = recycleOrder.getAttachments().stream().map(attachmentConverter::po2vo).collect(Collectors.toList());
            recycleOrderVo.setAttachments(attachmentVos);
        } else {
            recycleOrderVo.setAttachments(Collections.emptyList());
        }
        // 解析订单上门地址
        recycleOrderVo.setAddress(addressConverter.po2vo(recycleOrder.getAddress()));
        return recycleOrderVo;
    }


    public List<RecycleOrderVo> parseList(List<RecycleOrder> recycleOrders) {
        return recycleOrders.stream().map(this::parseSingle).collect(Collectors.toList());
    }
}
