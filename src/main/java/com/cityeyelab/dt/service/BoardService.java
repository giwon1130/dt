package com.cityeyelab.dt.service;


import com.cityeyelab.dt.domain.entity.Board;
import com.cityeyelab.dt.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Board> findAll() {
        return boardRepository.findAll();
    }
}

