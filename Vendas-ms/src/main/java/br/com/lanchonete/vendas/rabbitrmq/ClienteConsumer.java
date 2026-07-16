package br.com.lanchonete.vendas.rabbitrmq;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lanchonete.vendas.dto.ClienteDto;
import br.com.lanchonete.vendas.service.VendaService;

@Component
public class ClienteConsumer {

    @Autowired
    private VendaService vendaService;

    @RabbitListener(
            queues="cliente.detalhes-venda"
    )
    public void receber(
            List<ClienteDto> lista){

        vendaService.listarDeClientes(lista);

    }

}