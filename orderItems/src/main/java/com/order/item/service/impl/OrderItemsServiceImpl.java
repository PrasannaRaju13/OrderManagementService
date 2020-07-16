package com.order.item.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order.item.constants.ExceptionConstants;
import com.order.item.dto.CommonUtils;
import com.order.item.dto.OrderItemsDto;
import com.order.item.dto.StatusVo;
import com.order.item.entity.OrderItems;
import com.order.item.exceptions.BusinessException;
import com.order.item.repository.OrderItemsRepository;
import com.order.item.service.OrderItemsService;

@Service
public class OrderItemsServiceImpl implements OrderItemsService{
	
	
	@Autowired
	private OrderItemsRepository orderItemsRepository;

	@Override
	public List<OrderItemsDto> OrderedItems() {
		List<OrderItemsDto> orderItemsDtos=new ArrayList<OrderItemsDto>();
	 orderItemsDtos=orderItemsRepository.getOrderedItems();
	 if(orderItemsDtos.isEmpty()) {
		 throw new BusinessException(ExceptionConstants.ORDER_ITEM_LIST, ExceptionConstants.ORDER_ITEM_MANAGMENT,"Order Items Not Found"); 
		 
	 }
		return orderItemsDtos;
	}
	
	
	@Override
	@Transactional
	public StatusVo addOrderItem(OrderItemsDto orderItemsDto) {
		StatusVo statusVo=new StatusVo();
		if(Objects.nonNull(orderItemsDto)) {
			OrderItems orderItems=new OrderItems();
			orderItems.setProductCode(orderItemsDto.getProductCode());
			orderItems.setProductName(orderItemsDto.getProductName());
			orderItems.setQuantity(orderItemsDto.getQuantity());
			orderItems=orderItemsRepository.save(orderItems);
			statusVo.setStatus(CommonUtils.SUCCESS);
			statusVo.setKey(orderItems.getOrderItemId());
		}
		else {
			throw new BusinessException(ExceptionConstants.ORDER_ITEM_SAVE, ExceptionConstants.ORDER_ITEM_MANAGMENT,"Failed to save order Items"); 
		}
		return statusVo;
	}
	
	

}
