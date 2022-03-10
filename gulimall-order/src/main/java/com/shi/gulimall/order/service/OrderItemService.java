package com.shi.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shi.common.utils.PageUtils;
import com.shi.gulimall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author Shizhen
 * @email yuuu.shizhen@gmail.com
 * @date 2022-03-09 16:39:37
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

