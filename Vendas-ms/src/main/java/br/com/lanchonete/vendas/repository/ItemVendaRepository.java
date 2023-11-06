package br.com.lanchonete.vendas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lanchonete.vendas.model.ItemVenda;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long>{
	
	 List<ItemVenda> findByVendaId(Long id);


}
