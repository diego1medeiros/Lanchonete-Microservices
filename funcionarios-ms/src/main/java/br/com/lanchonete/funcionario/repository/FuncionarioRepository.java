package br.com.lanchonete.funcionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lanchonete.funcionario.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
