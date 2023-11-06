CREATE TABLE vendas
(
   id                 serial,
   data               timestamp,
   valor_total        float8,
   qtde_total         integer,
   id_cliente         bigint,
   id_tipo_pagamento  bigint,
   observacao         varchar(255)
);    
   
CREATE TABLE itemvendas
(
   id           serial,
   qtde         integer   NOT NULL,
   valor_total  float8    NOT NULL,
   id_produto   bigint,
   id_venda     bigint
);

CREATE TABLE tipopagamentos
(
   id         serial,
   descricao  varchar(100),
   codigo     varchar(255)
);

CREATE TABLE movimentacaocaixa
(
   id              bigserial,
   data            timestamp,
   observacao      varchar(255),
   tipomovimento   varchar(255),
   valor_total     float8,
   id_funcionario  bigint,
   valor_caixa     float8
);