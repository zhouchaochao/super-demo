package com.example.springbootmultidatasource.domain;

/**
 * Title:
 * Description:
 * Date:  2018/3/17
 *
 * @author <a href=mailto:zhouzhichao1024@gmail.com>chaochao</a>
 */

public class Company {

    private Integer id;
    private String name;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString(){
        return "id:" + id
                + " name:" + name
                + " phone:" + phone;
    }
}
