package com.shi.gulimall.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.shi.gulimall.member.feign.TransferCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shi.gulimall.member.entity.MemberEntity;
import com.shi.gulimall.member.service.MemberService;
import com.shi.common.utils.PageUtils;
import com.shi.common.utils.R;



/**
 * 会员
 *
 * @author Shizhen
 * @email yuuu.shizhen@gmail.com
 * @date 2022-03-09 16:37:42
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private TransferCoupon couponFeign;

    @RequestMapping("/coupon/list")
    public R getAllCouponsFromMember(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("LinXuan");
        R couponsR = couponFeign.memberCoupons();
        return R.ok()
                .put("member",memberEntity)
                .put("coupons",couponsR.get("coupons"));
    }
    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
