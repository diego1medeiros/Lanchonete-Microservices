create table funcionarios(

    id serial not null primary key,
    nome varchar(100) not null,
    email varchar(100) not null ,
    cpf varchar(100) not null,
    telefone varchar(100) not null ,
    funcao varchar(100) not null ,
    login varchar(100) not null ,
    senha varchar(100) not null ,
    salario float8 not null ,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    cep varchar(9) not null,
    numero varchar(20),
    estado char(2) not null
   
    );
    