INSERT INTO users (email, pwd) VALUES ('kevinadmin@gmail.com', 'to_be_encoded');
INSERT INTO users (email, pwd) VALUES ('kevindirector@gmail.com', 'to_be_encoded');
INSERT INTO users (email, pwd) VALUES ('kevinauxiliar@gmail.com', 'to_be_encoded');

INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_ADMIN', 'can view every endpoint',1);
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_DIRECTOR', 'can view /socios, /voluntarios y /envios',2);
INSERT INTO roles (role_name, description, id_user) VALUES ('ROLE_AUXILIAR', 'can view /reportes',3);

INSERT INTO sede (ciudad, direccion, director, nombre) VALUES
('Bogota', 'Calle 123', 'Andy', 'Sede 1'),
('Barranquilla', 'Avenida 456', 'Luchito', 'Sede 2'),
('Bucaramanga', 'Plaza 789', 'Profe Camilo', 'Sede 3'),
('Bucaramanga', 'Carretera 321', 'Balaguera', 'Sede 4'),
('Bucaramanga', 'Calle Principal', 'Karen', 'Sede 5');

INSERT INTO socio (apellido, correo_electronico, nombre, telefono, sede_id) VALUES
('González', 'gonzalez@example.com', 'Juan', '1234567890', 1),
('Martínez', 'martinez@example.com', 'María', '9876543210', 1),
('Rodríguez', 'rodriguez@example.com', 'Pedro', '5554443331', 2),
('López', 'lopez@example.com', 'Ana', '1112223334', 3),
('Pérez', 'perez@example.com', 'Luis', '999888777', 4);

INSERT INTO reporte_cuota (fecha_pago, cuenta_bancaria, tipo_cuota, importe_total, socio_id) VALUES
('2024-04-01 09:00:00', '1234567890', 'MINIMA', 50.00, 1),
('2024-04-02 10:30:00', '9876543210', 'MEDIA', 75.00, 2),
('2024-04-03 11:45:00', '555444333', 'MAXIMA', 100.00, 3),
('2024-04-04 13:15:00', '111222333', 'MINIMA', 50.00, 4),
('2024-04-05 14:45:00', '999888777', 'MEDIA', 75.00, 5);

INSERT INTO voluntario (apellido, correo_electronico, nombre, telefono, disponibilidad, profesion, tipo_voluntario, sede_id) VALUES
('López', 'lopez@example.com', 'Juan', '1234567890', 1, 'Médico', 1, 1),
('García', 'garcia@example.com', 'María', '9876543210', 0, null, 0, 2),
('Martínez', 'martinez@example.com', 'Carlos', '555444333', 0, 'Enfermero', 1, 3),
('Rodríguez', 'rodriguez@example.com', 'Laura', '111222333', 0, null, 0, 4),
('Pérez', 'perez@example.com', 'Ana', '999888777', 1, 'Docente', 1, 5);

INSERT INTO refugio (pais, direccion) VALUES
('Estados Unidos', '123 Main Street, Anytown, USA'),
('Canadá', '456 Maple Avenue, Maple City, Canada'),
('Reino Unido', '789 Elm Street, Elmville, UK'),
('Francia', '101 Oak Street, Oaksville, France'),
('Alemania', '202 Pine Street, Pinetown, Germany');

