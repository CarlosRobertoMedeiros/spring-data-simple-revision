package br.com.roberto.springdata.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.roberto.springdata.entities.Order;
import br.com.roberto.springdata.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	private OrderService orderService;

	public OrderController() {
	}

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order order = orderService.findById(id);
		return ResponseEntity.ok(order);
	}	
}
