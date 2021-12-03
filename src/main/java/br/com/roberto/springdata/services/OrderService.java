package br.com.roberto.springdata.services;

import org.springframework.stereotype.Service;

import br.com.roberto.springdata.entities.Order;
import br.com.roberto.springdata.repositories.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	
	public OrderService() {}
	
	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}


	public Order findById(Long id) {
		Order order =  orderRepository.findById(id).get();
		return order;
	}

}
