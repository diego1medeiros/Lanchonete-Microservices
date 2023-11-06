package br.com.lanchonete.produtos.config;

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

	// configuração rabbitmq//

	@Bean
	Queue criarFila() {
		return QueueBuilder.nonDurable("fornecedores.detalhes-produto").deadLetterExchange("fornecedor.dlx").build();
	}

	@Bean
	Queue criarFilaDlq() {
		return QueueBuilder.nonDurable("fornecedores.detalhes-produto-dlq").build();
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

	@Bean
	FanoutExchange fanoutExchange() {
		return ExchangeBuilder.fanoutExchange("fornecedor.lista").build();
	}

	@Bean
	FanoutExchange deadLetterExchange() {
		return ExchangeBuilder.fanoutExchange("fornecedor.dlx").build();
	}

	@Bean
	Binding bindFornecedoresProduto() {
		return BindingBuilder.bind(criarFila()).to(fanoutExchange());
	}

	@Bean
	Binding bindDlxFornecedoresProduto() {
		return BindingBuilder.bind(criarFilaDlq()).to(deadLetterExchange());
	}

	@Bean
	RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	ApplicationListener<ApplicationEvent> inicializarAdmin(RabbitAdmin rabbitAdmin) {
		return event -> rabbitAdmin.initialize();
	}

	@Bean
	FanoutExchange fanoutExchangeProduto() {
		return new FanoutExchange("produto.lista");
	}

	// fim da configurão rabbitmq//
}
