package com.wangwei.mall.test;

import com.wangwei.mall.util.LoadPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by wangwei on 2018/4/21.
 */
public class MallClient {

    @Test
    public void mallClient() throws Exception{
        String zooAddress = "192.168.171.130:2181";
        CuratorFramework client = CuratorFrameworkFactory.newClient(zooAddress, new RetryOneTime(1000));

        client.start();
        client.blockUntilConnected();


        ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class).client(client).basePath("/soa").build();

        Collection<ServiceInstance<Object>> serviceInstances = serviceDiscovery.queryForInstances("mall");
        ArrayList<String> addressList = new ArrayList<>();
        for(ServiceInstance instance : serviceInstances){
            System.out.println(instance.getAddress());
            System.out.println(instance.getPort());
            System.out.println("=======================");
            addressList.add(instance.getAddress()+":"+instance.getPort());
        }

        LoadPolicy loadPolicy = new LoadPolicy();
        loadPolicy.setAddressList(addressList);

        for(int i = 0;i < 10;i++){
            String address = loadPolicy.getAddress();
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject("http://" + address + "/address", String.class);
            System.out.println(result);
        }

    }
}
