/**
 * BrandBigData.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */
package com.higgs.mockorder.facade;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenshiwei
 * @version $Id: UserFacade.java,  0.1 2017/11/22 17:02 chenshiwei Exp $
 */
@FeignClient(value = "MOCK-USER-CENTER")
public interface UserFacade {

    @RequestMapping(value = "/user/increase/amount", method = RequestMethod.GET)
    Boolean increaseAmount(@RequestParam("userId") Integer userId, @RequestParam("amount") Long amount);

}
