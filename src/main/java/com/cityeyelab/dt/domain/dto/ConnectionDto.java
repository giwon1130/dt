package com.cityeyelab.dt.domain.dto;

import com.cityeyelab.dt.domain.entity.Company;
import com.cityeyelab.dt.domain.entity.Connection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;


@Data   // getter / setter / toString() 사용
@NoArgsConstructor  // 생성자를 사용하지 않도록 선언
public class ConnectionDto {
    private Integer id;
    private Integer company_seq;
    private Integer product_seq;

    public ConnectionDto(int id, int company_seq, int product_seq){
        this.id = id;
        this.company_seq = company_seq;
        this.product_seq = product_seq;
    }

    @Builder
    public ConnectionDto(Connection connection) {
        this.id = connection.getId();
        this.product_seq = connection.getProduct_seq();
        this.company_seq = connection.getCompany_seq();
    }

    public Connection toEntity() {
        return Connection.builder().company_seq(company_seq)
                .id(id)
                .product_seq(product_seq)
                .company_seq(company_seq)
                .build();
    }
}