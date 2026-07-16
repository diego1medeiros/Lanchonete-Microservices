package br.com.lanchonete.funcionario.rabbitmq;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lanchonete.funcionario.dto.ListarFuncionarioDto;

@Component
public class FuncionarioProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarFuncionarios(
            List<ListarFuncionarioDto> lista){

        rabbitTemplate.convertAndSend(
                "funcionario.detalhes-venda",
                "",
                lista
        );

    }

}