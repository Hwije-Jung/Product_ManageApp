package com.ssg.Product_ManageApp.service;


import com.ssg.product_manageapp.domain.ProductVO;
import com.ssg.product_manageapp.dto.ProductDTO;
import com.ssg.product_manageapp.mapper.ProductMapper;
import com.ssg.product_manageapp.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class ServiceTests {

    @Autowired(required = false)
    private ProductService productService;

    @Test
    public void testRegister(){

        ProductDTO productDTO = ProductDTO.builder()
                .name("a2")
                .price(121314)
                .stock(13123)
                .build();

        productService.register(productDTO);
    }

    @Test
    public void testGetOne(){
        productService.getOne(8);
    }

    @Test
    public void testremove(){

        productService.remove(2);
    }

}
