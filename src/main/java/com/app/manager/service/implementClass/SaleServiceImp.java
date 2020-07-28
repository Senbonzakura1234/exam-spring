package com.app.manager.service.implementClass;

import com.app.manager.entity.Product;
import com.app.manager.entity.Sale;
import com.app.manager.repository.ProductRepository;
import com.app.manager.repository.SaleRepository;
import com.app.manager.service.interfaceClass.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImp implements SaleService {
    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    SaleRepository saleRepository;

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Sale> getAll(Pageable pageable) {
        try {
            return saleRepository.findBy(pageable);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return Page.empty();
        }
    }

    @Override
    public List<Sale> getAll() {
        return (List<Sale>) saleRepository.findAll();
    }

    @Override
    public boolean AddAll() {
        try {
            List<Product> products = (List<Product>) productRepository.findAll();
            if(products.size() <= 0) {
                System.out.println("empty");
                return false;
            }
            int saleManId = 0;
            for (Product product: products
                 ) {
                saleManId++;
                for (int i = 0; i < 5; i++) {
                    Sale sale = new Sale();
                    sale.setSaleManId(Integer.toString(saleManId));
                    sale.setSaleManName("Sale Man no." + saleManId);
                    sale.setProductId(product.getId());
                    saleRepository.save(sale);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }

    }
}
