package br.com.lanchonete.vendas.rabbitrmq;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lanchonete.vendas.dto.ProdutoDto;
import br.com.lanchonete.vendas.service.VendaService;

@Component
public class ProdutoConsumer {

    @Autowired
    private VendaService vendaService;

    @RabbitListener(
            queues="produto.detalhes-venda"
    )
    public void receber(
            List<ProdutoDto> lista){

        vendaService.listarDeProdutos(lista);

    }

}
