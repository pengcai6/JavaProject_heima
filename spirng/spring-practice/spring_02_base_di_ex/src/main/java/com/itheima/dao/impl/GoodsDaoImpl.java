package com.itheima.dao.impl;

import com.itheima.dao.GoodsDao;
import com.itheima.domain.Goods;

public class GoodsDaoImpl implements GoodsDao {

    public void updateNum(Goods goods) {
        System.out.println("商品"+goods.getGoodsName()+"下单成功，当前下单数量1个，库存数量由"+goods.getNum()+"修改为"+(goods.getNum()-1));
    }
}
