INSERT INTO cozinha (id, nome) values (1, 'Tailandesa');
INSERT INTO cozinha (id, nome) values (2, 'Indiana');

INSERT INTO restaurante (nome, taxa_frete, cozinha_id) values ('Zon Cheng Buffet', 9.50, 1);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) values ('Taji Zen', 10, 2);
INSERT INTO restaurante (nome, taxa_frete, cozinha_id) values ('Hako Sushi', 8.75, 1);

INSERT INTO forma_de_pagamento (id, descricao) values ('1', 'Cartão de Crédito');
INSERT INTO forma_de_pagamento (id, descricao) values ('2', 'Cartão de Débito');
INSERT INTO forma_de_pagamento (id, descricao) values ('3', 'Vale Alimentação');

INSERT INTO permissao (id, nome, descricao) values ('1', 'Consultar Restaurantes', 'Permissão responsável por autorizar usuário a consultar restaurantes');
INSERT INTO permissao (id, nome, descricao) values ('2', 'Editar Cozinha', 'Permissão responsável por autorizar usuário a editar os pratos da cozinha');

INSERT INTO estado (id, nome) values ('1', 'Santa Catarina');
INSERT INTO estado (id, nome) values ('2', 'São Paulo');
INSERT INTO estado (id, nome) values ('3', 'Paraná');

INSERT INTO cidade (id, nome, estado_id) values ('1', 'Pomerode', '1');
INSERT INTO cidade (id, nome, estado_id) values ('2', 'Blumenau', '1');
INSERT INTO cidade (id, nome, estado_id) values ('3', 'São José do Rio Preto', '2');
INSERT INTO cidade (id, nome, estado_id) values ('4', 'Campinas', '2');
INSERT INTO cidade (id, nome, estado_id) values ('5', 'Chompinzinho', '3');
INSERT INTO cidade (id, nome, estado_id) values ('6', 'Curitiba', '3');