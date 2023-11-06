CREATE TABLE produtos
(
   id              serial,
   nome            varchar(255),
   categoria       varchar(255),
   preco           float8,
   codigo_barra    varchar(255),
   codigo_produto  varchar(255),
   descricao       varchar(255),
   qtde_estoque    integer,
   caminho_imagem  varchar(255),
   id_fornecedor   bigint
);    