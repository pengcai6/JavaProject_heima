package com.cai.Service.impl;

import com.cai.Service.ResourceService;

import java.util.*;

public class ResourceServiceImpl implements ResourceService {
    private String []array ;
    private List<String> list;
    private Set<String> set;
    private Map<String,String>map;
    private Properties properties;

    @Override
    public String toString() {
        return "ResourceServiceImpl{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
