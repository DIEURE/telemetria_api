create table perfis (perfis integer, usuario_id bigint not null);
create table tb_usuarios (data_criacao date, id bigserial not null, email varchar(255), nome varchar(255), senha varchar(255), status varchar(255), tipo varchar(255), primary key (id));
alter table if exists perfis add constraint FKt042uk1cutmog19g19c90uy3a foreign key (usuario_id) references tb_usuarios;
