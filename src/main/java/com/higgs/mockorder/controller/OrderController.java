/**
 * BrandBigData.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.higgs.mockorder.controller;

import com.higgs.mockorder.service.OrderService;
import org.bytesoft.compensable.Compensable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenshiwei
 * @version $Id: OrderController.java, v 0.1 2017/11/21 19:30 chenshiwei Exp $
 */
@RestController
@Compensable(interfaceClass = OrderService.class, confirmableKey = "orderServiceConfirm", cancellableKey = "orderServiceCancel")
public class OrderController {

    @Resource(name = "orderService")
    private OrderService orderService;

    @RequestMapping(value = "order/recharge", method = RequestMethod.POST)
    @Transactional
    public boolean rechargeAmount(Integer userId, Long amount) {
        boolean result = false;
        result = orderService.rechargeAmount(userId, amount);
        int i = 1 / 0;
        return result;
    }

}
