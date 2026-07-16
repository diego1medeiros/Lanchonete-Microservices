package br.com.lanchonete.funcionario.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lanchonete.funcionario.service.FuncionarioService;

@Component
public class FuncionarioRequestConsumer {

    @Autowired
    private FuncionarioService service;

    @Autowired
    private FuncionarioProducer producer;

    @RabbitListener(
        queues = "funcionario.request"
    )
    public void solicitar(String msg){

        producer.enviarFuncionarios(
                service.listarFuncionarios()
        );

    }

}
