package com.lzh.web;

import com.lzh.domain.base.CommonCode;
import com.lzh.domain.base.ResponseResult;
import com.lzh.domain.product.Product;
import com.lzh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("get/{id}")
    @ResponseBody
    public ResponseResult<Product> getCourseById(@PathVariable String id){
        Product product = productService.getById(id);
        ResponseResult<Product> productResponseResult = new ResponseResult<>(CommonCode.SUCCESS, product);
        return productResponseResult;
    }
}
