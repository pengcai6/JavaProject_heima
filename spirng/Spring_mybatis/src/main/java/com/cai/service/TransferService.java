package com.cai.service;

import org.springframework.transaction.annotation.Transactional;


public interface TransferService {
    @Transactional
    void Transfer(String out,String in,Double money);
}
