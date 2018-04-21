package com.wangwei.mall.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品实体
 */
public class Product {
    private Integer id;
    private String pname;
    private BigDecimal price;
    private Integer num;
    private String type;
    /*
    @DatetimeFormat是将String转换成Date，一般前台给后台传值时用
    @JsonFormat(pattern="yyyy-MM-dd")  将Date转换成String  一般后台传值给前台时.
    @JsonFormat会让时间以0区时间显示。如果直接使用会少了8小时（我所在的是北京时区）,
        需添加 ：timezone = "GMT+8",
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy年MM月dd日 HH:mm:ss")
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", type='" + type + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
