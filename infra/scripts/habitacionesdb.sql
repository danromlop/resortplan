CREATE DATABASE habitacionesdb;
USE habitacionesdb;
-- DROP DATABASE habitacionesdb;

CREATE TABLE habitaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(10) NOT NULL UNIQUE,
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    num_personas INT NOT NULL DEFAULT 1
);

INSERT INTO habitaciones (numero) VALUES ("1001");
INSERT INTO habitaciones (numero) VALUES ("1002");
INSERT INTO habitaciones (numero) VALUES ("1003");
INSERT INTO habitaciones (numero) VALUES ("1004");
INSERT INTO habitaciones (numero) VALUES ("1005");
INSERT INTO habitaciones (numero) VALUES ("1006");

INSERT INTO clientes (nombre, apellidos, num_personas) VALUES 
('Juan', 'Pérez', 2),
('Ana', 'Gómez', 3),
('Carlos', 'López', 1),
('María', 'Fernández', 4),
('Luis', 'Martínez', 2);


UPDATE habitaciones SET cliente_id = 1 WHERE numero = '1001';

UPDATE habitaciones SET cliente_id = 2 WHERE numero = '1004';

UPDATE habitaciones SET cliente_id = 4 WHERE numero = '1006';



SELECT * FROM habitaciones;
SELECT * FROM clientes;