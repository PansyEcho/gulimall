package com.shi.gulimall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shi.gulimall.product.entity.BrandEntity;
import com.shi.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


//@RunWith(SpringRunner.class)
@SpringBootTest
class GulimallProductApplicationTests {
    @Autowired
    BrandService brandService;


    @Test
    void contextLoads() {

//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setName("aodi");
//        brandEntity.setDescript("the car of aodi!");
//        brandService.save(brandEntity);

//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("It has been modified!");
//        brandService.updateById(brandEntity);

        BrandEntity brandEntity = new BrandEntity();

        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));

        list.forEach((item) ->{
            System.out.printf(item.toString());
        });

    }

}
