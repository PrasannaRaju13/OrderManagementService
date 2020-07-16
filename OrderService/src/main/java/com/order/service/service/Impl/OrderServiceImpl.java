package com.order.service.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order.service.constants.ExceptionConstants;
import com.order.service.dto.CommonUtils;
import com.order.service.dto.OrderDto;
import com.order.service.dto.OrderItemsDto;
import com.order.service.dto.StatusVo;
import com.order.service.entity.Order;
import com.order.service.entity.OrderServiceItem;
import com.order.service.exceptions.BaseException;
import com.order.service.feignclient.OrderItemsServiceFeignClient;
import com.order.service.repository.OrderRepository;
import com.order.service.response.StandardResponse;
import com.order.service.service.orderService;

@Service
public class OrderServiceImpl implements orderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired(required=true)
	private OrderItemsServiceFeignClient orderItemsServiceFeignClient;
	
	@Override
	@Transactional
	public StatusVo saveOrder(OrderDto orderDto) {
		StatusVo statusVo=new StatusVo();		
		StandardResponse<List<OrderItemsDto>> itemsDtos=orderItemsServiceFeignClient.OrderedItems();
		List<OrderItemsDto> orderItemsDto =new ArrayList<OrderItemsDto>();
		
		for(OrderItemsDto oid:itemsDtos.getData())
			orderItemsDto.add(oid);
	
		if(Objects.nonNull(orderDto))
		{
			Order order=new Order();
			order.setCustomerName(orderDto.getCustomerName());
			order.setOrderDate(orderDto.getOrderDate());
			order.setShippingAddress(orderDto.getShippingAddress());
			order.setTotal(orderDto.getTotal());
			order=orderRepository.save(order);
		    statusVo.setKey(order.getOrderId());
		    statusVo.setStatus(CommonUtils.SUCCESS);
		    
		    OrderServiceItem orderServiceItem=new OrderServiceItem();
		    orderServiceItem.setOrderItemId(itemsDtos.getData().iterator().next().getOrderItemId());
		    orderServiceItem.setOrderId(order.getOrderId());
		}
		else {
			throw new BaseException(ExceptionConstants.ORDER_SAVE,ExceptionConstants.ORDER_SERVICE_MANAGMENT); 
		}
		return statusVo;
	}

	@Override
	public List<OrderDto> orders() {
		List<OrderDto> orders=new ArrayList<OrderDto>();
		orders=orderRepository.Orders();
		if(Objects.nonNull(orders))
		{
			return orders;

		}
		else
		{
			throw new BaseException(ExceptionConstants.ORDERS_NOT_FOUND,ExceptionConstants.ORDER_SERVICE_MANAGMENT); 
		}
	}		    

	
	
	
	
	
	
	

}
