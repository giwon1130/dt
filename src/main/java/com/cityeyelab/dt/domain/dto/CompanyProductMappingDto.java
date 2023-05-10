package com.cityeyelab.dt.domain.dto;

import com.cityeyelab.dt.domain.entity.Company;
import com.cityeyelab.dt.domain.entity.CompanyProductMapping;
import com.cityeyelab.dt.domain.entity.Product;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;


@Data   // getter / setter / toString() 사용
@NoArgsConstructor  // 생성자를 사용하지 않도록 선언
public class CompanyProductMappingDto {
    private Long companyProductMappingSeq;
    private Long companySeq;

//    private Long productSeq;
    private List<Long> productSeqList;
    @CreatedDate
    private Date created;
    @CreatedDate
    private Date updated;


    public CompanyProductMapping toEntity(Long id, Long companySeq, Long productSeq) {
        return CompanyProductMapping.builder()
                .id(id)
                .company(Company.builder().companySeq(companySeq).build())
                .product(Product.builder().product_seq(productSeq).build())
                .created(created)
                .updated(updated).build();
    }
}