package com.ssg.product_manageapp.mapper;

import com.ssg.product_manageapp.domain.ProductVO;
import com.ssg.product_manageapp.dto.PageRequestDTO;

import java.util.List;

public interface ProductMapper {

    void insert(ProductVO productVO);

//    List<ProductVO> selectAll();

    int getCount(PageRequestDTO pageRequestDTO);

    ProductVO selectOne(long id);

    List<ProductVO> selectList(PageRequestDTO pageRequestDTO);

    void delete(long tno);

    void update(ProductVO productVO);
}
