package com.cityeyelab.dt.service;


import com.cityeyelab.dt.domain.dto.CompanyDto;
import com.cityeyelab.dt.domain.dto.ConnectionDto;
import com.cityeyelab.dt.domain.dto.ProductDto;
import com.cityeyelab.dt.domain.entity.Board;
import com.cityeyelab.dt.domain.entity.Company;
import com.cityeyelab.dt.domain.entity.Connection;
import com.cityeyelab.dt.domain.entity.Product;
import com.cityeyelab.dt.domain.repository.BoardRepository;
import com.cityeyelab.dt.domain.repository.ConnectionRepository;
import com.cityeyelab.dt.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ConnectionRepository connectionRepository;

    @PersistenceContext
    private EntityManager entityManager;


    public ProductDto findById(Integer productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) return null;
        ProductDto productDto = new ProductDto(product.get());
        return productDto;
    }

    public Long save(ProductDto productDto) {
//        if (null == companyDto.getCompany_seq()) companyDto.setCompany_seq(findNextId());
        Product product = productDto.toEntity();
        return productRepository.save(product).getProduct_seq();
    }

//    public Integer findNextId() {
//
//        // seq 조회
//        Integer nextId = productRepository.findNextId();
//
//        Optional<Product> product = productRepository.findById(nextId);
//
//        return nextId;
//    }

    public Integer deletById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());
        return 1;

    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Connection> findByCompanyId(Integer companyId) {
        List<Connection> connectionDtos = connectionRepository.findByCompanyId();

        return connectionDtos;
    }
}

