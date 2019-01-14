package com.cpscs.omsadmin.client;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.cpscs.common.intercepter.FeignIntercepter;
import com.cpscs.common.utils.Result;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Headers("Content-Type:application/json")
@FeignClient(name = "api-base", configuration = FeignIntercepter.class)
public interface BaseClientServise {

    @GetMapping ("log/count")
    Result count(@RequestParam Map<String, Object> params);
}