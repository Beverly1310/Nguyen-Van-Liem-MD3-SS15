package com.ra.btap3.service.Impl;

import com.ra.btap3.model.dao.IProductDao;
import com.ra.btap3.model.entity.dto.ProductDto;
import com.ra.btap3.model.entity.Product;
import com.ra.btap3.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements IProduct {
    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() {
        return iProductDao.findAll();
    }

    @Override
    public void save(ProductDto productDto) {
        iProductDao.save(productDto);
    }

    @Override
    public void changeStatus(Integer id) {
        iProductDao.changeStatus(id);
    }

    @Override
    public Product findById(Integer id) {
        return iProductDao.findById(id);
    }
}
