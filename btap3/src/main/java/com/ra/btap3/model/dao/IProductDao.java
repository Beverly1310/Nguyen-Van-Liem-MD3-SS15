package com.ra.btap3.model.dao;

import com.ra.btap3.model.entity.Product;
import com.ra.btap3.model.entity.dto.ProductDto;

import java.util.List;

public interface IProductDao {
    List<Product> findAll();
    void save(ProductDto productDto);
    void changeStatus(Integer id);
    Product findById(Integer id);
}
