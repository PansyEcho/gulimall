package com.shi.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shi.common.utils.PageUtils;
import com.shi.gulimall.order.entity.OrderOperateHistoryEntity;

import java.util.Map;

/**
 * 订单操作历史记录
 *
 * @author Shizhen
 * @email yuuu.shizhen@gmail.com
 * @date 2022-03-09 16:39:37
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

