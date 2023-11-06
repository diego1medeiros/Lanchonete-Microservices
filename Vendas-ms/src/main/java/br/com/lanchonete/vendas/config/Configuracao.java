package br.com.lanchonete.vendas.config;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracao {

  @Bean
 ModelMapper obterModelMapper() {
        return new ModelMapper();
    }

// configurações do Rabbitmq//
  
//listener Cliente//
  
	@Bean
	FanoutExchange fanoutExchangeCliente() {
		return ExchangeBuilder.fanoutExchange("cliente.lista").build();
	}

	@Bean
	FanoutExchange deadLetterExchangeCliente() {
		return ExchangeBuilder.fanoutExchange("cliente.dlx").build();
	}


	@Bean
	Queue criarFilaCliente() {
		return QueueBuilder.nonDurable("cliente.detalhes-venda").deadLetterExchange("cliente.dlx").build();
	}

	@Bean
	Queue criarFilaDlqCliente() {
		return QueueBuilder.nonDurable("cliente.detalhes-venda-dlq").build();
	}
	
	@Bean
	Binding bindCliente() {
		return BindingBuilder.bind(criarFilaCliente()).to(fanoutExchangeCliente());
	}

	@Bean
	Binding bindDlxCliente() {
		return BindingBuilder.bind(criarFilaDlqCliente()).to(deadLetterExchangeCliente());
	}

	//listener Cliente//
	
	//listener Produto//
	
	@Bean
	Queue criarFilaProduto() {
		return QueueBuilder.nonDurable("produtos.detalhes-venda").deadLetterExchange("produto.dlx").build();
	}

	@Bean
	Queue criarFilaDlqProduto() {
		return QueueBuilder.nonDurable("produtos.detalhes-venda-dlq").build();
	}

	@Bean
	FanoutExchange fanoutExchangeProduto() {
		return ExchangeBuilder.fanoutExchange("produto.lista").build();
	}

	@Bean
	FanoutExchange deadLetterExchangeProduto() {
		return ExchangeBuilder.fanoutExchange("produto.dlx").build();
	}

	@Bean
	Binding bindProduto() {
		return BindingBuilder.bind(criarFilaProduto()).to(fanoutExchangeProduto());
	}

	@Bean
	Binding bindDlxProduto() {
		return BindingBuilder.bind(criarFilaDlqProduto()).to(deadLetterExchangeProduto());
	}
	
	//listener Produto//

	//listener Funcionario//

	
	@Bean
	FanoutExchange fanoutExchangeFuncionario() {
		return ExchangeBuilder.fanoutExchange("funcionario.lista").build();
	}

	@Bean
	FanoutExchange deadLetterExchangeFuncionario() {
		return ExchangeBuilder.fanoutExchange("funcionario.dlx").build();
	}


	@Bean
	Queue criarFilaFuncionario() {
		return QueueBuilder.nonDurable("funcionario.detalhes-venda").deadLetterExchange("funcionario.dlx").build();
	}

	@Bean
	Queue criarFilaDlqFuncionario() {
		return QueueBuilder.nonDurable("funcionario.detalhes-venda-dlq").build();
	}
	
	@Bean
	Binding bindFuncionario() {
		return BindingBuilder.bind(criarFilaFuncionario()).to(fanoutExchangeFuncionario());
	}

	@Bean
	Binding bindDlxFuncionario() {
		return BindingBuilder.bind(criarFilaDlqFuncionario()).to(deadLetterExchangeFuncionario());
	}

	//listener Funcionario//

	@Bean
	RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	ApplicationListener<ApplicationEvent> inicializarAdmin(RabbitAdmin rabbitAdmin) {
		return event -> rabbitAdmin.initialize();
	}
	
	@Bean
	Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter);
		return rabbitTemplate;
	}
	
	
	// fim da configurações do Rabbitmq//


}

