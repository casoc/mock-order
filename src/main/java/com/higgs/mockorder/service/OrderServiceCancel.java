/**
 * BrandBigData.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.higgs.mockorder.service;

import com.higgs.mockorder.dao.OrderDAO;
import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.CompensableContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenshiwei
 * @version $Id: OrderServiceCancel.java, v 0.1 2017/11/22 17:41 chenshiwei Exp $
 */
@Service("orderServiceCancel")
public class OrderServiceCancel implements OrderService, CompensableContextAware {

    private final Logger logger = LoggerFactory.getLogger(OrderServiceCancel.class);

    private CompensableContext compensableContext;

    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean rechargeAmount(Integer userId, Long amount) {
        logger.error("cancel recharge amount for userId:{}, amount:{}", userId, amount);
        Integer orderId = (Integer) compensableContext.getVariable("orderId");
        orderDAO.delete(orderId);
        return true;
    }

    @Override
    public void setCompensableContext(CompensableContext compensableContext) {
        this.compensableContext = compensableContext;
    }
}
