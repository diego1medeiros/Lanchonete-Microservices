create table fornecedores(

    id serial not null primary key,
    razao_social varchar(100) not null,
    email varchar(100) not null unique,
    cnpj varchar(100) not null unique,
    telefone varchar(100) not null unique,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    cep varchar(9) not null,
    numero varchar(20),
    estado char(2) not null
  
    );
    