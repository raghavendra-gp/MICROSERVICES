package com.te.adminservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user-service", url = "http://localhost:9003/user/")
public interface AdminFeign {

}
