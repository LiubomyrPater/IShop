package ua.lviv.lgs.repository.impl;

import ua.lviv.lgs.connection.ConnectionManager;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private static String READ_ALL = "select * from products";
    private static String CREATE = "insert into products(`name`, `description`, `price`) values (?,?,?)";
    private static String READ_BY_ID = "select * from products where id =?";
    private static String DELETE_BY_ID = "delete from products where id=?";
    private static String UPDATE_BY_ID = "update products set name=?, description=?, price= ?  where id = ?";

    private Connection connection;


    public ProductRepositoryImpl() {
        this.connection = ConnectionManager.openConnection();
    }

    @Override
    public Product save(Product product) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            product.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product findById(Integer id) {
        Product product = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            Integer productId = result.getInt("id");
            String name = result.getString("name");
            String description = result.getString("description");
            Float price = result.getFloat("price");

            product = new Product(productId, name, description, price);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product update(Product product) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setFloat(3, product.getPrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        PreparedStatement preparedStatement;
        List<Product> productRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer productId = result.getInt("id");
                String name = result.getString("name");
                String description = result.getString("description");
                Float price = result.getFloat("price");

                productRecords.add(new Product(productId, name, description, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productRecords;
    }
}
