package com.cityeyelab.dt.domain.dto;

import com.cityeyelab.dt.domain.entity.Company;
import com.cityeyelab.dt.domain.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Id;
import java.util.Date;


@Data   // getter / setter / toString() 사용
@NoArgsConstructor  // 생성자를 사용하지 않도록 선언
public class ProductDto {
    private Long product_seq;
    private String name;
    private String os_type;
    private String os_bit;
    private String description;
    @CreatedDate
    private Date created;
    @CreatedDate
    private Date updated;

    public ProductDto(Long product_seq, String name, String os_bit, String os_type, String description, Date created, Date updated){
        this.product_seq = product_seq;
        this.name = name;
        this.os_bit = os_bit;
        this.os_type = os_type;
        this.description = description;
        this.created = created;
        this.updated = updated;
    }

    public ProductDto(Product product) {
        this.product_seq = product.getProduct_seq();
        this.name = product.getName();
        this.os_bit = product.getOs_bit();
        this.os_type = product.getOs_type();
        this.description = product.getDescription();
        this.created = product.getCreated();
        this.updated = product.getUpdated();
    }

    public Product toEntity() {
        return Product.builder().product_seq(product_seq).name(name).os_bit(os_bit).os_type(os_type).description(description)
                .created(created)
                .updated(updated).build();
    }

}