CREATE DATABASE IF NOT EXISTS restaurantesdb;
USE restaurantesdb;
-- DROP DATABASE restaurantesdb;

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

INSERT INTO restaurantesdb.restaurantes (nombre, capacidad, descripcion) VALUES
('Club Ocean', 50, 'Restaurante con vista al mar, especializado en mariscos y cocina internacional.'),
('Oasis', 40, 'Ambiente relajado con comida mediterránea y opciones saludables.'),
('Market Grill', 60, 'Parrilla con carnes premium y opciones vegetarianas.'),
('Nami', 35, 'Restaurante japonés con sushi de autor y platos fusión.'),
('Pangea', 70, 'Buffet internacional con especialidades de todo el mundo.');


INSERT INTO restaurantesdb.turnos (tipo, hora_inicio, hora_fin, restaurante_id) VALUES
-- Club Ocean
('Almuerzo', '12:00:00', '14:00:00', 1),
('Cena', '19:00:00', '21:00:00', 1),

-- Oasis
('Almuerzo', '12:30:00', '14:30:00', 2),
('Cena', '19:30:00', '21:30:00', 2),

-- Market Grill
('Almuerzo', '12:15:00', '14:15:00', 3),
('Cena', '19:15:00', '21:15:00', 3),

-- Nami
('Almuerzo', '12:45:00', '14:45:00', 4),
('Cena', '19:45:00', '21:45:00', 4),

-- Pangea
('Almuerzo', '13:00:00', '15:00:00', 5),
('Cena', '20:00:00', '22:00:00', 5);

