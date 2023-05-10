package com.cityeyelab.dt.controller.api;

import com.cityeyelab.dt.domain.dto.CompanyDto;
import com.cityeyelab.dt.domain.entity.Board;
import com.cityeyelab.dt.domain.entity.Company;
import com.cityeyelab.dt.service.BoardService;
import com.cityeyelab.dt.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("")
    public ResponseEntity<?> selectCompanyList(){
        List<Company> companyList = companyService.findAll();
        return new ResponseEntity<>( companyList, HttpStatus.OK);
    }

    @GetMapping("{companyId}")
    public ResponseEntity<?> selectCompanyInfo(@PathVariable Integer companyId){
        CompanyDto companyInfo = companyService.findById(companyId);
        return new ResponseEntity<>( companyInfo, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertCompany(@RequestBody CompanyDto companyDto){
        Long companyId = companyService.save(companyDto);
        return new ResponseEntity<>(companyId, HttpStatus.OK);
    }

    @DeleteMapping("{companyId}")
    public ResponseEntity<?> deleteCompany(@PathVariable Integer companyId){
        Integer deletId = companyService.deletById(companyId);
        return new ResponseEntity<>( companyId, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> updateCompany(@RequestBody CompanyDto companyDto){
        Long companyId = companyService.save(companyDto);
        return new ResponseEntity<>(companyId, HttpStatus.OK);
    }
}
