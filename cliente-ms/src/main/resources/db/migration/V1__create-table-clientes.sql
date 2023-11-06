create table clientes(

    id serial not null primary key,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(100) not null unique,
    telefone varchar(100) not null unique,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    cep varchar(9) not null,
    numero varchar(20),
    estado char(2) not null
   
    );
    