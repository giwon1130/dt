package com.cityeyelab.dt.domain.repository;


import com.cityeyelab.dt.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    @Override
    List<Board> findAll();
}
