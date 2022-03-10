package com.shi.gulimall.order.dao;

import com.shi.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 *
 * @author Shizhen
 * @email yuuu.shizhen@gmail.com
 * @date 2022-03-09 16:39:37
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {

}
