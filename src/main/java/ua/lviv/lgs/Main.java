package ua.lviv.lgs;

import ua.lviv.lgs.connection.ConnectionManager;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.ProductServiceImpl;
import ua.lviv.lgs.service.impl.UserServiseImpl;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiseImpl();
        User user = new User("test2@mail.com", "test2", "test2", "USER");

        User savedUser = userService.save(user);
       // User savedUser = userService.findById(3);
        System.out.println(savedUser);

/*
        List<User> users = userService.findAll();
        System.out.println(users);*/

        ProductService productService = new ProductServiceImpl();
        Product product = new Product("phone", "lenovo", 23.45f);
        Product savedProduct = ((ProductServiceImpl) productService).save(product);
        System.out.println(savedProduct);





        ConnectionManager.closeConnection();

    }
}
