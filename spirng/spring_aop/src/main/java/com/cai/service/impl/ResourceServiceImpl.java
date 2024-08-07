package com.cai.service.impl;

import com.cai.service.ResourceService;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Override
    public void saveUrl(String url, String password) {
        System.out.println("url = " + url);
        System.out.println("password = " + password);
    }
}
