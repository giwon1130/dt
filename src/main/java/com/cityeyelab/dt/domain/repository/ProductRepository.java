package com.cityeyelab.dt.domain.repository;


import com.cityeyelab.dt.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Override
    List<Product> findAll();
}
