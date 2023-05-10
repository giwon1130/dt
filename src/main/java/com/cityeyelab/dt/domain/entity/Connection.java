package com.cityeyelab.dt.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data   // getter / setter / toString() 사용
@NoArgsConstructor  // 생성자를 사용하지 않도록 선언
@Entity
public class Connection {
    @Id
    private Integer id;
    private Integer company_seq;
    private Integer product_seq;

    @Builder
    public Connection(int id, int company_seq, int product_seq){
        this.id = id;
        this.company_seq = company_seq;
        this.product_seq = product_seq;
    }
}