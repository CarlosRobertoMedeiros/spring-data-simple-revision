package br.com.roberto.springdata;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.roberto.springdata.entities.Client;
import br.com.roberto.springdata.entities.Order;
import br.com.roberto.springdata.entities.OrderItem;
import br.com.roberto.springdata.entities.OrderStatus;
import br.com.roberto.springdata.entities.Product;
import br.com.roberto.springdata.repositories.ClientRepository;
import br.com.roberto.springdata.repositories.OrderItemRepository;
import br.com.roberto.springdata.repositories.OrderRepository;
import br.com.roberto.springdata.repositories.ProductRepository;

@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {

	private ClientRepository clientRepository;
	private ProductRepository productRepository;
	private OrderRepository orderRepository;
	private OrderItemRepository orderItemRepository;
	
	
	public SpringdataApplication(ClientRepository clientRepository, 
								 ProductRepository productRepository, 
								 OrderRepository orderRepository,
								 OrderItemRepository orderItemRepository) {
		super();
		this.clientRepository = clientRepository;
		this.productRepository = productRepository;
		this.orderRepository = orderRepository;
		this.orderItemRepository = orderItemRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Carlos Roberto", "carlosmedeiroslima@gmail.com");
		clientRepository.save(c1);
		
		Product p1 = new Product(null,"TV",1000.0);
		Product p2 = new Product(null,"Mouse",40.0);
		Product p3 = new Product(null,"PC",1200.0);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Order o1 = new Order(null,Instant.parse("2021-04-18T11:25:09Z"), OrderStatus.PAID, c1);
		Order o2 = new Order(null,Instant.parse("2021-04-20T11:25:09Z"), OrderStatus.WAITING, c1);
		
		orderRepository.saveAll(Arrays.asList(o1,o2));
		
		OrderItem oi1 = new OrderItem(null, 1, 1000.0, p1, o1);
		OrderItem oi2 = new OrderItem(null, 2, 40.0, p2, o1);
		OrderItem oi3 = new OrderItem(null, 1, 40.0, p2, o2);
		OrderItem oi4 = new OrderItem(null, 1, 1200.0, p3, o2);
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

	}

}