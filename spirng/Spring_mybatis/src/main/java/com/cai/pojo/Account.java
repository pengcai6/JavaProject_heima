package com.cai.pojo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Account {
    public Integer id;
    public String name;
    public double money;
}
