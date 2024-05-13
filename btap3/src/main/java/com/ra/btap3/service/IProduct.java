package com.ra.btap3.service;

import com.ra.btap3.model.entity.dto.ProductDto;
import com.ra.btap3.model.entity.Product;

import java.util.List;

public interface IProduct {
    List<Product> findAll();
    void save(ProductDto productDto);
    void changeStatus(Integer id);
    Product findById(Integer id);
}
