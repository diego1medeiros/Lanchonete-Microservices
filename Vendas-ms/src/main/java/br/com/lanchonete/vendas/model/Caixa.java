package br.com.lanchonete.vendas.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "movimentacaocaixa")
public class Caixa{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "tipomovimento")
	private String tipoMovimento;
	private Date data;
	@Column(name = "valor_total")
	private double valorTotal;
	@Column(name = "valor_caixa")
	private double valorCaixa;
	private String observacao;
	@Column(name = "id_funcionario")
	private Long funcionarioId ;

	
}
