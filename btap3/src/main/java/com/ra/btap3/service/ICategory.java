package com.ra.btap3.service;

import com.ra.btap3.model.entity.Category;

import java.util.List;

public interface ICategory {
    List<Category> findAll();
    void save(Category category);
    void changeStatus(Integer id);
    Category findById(Integer id);
}
