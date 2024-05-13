package com.ra.btap3.model.dao.impl;

import com.ra.btap3.model.dao.ICategoryDao;
import com.ra.btap3.model.entity.Category;
import com.ra.btap3.model.entity.Product;
import com.ra.btap3.util.ConnectDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDaoImpl implements ICategoryDao {
    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement call = conn.prepareCall("select * from category");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Category category = Category.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .status(rs.getBoolean("status"))
                        .build();
                categoryList.add(category);
            }
            return categoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void save(Category category) {
        Connection conn = ConnectDB.getConnection();
        CallableStatement call = null;
        try {
            if (category.getId() == null) {
                call = conn.prepareCall("insert into category(name,status) values (?,?)");
            } else {
                call = conn.prepareCall("update category set name= ?, status = ? where id = ?");
                call.setInt(3, category.getId());
            }
            call.setString(1, category.getName());
            call.setBoolean(2, category.getStatus());
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
        try {
            CallableStatement call = conn.prepareCall("update category set status=? where id=?");
            call.setBoolean(1, !findById(id).getStatus());
            call.setInt(2, id);
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public Category findById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        Category category = null;
        try {
            CallableStatement call = conn.prepareCall("select * from category where id=?");
            call.setInt(1,id);
            ResultSet rs = call.executeQuery();
            if (rs.next()){
                category = Category.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .status(rs.getBoolean("status"))
                        .build();
            }
            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }
}
