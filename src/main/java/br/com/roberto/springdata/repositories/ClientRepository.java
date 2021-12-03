package br.com.roberto.springdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.roberto.springdata.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
