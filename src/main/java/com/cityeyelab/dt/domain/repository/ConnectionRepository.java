package com.cityeyelab.dt.domain.repository;


import com.cityeyelab.dt.domain.dto.ConnectionDto;
import com.cityeyelab.dt.domain.entity.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConnectionRepository extends JpaRepository<Connection, Integer> {

    @Query(
            value = "select * from connection c;",
            nativeQuery = true)
    List<Connection> findByCompanyId();
}
