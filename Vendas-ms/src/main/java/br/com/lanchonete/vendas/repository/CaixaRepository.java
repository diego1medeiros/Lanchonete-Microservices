package br.com.lanchonete.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lanchonete.vendas.model.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Long>{

}
