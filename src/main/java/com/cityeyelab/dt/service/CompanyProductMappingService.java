package com.cityeyelab.dt.service;


import com.cityeyelab.dt.domain.dto.CompanyDto;
import com.cityeyelab.dt.domain.dto.CompanyProductMappingDto;
import com.cityeyelab.dt.domain.entity.Company;
import com.cityeyelab.dt.domain.entity.CompanyProductMapping;
import com.cityeyelab.dt.domain.repository.CompanyProductMappingRepository;
import com.cityeyelab.dt.domain.repository.CompanyRepository;
import com.cityeyelab.dt.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CompanyProductMappingService {

    private final CompanyProductMappingRepository repository;
    private final CompanyRepository companyRepository;
    private final ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;


    public Long save(CompanyProductMappingDto dto) {

        // generate id
        Long nextId = repository.findNextId();

        for(int i=0; i < dto.getProductSeqList().size(); i++) {
            Long productSeq = dto.getProductSeqList().get(i).longValue();
            CompanyProductMapping entity = dto.toEntity(nextId + i * 1L, dto.getCompanySeq(), productSeq);
            repository.save(entity);
        };

        return dto.getProductSeqList().size() * 1L;
    }
}

