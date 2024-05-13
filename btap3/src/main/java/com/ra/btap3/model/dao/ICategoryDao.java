package com.ra.btap3.model.dao;

import com.ra.btap3.model.entity.Category;
import com.ra.btap3.model.entity.Product;
import com.ra.btap3.model.entity.dto.ProductDto;

import java.util.List;

public interface ICategoryDao {
    List<Category> findAll();
    void save(Category category);
    void changeStatus(Integer id);
    Category findById(Integer id);
}
