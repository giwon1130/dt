package com.cityeyelab.dt.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Company {
    @Id
    private Long companySeq;
    private String name;
    private String email;
    private String address;
    private String description;
    @CreatedDate
    private Date created;
    @CreatedDate
    private Date updated;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CompanyProductMapping> companyProductMappingList;


    @Builder
    public Company(Long companySeq, String name, String email, String address, String description, Date created, Date updated){
        this.companySeq = companySeq;
        this.name = name;
        this.email = email;
        this.address = address;
        this.description = description;
        this.created = created;
        this.updated = updated;
    }
}