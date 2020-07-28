package com.app.manager.repository;

import com.app.manager.entity.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, String> {
    Page<Sale> findBy(Pageable pageable);
}
