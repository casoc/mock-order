/**
 * BrandBigData.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.higgs.mockorder.service;

import com.higgs.mockorder.dao.OrderDOMapper;
import com.higgs.mockorder.domain.OrderDO;
import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.CompensableContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenshiwei
 * @version $Id: OrderServiceConfirm.java, v 0.1 2017/11/22 17:37 chenshiwei Exp $
 */
@Service("orderServiceConfirm")
public class OrderServiceConfirm implements OrderService, CompensableContextAware {

    private final Logger logger = LoggerFactory.getLogger(OrderServiceConfirm.class);

    private CompensableContext compensableContext;

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Override
    @Transactional
    public boolean rechargeAmount(Integer userId, Long amount) {
        logger.error("confirm recharge amount for userId:{}, amount:{}", userId, amount);
        Integer orderId = (Integer) compensableContext.getVariable("orderId");
        OrderDO one = orderDOMapper.selectByPrimaryKey(orderId);
        one.setStatus("SUCCESS");
        orderDOMapper.updateByPrimaryKey(one);
        return true;
    }

    @Override
    public void setCompensableContext(CompensableContext compensableContext) {
        this.compensableContext = compensableContext;
    }
}
