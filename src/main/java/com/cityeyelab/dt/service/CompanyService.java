package com.cityeyelab.dt.service;


import com.cityeyelab.dt.domain.dto.CompanyDto;
import com.cityeyelab.dt.domain.entity.Board;
import com.cityeyelab.dt.domain.entity.Company;
import com.cityeyelab.dt.domain.repository.BoardRepository;
import com.cityeyelab.dt.domain.repository.CompanyRepository;
import io.swagger.models.auth.In;
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
public class CompanyService {

    private final CompanyRepository companyRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public CompanyDto findById(Integer companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isEmpty()) return null;
        CompanyDto companyDto = new CompanyDto(company.get());
        return companyDto;
    }

    public Long save(CompanyDto companyDto) {
//        if (null == companyDto.getCompany_seq()) companyDto.setCompany_seq(findNextId());
        Company company = companyDto.toEntity();
        return companyRepository.save(company).getCompanySeq();
    }

    public Integer findNextId() {

        // seq 조회
        Integer nextId = companyRepository.findNextId();

        Optional<Company> company = companyRepository.findById(nextId);

        return nextId;
    }

    public Integer deletById(Integer companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        companyRepository.delete(company.get());
        return 1;

    }
}

