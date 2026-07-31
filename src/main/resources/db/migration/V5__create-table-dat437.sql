create table dat437(

    recnum bigint not null auto_increment,
    id_dat436 bigint not null,

    nome varchar(40) not null,
    departamento varchar(30) ,
    cargo varchar(30),
    telefone varchar(15),
    email varchar(70),
    observacao varchar(70),
    principal varchar(1),

    primary key(recnum),

    constraint fk_dat437_id_dat436 foreign key(id_dat436) references dat436(id_dat436)

);