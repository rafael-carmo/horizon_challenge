INSERT INTO cidade (id, nome, uf) VALUES (1, 'Salvador', 'BA');
INSERT INTO cidade (id, nome, uf) VALUES (2, 'Feira de Santana', 'BA');
INSERT INTO cidade (id, nome, uf) VALUES (3, 'São Paulo', 'SP');
INSERT INTO cidade (id, nome, uf) VALUES (4, 'Rio de Janeiro', 'RJ');
INSERT INTO cidade (id, nome, uf) VALUES (5, 'Gramado', 'RS');
INSERT INTO cidade (id, nome, uf) VALUES (6, 'Recife', 'PE');
INSERT INTO cidade (id, nome, uf) VALUES (7, 'Olinda', 'PE');

INSERT INTO aeroporto(id, codigo_iata, nome, cidade_id) VALUES (1, 'SSP', 'Aeroporto Internacional Dep. Luís Eduardo Magalhães', 1);
INSERT INTO aeroporto(id, codigo_iata, nome, cidade_id) VALUES (2, 'GIG', 'Aeroporto Internacional Antônio Carlos Jobim', 1);
INSERT INTO aeroporto(id, codigo_iata, nome, cidade_id) VALUES (3, 'GRU', 'Aeroporto Internacional de Guarulhos', 3);

INSERT INTO voo(id, cancelado, numero, aeroporto_destino_id, aeroporto_origem_id, data_partida) VALUES (1, false, 12, 3, 1, '2023-12-15 10:30:00');
INSERT INTO voo(id, cancelado, numero, aeroporto_destino_id, aeroporto_origem_id, data_partida)	VALUES (2, false, 13, 2, 1, '2024-01-15 20:00:00');

INSERT INTO classe(id, qtd_assentos, tipo, valor, voo_id) VALUES (1, 20, 'A', 1500.00, 1);
INSERT INTO classe(id, qtd_assentos, tipo, valor, voo_id) VALUES (2, 30, 'B', 1000.00, 1);
INSERT INTO classe(id, qtd_assentos, tipo, valor, voo_id) VALUES (3, 40, 'C', 500.00, 1);
INSERT INTO classe(id, qtd_assentos, tipo, valor, voo_id) VALUES (4, 20, 'A', 3500.00, 2);

INSERT INTO passageiro(id, cpf, data_nascimento, nome) VALUES (1, '1234567', '1983-08-26', 'Rafael Linsmar');
INSERT INTO passageiro(id, cpf, data_nascimento, nome) VALUES (2, '12345', '2021-07-20', 'Nana Carolina');
INSERT INTO passageiro(id, cpf, data_nascimento, nome) VALUES (3, '1234', '1983-08-26', 'Aline Carla');

INSERT INTO comprador(id, cpf, data_nascimento, email, nome) VALUES (1, '1234567', '1983-08-26', 'rafae@teste.com', 'Rafael Linsmar');
INSERT INTO comprador(id, cpf, data_nascimento, email, nome) VALUES (2, '1234', '1980-07-20', 'aline@teste.com', 'Aline Carla');

INSERT INTO passagem(id, cancelada, despacho_bagagem, numero, preco, classe_id, comprador_id, passageiro_id) VALUES (1, false, false, 123, 1500.00, 1, 1, 1);
INSERT INTO passagem(id, cancelada, despacho_bagagem, numero, preco, classe_id, comprador_id, passageiro_id) VALUES (2, false, false, 124, 1500.00, 1, 1, 2);
INSERT INTO passagem(id, cancelada, despacho_bagagem, numero, preco, classe_id, comprador_id, passageiro_id) VALUES (3, false, false, 12345, 1500.00, 1, 1, 3);