package com.lzh.domain.product;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class Product {
    private String pid;
    private String pname;
    private double price;
    private Integer num;
    private Date ptime;
}
