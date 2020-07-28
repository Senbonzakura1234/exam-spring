package com.app.manager.controller;

import com.app.manager.service.interfaceClass.ProductService;
import com.app.manager.service.interfaceClass.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    ProductService productService;
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    SaleService saleService;

    @GetMapping("/data/product")
    public ResponseEntity<?> productData() {
        var result = productService.AddAll();
        return result? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }

    @GetMapping("/data/sale")
    public ResponseEntity<?> saleData() {
        var result = saleService.AddAll();
        return result? ResponseEntity.ok(true) : ResponseEntity.badRequest().body(false);
    }
}
