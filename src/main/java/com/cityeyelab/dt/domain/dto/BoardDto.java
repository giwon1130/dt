package com.cityeyelab.dt.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data   // getter / setter / toString() 사용
@NoArgsConstructor  // 생성자를 사용하지 않도록 선언
public class BoardDto {
    private Integer uid;
    private String subject;
    private String contents;
    private String name;
    private String viewcnt;
    private String regdate;

    public BoardDto(int uid, String subject, String contents, String name, String viewcnt, String regdate){
        this.uid = uid;
        this.subject = subject;
        this.contents = contents;
        this.name = name;
        this.viewcnt = viewcnt;
        this.regdate = regdate;
    }
}