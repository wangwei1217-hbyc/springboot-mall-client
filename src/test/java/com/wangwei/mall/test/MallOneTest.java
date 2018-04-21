package com.wangwei.mall.test;

import org.junit.Test;
import org.nutz.http.Http;
import org.nutz.http.Response;

/**
 * Created by wangwei on 2018/4/21.
 */
public class MallOneTest {

    @Test
    public void testGetAll(){
        String url = "http://127.0.0.1:8080/getAll";
        Response response = Http.get(url);
        System.out.println(response.getStatus());
        System.out.println(response.getContent());
    }
}
