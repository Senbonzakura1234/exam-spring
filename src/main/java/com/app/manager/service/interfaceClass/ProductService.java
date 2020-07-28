package com.app.manager.service.interfaceClass;

import com.app.manager.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> getAll(Pageable pageable);
    List<Product> getAll();
    boolean AddAll();
}
