package br.com.lanchonete.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lanchonete.cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
