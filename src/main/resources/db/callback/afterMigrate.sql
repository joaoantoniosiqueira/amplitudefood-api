set foreign_key_checks = 0;

delete from cuisine;
delete from restaurant;

set foreign_key_checks = 1;

alter table cuisine auto_increment = 1;
alter table restaurant auto_increment = 1;

INSERT INTO cuisine (name) VALUES ('Italiana');
INSERT INTO cuisine (name) VALUES ('Mexicana');
INSERT INTO cuisine (name) VALUES ('Japonesa');
INSERT INTO cuisine (name) VALUES ('Indiana');
INSERT INTO cuisine (name) VALUES ('Francesa');

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