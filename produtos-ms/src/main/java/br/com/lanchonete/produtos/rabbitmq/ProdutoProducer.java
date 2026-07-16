package br.com.lanchonete.produtos.rabbitmq;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lanchonete.produtos.dto.ListaProdutoDto;

@Component
public class ProdutoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarProdutos(List<ListaProdutoDto> produtos){

        rabbitTemplate.convertAndSend(
                "produtos.detalhes-venda",
                "",
                produtos
        );
    }

}