package com.xzwb.pojo;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("boss")
public class Boss {
    private List<String> car;

    public List<String> getCar() {
        return car;
    }

    public void setCar(List<String> car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                ", name='" + name + '\'' +
                '}';
    }

    private String name;
}
