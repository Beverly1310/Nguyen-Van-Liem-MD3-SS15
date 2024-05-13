package com.ra.btap3.model.dao.impl;

import com.ra.btap3.model.dao.IProductDao;
import com.ra.btap3.model.entity.dto.ProductDto;
import com.ra.btap3.model.entity.Product;
import com.ra.btap3.service.ICategory;
import com.ra.btap3.util.ConnectDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements IProductDao {
    @Autowired
    private ICategory iCategory;

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement call = conn.prepareCall("select * from product");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Product product = Product.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .price(rs.getDouble("price"))
                        .stock(rs.getInt("stock"))
                        .category(iCategory.findById(rs.getInt("category_id")))
                        .status(rs.getBoolean("status"))
                        .build();
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return productList;
    }

    @Override
    public void save(ProductDto productDto) {
        Connection conn = ConnectDB.getConnection();
        CallableStatement call = null;
        try {
            if (productDto.getId() == null) {
                call = conn.prepareCall("insert into product(name,price,stock,category_id,status) values (?,?,?,?,?)");
            } else {
                call = conn.prepareCall("update product set name=?,price=?,stock=?,category_id=?, status =? where id=?");
                call.setInt(6, productDto.getId());
            }
            call.setString(1, productDto.getName());
            call.setDouble(2, productDto.getPrice());
            call.setInt(3, productDto.getStock());
            call.setInt(4, productDto.getCategoryId());
            call.setBoolean(5, productDto.getStatus());
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void changeStatus(Integer id) {
        Connection conn = ConnectDB.getConnection();
        Product product = findById(id);
        try {
            CallableStatement call = conn.prepareCall("update product set status=? where id=?");
            call.setBoolean(1, !product.getStatus());
            call.setInt(2, product.getId());
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public Product findById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        Product product = null;
        try {
            CallableStatement call = conn.prepareCall("select * from product where id=?");
            call.setInt(1,id);
            ResultSet rs = call.executeQuery();
            if (rs.next()){
                product = Product.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .price(rs.getDouble("price"))
                        .stock(rs.getInt("stock"))
                        .category(iCategory.findById(rs.getInt("id")))
                        .status(rs.getBoolean("status"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return product;
    }
}
