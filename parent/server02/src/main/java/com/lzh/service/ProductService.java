package com.lzh.service;

import com.lzh.dao.ProductMapper;
import com.lzh.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product getById(String id){
        Product product = productMapper.getById(id);
        return product;
    }

}
