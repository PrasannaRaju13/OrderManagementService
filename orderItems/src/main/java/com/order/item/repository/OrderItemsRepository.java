package com.order.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.item.dto.OrderItemsDto;
import com.order.item.entity.OrderItems;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer>{
	
	@Query(value="select new com.order.item.dto.OrderItemsDto(orderItems.orderItemId,orderItems.productCode,orderItems.productName,orderItems.quantity) from OrderItems orderItems ")
	 List<OrderItemsDto> getOrderedItems();
}
