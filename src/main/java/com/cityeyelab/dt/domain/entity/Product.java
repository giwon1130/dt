package com.cityeyelab.dt.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data   // getter / setter / toString() 사용
@NoArgsConstructor  // 생성자를 사용하지 않도록 선언
@Entity
public class Product {
    @Id
    private Long product_seq;
    private String name;
    private String os_type;
    private String os_bit;
    private String description;
    @CreatedDate
    private Date created;
    @CreatedDate
    private Date updated;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CompanyProductMapping> companyProductMappingList;

    @Builder
    public Product(Long product_seq, String name, String os_type, String os_bit, String description, Date created, Date updated){
        this.product_seq = product_seq;
        this.name = name;
        this.os_type = os_type;
        this.os_bit = os_bit;
        this.description = description;
        this.created = created;
        this.updated = updated;
    }
}