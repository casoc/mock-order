/**
 * BrandBigData.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.higgs.mockorder.dao;

import com.higgs.mockorder.domain.OrderDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chenshiwei
 * @version $Id: OrderDAO.java, v 0.1 2017/11/21 19:18 chenshiwei Exp $
 */
public interface OrderDAO extends JpaRepository<OrderDO, Integer> {
}
