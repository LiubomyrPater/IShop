package ua.lviv.lgs.repository.impl;

import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.repository.ProductRepository;

import java.sql.Connection;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private static String READ_ALL = "select * from products";
    private static String CREATE = "insert into products(`name`, `description`, `price`) values (?,?,?)";
    private static String READ_BY_ID = "select * from products where id =?";
    private static String DELETE_BY_ID = "delete from products where id=?";
    private static String UPDATE_BY_ID = "update products set name=?, description=?, price= ?  where id = ?";

    private Connection connection;

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
