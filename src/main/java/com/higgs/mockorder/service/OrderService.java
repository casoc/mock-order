/**
 * BrandBigData.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.higgs.mockorder.service;

/**
 * @author chenshiwei
 * @version $Id: OrderService.java, v 0.1 2017/11/21 19:27 chenshiwei Exp $
 */
public interface OrderService {

    boolean rechargeAmount(Integer userId, Long amount);

}
