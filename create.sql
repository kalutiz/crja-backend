create table tb_departamento (id int8 generated by default as identity, titulo varchar(255), primary key (id));
create table tb_pessoa (id int8 generated by default as identity, nome varchar(255), departamento_id int8, primary key (id));
create table tb_tarefa (id int8 generated by default as identity, descricao varchar(255), duracao int8, finalizado boolean, pessoa_id int8, prazo TIMESTAMP WITHOUT TIME ZONE, titulo varchar(255), departamento_id int8, primary key (id));
alter table if exists tb_pessoa add constraint FKmdcl3lemu5ms9f9gpmty5gs8e foreign key (departamento_id) references tb_departamento;
alter table if exists tb_tarefa add constraint FKpw7smqi3w6p4vwfl8et1a1gop foreign key (departamento_id) references tb_departamento;
INSERT INTO tb_departamento(titulo) VALUES ('Financeiro');
INSERT INTO tb_departamento(titulo) VALUES ('Comercial');
INSERT INTO tb_departamento(titulo) VALUES ('Desenvolvimento');
INSERT INTO tb_Pessoa(nome, Departamento_id) VALUES ('Camila', 1);
INSERT INTO tb_Pessoa(nome, Departamento_id) VALUES ('Pedro', 2);
INSERT INTO tb_Pessoa(nome, Departamento_id) VALUES ('Fabiano', 3);
INSERT INTO tb_Pessoa(nome, Departamento_id) VALUES ('Raquel', 3);
INSERT INTO tb_Pessoa(nome, Departamento_id) VALUES ('Patricia', 3);
INSERT INTO tb_Pessoa(nome, Departamento_id) VALUES ('Joaquim', 1);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES ('Validar NF Janeiro', 'Validar notas recebidas no mês de Janeiro', TIMESTAMP WITH TIME ZONE '2022-02-15T00:00:00Z', 1, 14, 1, true);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES ('Bug 352', 'Corrigir bug 352 na versão 1.25', TIMESTAMP WITH TIME ZONE '2022-05-10T00:00:00Z', 3, 25, null, false);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES ('Liberação da versão 1.24', 'Disponibilzar pacote para testes', TIMESTAMP WITH TIME ZONE '2022-02-02T00:00:00Z', 3, 2, 3, false);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES ('Reunião A', 'Reunião com cliente A para apresentação do produto ', TIMESTAMP WITH TIME ZONE '2022-02-05T00:00:00Z', 2, 5, null, false);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES ('Reunião final', 'Fechamento contrato', TIMESTAMP WITH TIME ZONE '2022-03-28T00:00:00Z', 2, 6, null, false);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES ('Pagamento 01/2022', 'Realizar pagamento dos fornecedores', TIMESTAMP WITH TIME ZONE '2022-01-31T00:00:00Z', 1, 6, 1, true);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES ('Bug 401', 'Corrigir bug 401 na versão 1.25', TIMESTAMP WITH TIME ZONE '2022-02-01T00:00:00Z', 3, 2, 4, true);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES ('Bug 399', 'Corrigir bug 399 na versão 1.25', TIMESTAMP WITH TIME ZONE '2022-01-28T00:00:00Z', 3, 6, 5, true);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES ('Reunião B', 'Reunião com cliente B para apresentação do produto', TIMESTAMP WITH TIME ZONE '2022-01-31T00:00:00Z', 2, 5, 2, true);
INSERT INTO tb_tarefa(titulo, descricao, prazo, departamento_id, duracao, pessoa_id, finalizado) VALUES ('Validar NF Fevereiro', 'Validar notas recebidas no mês de Fevereiro', TIMESTAMP WITH TIME ZONE '2022-03-15T00:00:00Z', 1, 14, 6, false);
