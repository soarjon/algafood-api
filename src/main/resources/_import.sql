-- INSERT COZINHA
INSERT INTO cozinha (id, nome) values (1, 'Tailandesa');
INSERT INTO cozinha (id, nome) values (2, 'Indiana');

-- INSERT ESTADO
INSERT INTO estado (id, nome) values ('1', 'Santa Catarina');
INSERT INTO estado (id, nome) values ('2', 'São Paulo');
INSERT INTO estado (id, nome) values ('3', 'Paraná');

-- INSERT CIDADE
INSERT INTO cidade (id, nome, estado_id) values ('1', 'Pomerode', '1');
INSERT INTO cidade (id, nome, estado_id) values ('2', 'Blumenau', '1');
INSERT INTO cidade (id, nome, estado_id) values ('3', 'São José do Rio Preto', '2');
INSERT INTO cidade (id, nome, estado_id) values ('4', 'Campinas', '2');
INSERT INTO cidade (id, nome, estado_id) values ('5', 'Chompinzinho', '3');
INSERT INTO cidade (id, nome, estado_id) values ('6', 'Curitiba', '3');

-- INSERT RESTAURANTE
INSERT INTO restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, endereco_cidade_id) values ('Zon Cheng Buffet', 9.50, 1, utc_timestamp, utc_timestamp, '89107-000', 'Dr. Wunderwald', '484', 'Wunderwald', 'Casa', 1);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, endereco_cidade_id) values ('Taji Zen', 10, 2, utc_timestamp, utc_timestamp, '89010-205', 'Alwin Schrader', '300', 'Centro', 'Casa', 2);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro, endereco_complemento, endereco_cidade_id) values ('Hako Sushi', 8.75, 1, utc_timestamp, utc_timestamp);

-- INSERT FORMA DE PAGAMENTO
INSERT INTO forma_de_pagamento (id, descricao) values ('1', 'Cartão de Crédito');
INSERT INTO forma_de_pagamento (id, descricao) values ('2', 'Cartão de Débito');
INSERT INTO forma_de_pagamento (id, descricao) values ('3', 'Vale Alimentação');

-- INSERT PERMISSAO
INSERT INTO permissao (id, nome, descricao) values ('1', 'Consultar Restaurantes', 'Permissão responsável por autorizar usuário a consultar restaurantes');
INSERT INTO permissao (id, nome, descricao) values ('2', 'Editar Cozinha', 'Permissão responsável por autorizar usuário a editar os pratos da cozinha');

--INSERT RESTAURANTE FORMA DE PAGAMENTO
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,1), (1,2), (1,3), (2,1), (2,2), (2,3);

-- PRODUTO
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (0, 'Combo de Sushi com 16 peças', 'Sushi Barca', 59.90, 1);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (1, 'Yakhisoba com Macarrão Integral Vegano', 'Yakisoba Integral', 39.90, 2);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES (0, 'Peixe Frito', 'Porção de Peixe', 10.90, 1);
