package br.com.lanchonete.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lanchonete.produtos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
