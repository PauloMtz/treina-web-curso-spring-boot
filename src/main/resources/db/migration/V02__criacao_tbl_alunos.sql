create table alunos (
	id bigint not null auto_increment primary key,
	nome varchar(50),
	email varchar(50),
	id_instituicao bigint not null,
	foreign key (id_instituicao) references instituicoes (id)
);