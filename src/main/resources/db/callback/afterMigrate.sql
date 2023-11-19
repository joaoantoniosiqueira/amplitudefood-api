set foreign_key_checks = 0;

delete from cuisine;
delete from restaurant;
delete from state;
delete from city;

set foreign_key_checks = 1;

alter table cuisine auto_increment = 1;
alter table restaurant auto_increment = 1;
alter table state auto_increment = 1;
alter table city auto_increment = 1;

-- Cuisine
INSERT INTO cuisine (name) VALUES ('Italiana');
INSERT INTO cuisine (name) VALUES ('Mexicana');
INSERT INTO cuisine (name) VALUES ('Japonesa');
INSERT INTO cuisine (name) VALUES ('Indiana');
INSERT INTO cuisine (name) VALUES ('Francesa');

-- Restaurant
INSERT INTO restaurant (name, cuisine_id, shipping_fee) VALUES ('La Bella Pasta', 1, 5.00); -- Italiana
INSERT INTO restaurant (name, cuisine_id, shipping_fee) VALUES ('Pizzeria Vesuvio', 1, 5.50); -- Italiana

INSERT INTO restaurant (name, cuisine_id, shipping_fee) VALUES ('Tacos El Rey', 2, 3.50); -- Mexicana
INSERT INTO restaurant (name, cuisine_id, shipping_fee) VALUES ('Cantina Mariachi', 2, 3.00); -- Mexicana

INSERT INTO restaurant (name, cuisine_id, shipping_fee) VALUES ('Sushi Zen', 3, 4.00); -- Japonesa
INSERT INTO restaurant (name, cuisine_id, shipping_fee) VALUES ('Sakura Blossoms', 3, 4.50); -- Japonesa

INSERT INTO restaurant (name, cuisine_id, shipping_fee) VALUES ('Bombay Spice', 4, 6.00); -- Indiana
INSERT INTO restaurant (name, cuisine_id, shipping_fee) VALUES ('Curry House', 4, 5.75); -- Indiana

INSERT INTO restaurant (name, cuisine_id, shipping_fee) VALUES ('Le Gourmet Parisien', 5, 2.50); -- Francesa
INSERT INTO restaurant (name, cuisine_id, shipping_fee) VALUES ('Bistro Du Vin', 5, 4.25); -- Francesa

-- State
INSERT INTO state (name) VALUES ('São Paulo');
INSERT INTO state (name) VALUES ('Rio de Janeiro');
INSERT INTO state (name) VALUES ('Minas Gerais');
INSERT INTO state (name) VALUES ('Bahia');
INSERT INTO state (name) VALUES ('Paraná');
INSERT INTO state (name) VALUES ('Maranhão');

-- City
INSERT INTO city (name, state_id) VALUES ('São Paulo', 1);
INSERT INTO city (name, state_id) VALUES ('Campinas', 1);
INSERT INTO city (name, state_id) VALUES ('Santos', 1);

INSERT INTO city (name, state_id) VALUES ('Rio de Janeiro', 2);
INSERT INTO city (name, state_id) VALUES ('Niterói', 2);
INSERT INTO city (name, state_id) VALUES ('Nova Iguaçu', 2);

INSERT INTO city (name, state_id) VALUES ('Belo Horizonte', 3);
INSERT INTO city (name, state_id) VALUES ('Juiz de Fora', 3);
INSERT INTO city (name, state_id) VALUES ('Uberlândia', 3);

INSERT INTO city (name, state_id) VALUES ('Salvador', 4);
INSERT INTO city (name, state_id) VALUES ('Feira de Santana', 4);
INSERT INTO city (name, state_id) VALUES ('Vitória da Conquista', 4);

INSERT INTO city (name, state_id) VALUES ('Curitiba', 5);
INSERT INTO city (name, state_id) VALUES ('Londrina', 5);
INSERT INTO city (name, state_id) VALUES ('Maringá', 5);

INSERT INTO city (name, state_id) VALUES ('São Luís', 6);
INSERT INTO city (name, state_id) VALUES ('Imperatriz', 6);
INSERT INTO city (name, state_id) VALUES ('São José de Ribamar', 6);
