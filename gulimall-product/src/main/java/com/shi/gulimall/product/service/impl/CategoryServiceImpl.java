package com.shi.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shi.common.utils.PageUtils;
import com.shi.common.utils.Query;

import com.shi.gulimall.product.dao.CategoryDao;
import com.shi.gulimall.product.entity.CategoryEntity;
import com.shi.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listTree() {
        List<CategoryEntity> entities = baseMapper.selectList(null);
        List<CategoryEntity> collect = entities.stream()
                .filter(category -> {
                    return category.getParentCid() == 0;
                })
                .map(category -> {
                    category.setChild(listChild(category, entities));
                    return category;
                })
                .sorted((cateFirst, cateSecond) -> {
                    return (cateFirst.getSort()==null ? 0 : cateFirst.getSort())
                            - (cateSecond.getSort()==null ? 0 : cateSecond.getSort());
                })
                .collect(Collectors.toList());

        return collect;
    }

    public static List<CategoryEntity> listChild(CategoryEntity parentEntity,List<CategoryEntity> list){
        List<CategoryEntity> categoryEntities = list.stream()
                .filter(category -> {
                    return parentEntity.getCatId() == category.getParentCid();
                })
                .map(category -> {
                    category.setChild(listChild(category, list));
                    return category;
                })
                .sorted((cateFirst, cateSecond) -> {
                    return (cateFirst.getSort()==null ? 0 : cateFirst.getSort())
                            - (cateSecond.getSort()==null ? 0 : cateSecond.getSort());
                })
                .collect(Collectors.toList());

//        当filter个数为0时，递归结束返回所有符合条件的子类及其子类...
        return categoryEntities;

    }

}
