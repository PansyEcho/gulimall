package com.shi.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shi.common.utils.PageUtils;
import com.shi.gulimall.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * δΈι’εε
 *
 * @author Shizhen
 * @email yuuu.shizhen@gmail.com
 * @date 2022-03-09 16:22:22
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

