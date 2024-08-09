package com.cai.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
    //同学们自己添加getter、setter、toString()方法
}