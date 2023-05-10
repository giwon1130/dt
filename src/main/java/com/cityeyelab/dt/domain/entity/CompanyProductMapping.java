package com.cityeyelab.dt.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data   // getter / setter / toString() 사용
@NoArgsConstructor  // 생성자를 사용하지 않도록 선언
@Entity
public class CompanyProductMapping {
    @Id
    @Column(name = "company_product_mapping_seq")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "company")
    @JsonBackReference
    private Company company;
    @ManyToOne
    @JoinColumn(name = "product")
    @JsonBackReference
    private Product product;
    @CreatedDate
    private Date created;
    @CreatedDate
    private Date updated;


    @Builder
    public CompanyProductMapping(Long id, Company company, Product product, Date created, Date updated){
        this.id = id;
        this.company = company;
        this.product = product;
        this.created = created;
        this.updated = updated;
    }
}