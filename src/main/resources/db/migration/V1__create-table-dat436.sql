create table dat436 (

    id_dat436 bigint not null auto_increment,
    nome_fornecedor varchar(40) not null,
    nome_fantasia varchar(15) not null,
    nome_compras varchar(15) not null,
    classe_juridico varchar(1) not null,
    cnpj_cpf varchar(18),
    num_inscr_estad varchar(15),
    num_inscr_munip varchar(15),
    id_estrangeiro varchar(20),
    cod_logradouro varchar(20) not null,
    end_rua varchar(40) not null,
    end_numero varchar(10) not null,
    end_compl varchar(15),
    num_cep varchar(8),
    end_bairro varchar(40) not null,
    end_cidade varchar(40) not null,
    sigl_estado varchar(2) not null,
    cod_cidade varchar(4),
    email varchar(70) not null,
    email_nfe varchar(70),
    telefone varchar(15),

    primary key(id_dat436)
);