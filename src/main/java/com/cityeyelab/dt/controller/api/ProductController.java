package com.cityeyelab.dt.controller.api;

import com.cityeyelab.dt.domain.dto.CompanyDto;
import com.cityeyelab.dt.domain.dto.ConnectionDto;
import com.cityeyelab.dt.domain.dto.ProductDto;
import com.cityeyelab.dt.domain.entity.Board;
import com.cityeyelab.dt.domain.entity.Company;
import com.cityeyelab.dt.domain.entity.Connection;
import com.cityeyelab.dt.domain.entity.Product;
import com.cityeyelab.dt.service.BoardService;
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
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<?> selectProductList(){
        List<Product> products = productService.findAll();
        return new ResponseEntity<>( products, HttpStatus.OK);
    }

    @GetMapping("{productId}")
    public ResponseEntity<?> selectProductInfo(@PathVariable Integer productId){
        ProductDto productDto = productService.findById(productId);
        return new ResponseEntity<>( productDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertProduct(@RequestBody ProductDto productDto){
        Long productId = productService.save(productDto);
        return new ResponseEntity<>(productId, HttpStatus.OK);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        Integer deletId = productService.deletById(productId);
        return new ResponseEntity<>( deletId, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto){
        Long id = productService.save(productDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/connection/{companyId}")
    public ResponseEntity<?> getCompanyProduct(@PathVariable Integer companyId){
        List<Connection> ConnectionDtos = productService.findByCompanyId(companyId);

        return new ResponseEntity<>( ConnectionDtos, HttpStatus.OK);
    }

}
