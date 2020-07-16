package com.order.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.dto.OrderDto;
import com.order.service.dto.StatusVo;
import com.order.service.response.StandardResponse;
import com.order.service.service.orderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="/orders",description="orders creation and retrieval")
@RestController
@RequestMapping(path="/orders")
@CrossOrigin(maxAge = 3600, origins = "*")
public class OrderController {
	@Autowired
	private orderService orderService;
	
	
	@ApiOperation(value = "Save Order Items")
	@PostMapping("/order")
	public StandardResponse<StatusVo> saveOrder(@RequestBody OrderDto orderDto) {
		StandardResponse<StatusVo> standardResponse = new StandardResponse<StatusVo>();
		standardResponse.setResponseOK();
		standardResponse.setData(orderService.saveOrder(orderDto));
		return standardResponse;
	}
	
	@ApiOperation(value = "Returns the results of order")
	@GetMapping("/orders-list")
	public StandardResponse<List<OrderDto>> OrderedItems() {
		StandardResponse<List<OrderDto>> standardResponse = new StandardResponse<List<OrderDto>>();
		standardResponse.setResponseOK();
		standardResponse.setData(orderService.orders());
		return standardResponse;
	}


}
