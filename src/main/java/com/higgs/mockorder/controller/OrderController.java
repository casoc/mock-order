/**
 * BrandBigData.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.higgs.mockorder.controller;

import com.higgs.mockorder.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenshiwei
 * @version $Id: OrderController.java, v 0.1 2017/11/21 19:30 chenshiwei Exp $
 */
@RestController
public class OrderController {

    @Resource(name = "orderService")
    private OrderService orderService;

    @RequestMapping(value = "order/recharge", method = RequestMethod.POST)
    public boolean rechargeAmount(Integer userId, Long amount) {
        boolean result = false;
        try {
            result = orderService.rechargeAmount(userId, amount);
        } catch (Exception e) {

        }
        return result;
    }

}
