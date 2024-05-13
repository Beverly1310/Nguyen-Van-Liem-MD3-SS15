package com.ra.btap3.model.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    private Integer id;
    private String name;
    private Boolean status;
}
