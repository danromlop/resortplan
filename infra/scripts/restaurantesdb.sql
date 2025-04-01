CREATE DATABASE restaurantesdb;
USE restaurantesdb;
-- DROP DATABASE restaurantesdb;

DROP TABLE turnos;

-- Tabla de Restaurantes
CREATE TABLE restaurantes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    capacidad INT NOT NULL,
    descripcion TEXT
);

-- Tabla de Turnos
CREATE TABLE turnos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('ALMUERZO', 'CENA') NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    restaurante_id BIGINT NOT NULL,
    FOREIGN KEY (restaurante_id) REFERENCES restaurantes(id) ON DELETE CASCADE
);

-- Tabla de Reservas
CREATE TABLE reservas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    restaurante_id BIGINT NOT NULL,
    turno_id BIGINT NOT NULL,
    nombre_cliente VARCHAR(255) NOT NULL,
    numero_personas INT NOT NULL CHECK (numero_personas > 0),
    observaciones TEXT,
    fecha_reserva DATE NOT NULL,
    FOREIGN KEY (restaurante_id) REFERENCES restaurantes(id) ON DELETE CASCADE,
    FOREIGN KEY (turno_id) REFERENCES turnos(id) ON DELETE CASCADE
);


INSERT INTO restaurantesdb.restaurantes (nombre, capacidad, descripcion) VALUES
('Club Ocean', 50, 'Restaurante con vista al mar, especializado en mariscos y cocina internacional.'),
('Oasis', 40, 'Ambiente relajado con comida mediterránea y opciones saludables.'),
('Market Grill', 60, 'Parrilla con carnes premium y opciones vegetarianas.'),
('Nami', 35, 'Restaurante japonés con sushi de autor y platos fusión.'),
('Pangea', 70, 'Buffet internacional con especialidades de todo el mundo.');

INSERT INTO restaurantesdb.restaurantes (nombre, capacidad, descripcion) VALUES ('Dúo Tapas', 25, 'Restaurante innovador con tapas premiadas');


INSERT INTO restaurantesdb.turnos (tipo, hora_inicio, hora_fin, restaurante_id) VALUES
-- Club Ocean
('Almuerzo', '13:00:00', '14:30:00', 1),
('Almuerzo', '14:30:00', '16:00:00', 1),
('Cena', '19:00:00', '20:30:00', 1),
('Cena', '20:30:00', '22:00:00', 1),

-- Oasis
('Almuerzo', '13:00:00', '14:30:00', 2),
('Almuerzo', '14:30:00', '16:00:00', 2),
('Cena', '19:00:00', '20:30:00', 2),
('Cena', '20:30:00', '22:00:00', 2),

-- Market Grill
('Almuerzo', '13:00:00', '14:30:00', 3),
('Almuerzo', '14:30:00', '16:00:00', 3),
('Cena', '19:00:00', '20:30:00', 3),
('Cena', '20:30:00', '22:00:00', 3),

-- Nami
('Almuerzo', '13:00:00', '14:30:00', 4),
('Almuerzo', '14:30:00', '16:00:00', 4),
('Cena', '19:00:00', '20:30:00', 4),
('Cena', '20:30:00', '22:00:00', 4),

-- Pangea
('Almuerzo', '13:00:00', '14:30:00', 5),
('Almuerzo', '14:30:00', '16:00:00', 5),
('Cena', '19:00:00', '20:30:00', 5),
('Cena', '20:30:00', '22:00:00', 5);

SELECT * FROM reservas;
SELECT * FROM turnos WHERE restaurante_id = 1;  -- Cambia el ID según el que estés probando

INSERT INTO reservas (restaurante_id, turno_id, nombre_cliente, numero_personas, observaciones, fecha_reserva) 
VALUES (1, 1, 'Cliente1', 1, 'Observación de reserva 1', '2025-03-31');

INSERT INTO reservas (restaurante_id, turno_id, nombre_cliente, numero_personas, observaciones, fecha_reserva) 
VALUES (2, 2, 'Cliente2', 2, 'Observación de reserva 2', '2025-04-01');

INSERT INTO reservas (restaurante_id, turno_id, nombre_cliente, numero_personas, observaciones, fecha_reserva) 
VALUES (3, 3, 'Cliente3', 3, 'Observación de reserva 3', '2025-04-02');

INSERT INTO reservas (restaurante_id, turno_id, nombre_cliente, numero_personas, observaciones, fecha_reserva) 
VALUES (4, 1, 'Cliente4', 4, 'Observación de reserva 4', '2025-04-03');

INSERT INTO reservas (restaurante_id, turno_id, nombre_cliente, numero_personas, observaciones, fecha_reserva) 
VALUES (5, 2, 'Cliente5', 5, 'Observación de reserva 5', '2025-04-04');

SELECT * FROM reservas WHERE fecha_reserva = '2025-04-01';

DESCRIBE reservas;

