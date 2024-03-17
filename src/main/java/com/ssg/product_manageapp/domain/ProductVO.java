package com.ssg.product_manageapp.domain;


import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
    private long id;
    private String name;
    private long price;
    private long stock;
}
