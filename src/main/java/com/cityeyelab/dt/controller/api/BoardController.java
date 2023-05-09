package com.cityeyelab.dt.controller.api;

import com.cityeyelab.dt.domain.entity.Board;
import com.cityeyelab.dt.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("")
    public ResponseEntity<?> boardList(){
        List<Board> boardList = boardService.findAll();
        return new ResponseEntity<>( boardList, HttpStatus.OK);
    }
}
