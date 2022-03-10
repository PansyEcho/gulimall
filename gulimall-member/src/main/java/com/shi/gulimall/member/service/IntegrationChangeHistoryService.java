package com.shi.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shi.common.utils.PageUtils;
import com.shi.gulimall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author Shizhen
 * @email yuuu.shizhen@gmail.com
 * @date 2022-03-09 16:37:42
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

