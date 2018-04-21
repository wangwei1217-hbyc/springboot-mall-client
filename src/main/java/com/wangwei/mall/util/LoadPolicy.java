package com.wangwei.mall.util;

import java.util.List;

/**
 * Created by wangwei on 2018/4/22.
 */
public class LoadPolicy {
    private List<String> addressList;
    private Integer count=0;

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    public String getAddress(){
        if(count >= addressList.size()){
            count = 0;
        }
        String address = addressList.get(count);
        count++;

        return address;
    }
}
