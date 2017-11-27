package com.higgs.mockorder;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ImportResource;

@ImportResource({ "classpath:bytetcc-supports-springcloud.xml" })
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients("com.higgs.mockorder.facade")
@SpringBootApplication(scanBasePackages = "com.higgs.mockorder")
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class MockOrderApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MockOrderApplication.class).bannerMode(Banner.Mode.OFF).web(true).run(args);
    }
}
