package com.cityeyelab.dt.controller.api;

import com.cityeyelab.dt.domain.dto.CompanyProductMappingDto;
import com.cityeyelab.dt.domain.dto.ProductDto;
import com.cityeyelab.dt.domain.entity.Connection;
import com.cityeyelab.dt.domain.entity.Product;
import com.cityeyelab.dt.service.CompanyProductMappingService;
import com.cityeyelab.dt.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/companyProductMapping")
public class CompanyProductMappingController {
    private final CompanyProductMappingService service;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody CompanyProductMappingDto dto){
        Long res = service.save(dto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
