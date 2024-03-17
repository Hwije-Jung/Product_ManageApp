package com.ssg.product_manageapp.service;


import com.ssg.product_manageapp.domain.ProductVO;
import com.ssg.product_manageapp.dto.PageRequestDTO;
import com.ssg.product_manageapp.dto.PageResponseDTO;
import com.ssg.product_manageapp.dto.ProductDTO;

public interface ProductService {

    void register(ProductDTO productDTO);

    PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO);


    ProductDTO getOne(long tno);

    void remove(long tno);

    void modify(ProductDTO productDTO);
}
