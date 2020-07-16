package com.order.service.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.order.service.dto.OrderItemsDto;
import com.order.service.response.StandardResponse;

@FeignClient(name="orderItem-management",url="localhost:8083")
public interface OrderItemsServiceFeignClient {
	
	@GetMapping("/orderItems/order-items")
	public StandardResponse<List<OrderItemsDto>> OrderedItems();
	
}