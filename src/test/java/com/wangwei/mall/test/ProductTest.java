package com.wangwei.mall.test;

import com.github.pagehelper.PageInfo;
import com.wangwei.mall.pojo.Product;
import com.wangwei.mall.service.IProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by wangwei on 2018/4/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Resource
    private IProductService productService;

    @Test
    public void testInsert() throws Exception{
        Product product = new Product();
        product.setPname("华硕笔记本-飞行堡垒");
        product.setNum(20);
        product.setPrice(new BigDecimal("6899.00"));
        product.setType("笔记本");
        int data = productService.add(product);
        Assert.assertEquals(data,1);
    }

    @Test
    public void testGetById(){
        Product product = productService.getById(1);
        System.out.println(product);
    }

    @Test
    public void testGetWithPage(){
        List<Product> products = productService.getListWithPage(1, 2);
        System.out.println(products.size());
        for(Product product : products){
            System.out.println(product);
        }
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        List<Product> list = pageInfo.getList();
        System.out.println("list:"+list);
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getPageSize());
        System.out.println(pageInfo.getPages());//总页数
        System.out.println(pageInfo.getTotal());//总记录数
    }
}
