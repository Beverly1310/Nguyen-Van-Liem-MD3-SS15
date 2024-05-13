package com.ra.btap3.model.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private Category category;
    private Boolean status;

}
