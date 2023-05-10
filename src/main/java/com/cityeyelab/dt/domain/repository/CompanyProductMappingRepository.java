package com.cityeyelab.dt.domain.repository;


import com.cityeyelab.dt.domain.entity.Company;
import com.cityeyelab.dt.domain.entity.CompanyProductMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyProductMappingRepository extends JpaRepository<CompanyProductMapping, Integer> {


    @Query(value = "SELECT COALESCE(max(a.id),1) FROM CompanyProductMapping a")
    Long findNextId();
}
