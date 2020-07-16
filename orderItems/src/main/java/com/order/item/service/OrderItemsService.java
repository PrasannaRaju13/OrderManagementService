package com.order.item.service;

import java.util.List;

import com.order.item.dto.OrderItemsDto;
import com.order.item.dto.StatusVo;

public interface OrderItemsService {
	
	List<OrderItemsDto> OrderedItems();

	StatusVo addOrderItem(OrderItemsDto orderItemsDto);
}
