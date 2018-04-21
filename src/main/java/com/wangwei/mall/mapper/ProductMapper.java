package com.wangwei.mall.mapper;

import com.wangwei.mall.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangwei on 2018/4/21.
 */
public interface ProductMapper {

    int saveOrUpdate(Product product);

    int deleteById(@Param("id") Integer id);

    Product getById(@Param("id") Integer id);

    List<Product> getAll();
}
