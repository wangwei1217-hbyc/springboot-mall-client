package com.wangwei.mall.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wangwei.mall.mapper.ProductMapper;
import com.wangwei.mall.pojo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品业务
 */
@Service
public class ProductService implements IProductService {

    @Resource
    private ProductMapper productMapper;

    public int add(Product product){
        return productMapper.saveOrUpdate(product);
    }

    public int deleteById(Integer id){
        return productMapper.deleteById(id);
    }

    public Product getById(Integer id){
        return productMapper.getById(id);
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    public List<Product> getListWithPage(Integer pageNo,Integer pageSize){

        //将参数传给这个方法就可以实现物理分页了，非常简单。
        if(pageNo!=null && pageSize!=null){
            PageHelper.startPage(pageNo, pageSize);
        }

        return productMapper.getAll();
    }
}
