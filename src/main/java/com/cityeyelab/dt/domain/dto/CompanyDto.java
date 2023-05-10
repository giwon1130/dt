package com.cityeyelab.dt.domain.dto;

import com.cityeyelab.dt.domain.entity.Company;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;


@Data   // getter / setter / toString() 사용
@NoArgsConstructor  // 생성자를 사용하지 않도록 선언
public class CompanyDto {
    private Long company_seq;
    private String name;
    private String email;
    private String address;
    private String description;
    @CreatedDate
    private Date created;
    @CreatedDate
    private Date updated;

    public CompanyDto(Long company_seq, String name, String email, String address, String description, Date created, Date updated){
        this.company_seq = company_seq;
        this.name = name;
        this.email = email;
        this.address = address;
        this.description = description;
        this.created = created;
        this.updated = updated;
    }

    @Builder
    public CompanyDto(Company company) {
        this.company_seq = company.getCompanySeq();
        this.name = company.getName();
        this.email = company.getEmail();
        this.address = company.getAddress();
        this.description = company.getDescription();
        this.created = company.getCreated();
        this.updated = company.getUpdated();
    }

    public Company toEntity() {
        return Company.builder().companySeq(company_seq)
                .name(name)
                .email(email)
                .address(address)
                .description(description)
                .created(created)
                .updated(updated).build();
    }
}