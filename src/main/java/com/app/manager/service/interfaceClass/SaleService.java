package com.app.manager.service.interfaceClass;

import com.app.manager.entity.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SaleService {
    Page<Sale> getAll(Pageable pageable);
    public List<Sale> getAll();
    boolean AddAll();
}
