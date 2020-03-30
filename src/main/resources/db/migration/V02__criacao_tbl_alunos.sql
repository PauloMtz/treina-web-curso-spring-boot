create table alunos (
	id bigint not null auto_increment primary key,
	nome varchar(50),
	email varchar(50),
	instituicao_id bigint not null,
	foreign key(instituicao_id) references instituicoes(id)
);