package br.com.roberto.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roberto.springdata.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
