package br.com.lanchonete.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lanchonete.fornecedor.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

}
