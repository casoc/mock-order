/**
 * BrandBigData.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.higgs.mockorder.service;

import com.higgs.mockorder.dao.OrderDOMapper;
import com.higgs.mockorder.domain.OrderDO;
import com.higgs.mockorder.facade.UserFacade;
import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.CompensableContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;

/**
 * @author chenshiwei
 * @version $Id: OrderServiceImpl.java, v 0.1 2017/11/21 19:28 chenshiwei Exp $
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService, CompensableContextAware {

    private final Logger       logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDOMapper      orderDOMapper;

    @Autowired
    private UserFacade         userFacade;

    private CompensableContext compensableContext;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean rechargeAmount(Integer userId, Long amount) {
        logger.error("try recharge amount for userId:{}, amount:{}", userId, amount);
        OrderDO orderDO = new OrderDO();
        orderDO.setUserId(userId);
        orderDO.setStatus("PAYING");
        orderDO.setContent(MessageFormat.format("充值订单,userId:{0}, amount:{1}", userId, amount));
        orderDOMapper.insert(orderDO);
        compensableContext.setVariable("orderId", orderDO.getId());
        Boolean result = this.userFacade.increaseAmount(userId, amount);
        if (!result) {
            throw new RuntimeException("ERROR");
        }
        //        int i = 1 / 0;
        return true;
    }

    @Override
    public void setCompensableContext(CompensableContext compensableContext) {
        this.compensableContext = compensableContext;
    }
}
