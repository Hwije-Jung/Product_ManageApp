package com.ssg.product_manageapp.service;

import com.ssg.product_manageapp.config.ModelMapperConfig;
import com.ssg.product_manageapp.config.ModelMapperConfig;
import com.ssg.product_manageapp.domain.ProductVO;
import com.ssg.product_manageapp.dto.PageRequestDTO;
import com.ssg.product_manageapp.dto.PageResponseDTO;
import com.ssg.product_manageapp.dto.ProductDTO;
import com.ssg.product_manageapp.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;
    private final ModelMapperConfig modelMapper;
    @Override
    public void register(ProductDTO productDTO){
        ProductVO productVO = modelMapper.getMapper().map(productDTO, ProductVO.class);
        productMapper.insert(productVO);
    }

    @Override
    public PageResponseDTO<ProductDTO> getList(PageRequestDTO pageRequestDTO) {
        List<ProductVO> voList = productMapper.selectList(pageRequestDTO);
        List<ProductDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.getMapper().map(vo, ProductDTO.class))
                .collect(Collectors.toList());

        int total = productMapper.getCount(pageRequestDTO);

        PageResponseDTO<ProductDTO> pageResponseDTO = PageResponseDTO.<ProductDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }

    @Override
    public ProductDTO getOne(long tno) {
        ProductDTO productDTO = modelMapper.getMapper().map(productMapper.selectOne(tno), ProductDTO.class);
        return productDTO;
    }

    @Override
    public void remove(long tno) {
        productMapper.delete(tno);
    }


    @Override
    public void modify(ProductDTO productDTO) {
        ProductVO productVO = modelMapper.getMapper().map(productDTO, ProductVO.class);
        productMapper.update(productVO);
    }

}
