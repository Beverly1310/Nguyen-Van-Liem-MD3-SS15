package com.ra.btap3.service.Impl;

import com.ra.btap3.model.dao.ICategoryDao;
import com.ra.btap3.model.entity.Category;
import com.ra.btap3.service.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements ICategory {
    @Autowired
    private ICategoryDao iCategoryDao;

    @Override
    public List<Category> findAll() {
        return iCategoryDao.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryDao.save(category);
    }

    @Override
    public void changeStatus(Integer id) {
        iCategoryDao.changeStatus(id);
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryDao.findById(id);
    }
}
