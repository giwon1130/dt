package com.cityeyelab.dt.domain.repository;


import com.cityeyelab.dt.domain.entity.Board;
import com.cityeyelab.dt.domain.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Override
    List<Company> findAll();


    @Query(value = "SELECT nextval('company_company_seq');", nativeQuery = true)
    Integer findNextId();

}
