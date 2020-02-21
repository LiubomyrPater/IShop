package ua.lviv.lgs.service.impl;

import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.repository.ProductRepository;
import ua.lviv.lgs.repository.impl.ProductRepositoryImpl;
import ua.lviv.lgs.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl() {
        this.productRepository = new ProductRepositoryImpl();
    }
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
