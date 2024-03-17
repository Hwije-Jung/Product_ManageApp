package com.ssg.Product_ManageApp.mapper;


import com.ssg.product_manageapp.domain.ProductVO;
import com.ssg.product_manageapp.mapper.ProductMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class MapperTests {

    @Autowired(required = false)
    ProductMapper productMapper;

    @Test
    public void insertTest(){

        ProductVO productVO = ProductVO.builder()
                .name("t1")
                .price(121314)
                .stock(13123)
                .build();

        System.out.println(productVO);

        productMapper.insert(productVO);

    }

    @Test
    public void selectOneTest(){
        log.info(productMapper.selectOne(8));
    }

    @Test
    public void deleteTest(){
        productMapper.delete(1);
    }


}
