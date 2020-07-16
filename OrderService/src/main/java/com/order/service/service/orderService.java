package com.order.service.service;

import java.util.List;

import com.order.service.dto.OrderDto;
import com.order.service.dto.StatusVo;

public interface orderService {
	
	StatusVo saveOrder(OrderDto orderDto);
	List<OrderDto> orders();
}
