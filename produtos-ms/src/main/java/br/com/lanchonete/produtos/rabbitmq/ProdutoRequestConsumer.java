package br.com.lanchonete.produtos.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lanchonete.produtos.service.ProdutoService;

@Component
public class ProdutoRequestConsumer {

    @Autowired
    private ProdutoService service;

    @Autowired
    private ProdutoProducer producer;

    @RabbitListener(queues = "produto.request")
    public void solicitarProdutos(String mensagem){

        producer.enviarProdutos(
                service.listarProdutos()
        );
    }

}