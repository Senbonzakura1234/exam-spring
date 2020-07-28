package com.app.manager.service.implementClass;

import com.app.manager.entity.Product;
import com.app.manager.repository.ProductRepository;
import com.app.manager.service.interfaceClass.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        try {
            return productRepository.findBy(pageable);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return Page.empty();
        }
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public boolean AddAll() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            Product product = new Product();
            product.setName("Product No." + i);
            product.setDescription("Description of product No." + i);
            product.setPrice(100 + i);
            products.add(product);
        }

        try {
            productRepository.saveAll(products);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
}
