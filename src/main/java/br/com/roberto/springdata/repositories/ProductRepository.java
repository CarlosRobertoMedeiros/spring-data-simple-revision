package br.com.roberto.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roberto.springdata.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
