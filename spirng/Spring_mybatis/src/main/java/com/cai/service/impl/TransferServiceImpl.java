package com.cai.service.impl;

import com.cai.dao.AccountDao;
import com.cai.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    private com.cai.dao.AccountDao AccountDao;
    /**
     * 转钱方法
     * @param out 转账者
     * @param in 转入者
     * @param money 金额大小
     */
    @Override
    public void Transfer(String out, String in, Double money) {
        AccountDao.outMoney(out,100d);
        int i=1/0;
        AccountDao.inMoney(in,100d);
    }
}
