package br.com.lanchonete.vendas.rabbitrmq;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lanchonete.vendas.dto.ListaFuncionarioDto;
import br.com.lanchonete.vendas.service.CaixaService;

@Component
public class FuncionarioConsumer {

    @Autowired
    private CaixaService caixaService;

    @RabbitListener(
            queues="funcionario.detalhes-venda"
    )
    public void receber(
            List<ListaFuncionarioDto> lista){

        caixaService.listarDeFuncionarios(lista);

    }

}