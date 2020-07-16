package com.order.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.item.dto.OrderItemsDto;
import com.order.item.dto.StatusVo;
import com.order.item.response.StandardResponse;
import com.order.item.service.OrderItemsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="/orderItem",description="orderItems creation and retrieval")
@RestController
@RequestMapping(path="/orderItems")
@CrossOrigin(maxAge = 3600, origins = "*")
public class OrderItemsController {
	
	@Autowired
	private OrderItemsService orderItemsService;
	
	
	@ApiOperation(value = "Returns the results of order items")
	@GetMapping("/order-items")
	public StandardResponse<List<OrderItemsDto>> OrderedItems() {
		System.out.println("order-items");
		StandardResponse<List<OrderItemsDto>> standardResponse = new StandardResponse<List<OrderItemsDto>>();
		standardResponse.setResponseOK();
		standardResponse.setData(orderItemsService.OrderedItems());
		return standardResponse;
	}
	
	@ApiOperation(value = "Save Order Items")
	@PostMapping("/orderItems")
	public StandardResponse<StatusVo> addOrderItem(@RequestBody OrderItemsDto orderItemsDto) {
		System.out.println("post-items");
		StandardResponse<StatusVo> standardResponse = new StandardResponse<StatusVo>();
		standardResponse.setResponseOK();
		standardResponse.setData(orderItemsService.addOrderItem(orderItemsDto));
		return standardResponse;
	}
}




