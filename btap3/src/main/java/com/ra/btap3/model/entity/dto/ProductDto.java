package com.ra.btap3.model.entity.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private Integer categoryId;
    private Boolean status;

}
