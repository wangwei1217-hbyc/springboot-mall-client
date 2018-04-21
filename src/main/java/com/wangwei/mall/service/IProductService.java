package com.wangwei.mall.service;

import com.wangwei.mall.pojo.Product;

import java.util.List;

/**
 * Created by wangwei on 2018/4/21.
 */
public interface IProductService {

    int add(Product product);

    int deleteById(Integer id);

    Product getById(Integer id);

    List<Product> getListWithPage(Integer pageNo, Integer pageSize);
}
