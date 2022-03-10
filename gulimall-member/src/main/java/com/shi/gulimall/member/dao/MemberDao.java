package com.shi.gulimall.member.dao;

import com.shi.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 *
 * @author Shizhen
 * @email yuuu.shizhen@gmail.com
 * @date 2022-03-09 16:37:42
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {

}
