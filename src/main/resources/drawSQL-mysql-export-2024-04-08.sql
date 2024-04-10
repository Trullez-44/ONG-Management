CREATE TABLE `EnvioDetalles`(
    `envioDetallesId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `envioId` INT NOT NULL,
    `tipoCarga` ENUM('Alimentos', 'Medicamentos') NOT NULL,
    `nombreProducto` VARCHAR(255) NOT NULL,
    `descripcion` VARCHAR(255) NOT NULL,
    `numUnidades` INT NOT NULL,
    `numToneladas` INT NOT NULL
);
CREATE TABLE `voluntario`(
    `voluntarioId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `apellido` VARCHAR(255) NOT NULL,
    `correo_electronico` VARCHAR(255) NOT NULL,
    `nombre` VARCHAR(255) NOT NULL,
    `telefono` VARCHAR(255) NOT NULL,
    `disponibilidad` TINYINT(1) NOT NULL,
    `profesion` VARCHAR(255) NOT NULL,
    `tipoVoluntario` VARCHAR(255) NOT NULL,
    `sedeId` INT NOT NULL
);
CREATE TABLE `Persona`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre` VARCHAR(255) NOT NULL,
    `apellido` VARCHAR(255) NOT NULL,
    `telefono` VARCHAR(255) NOT NULL,
    `direccion` VARCHAR(255) NOT NULL
);
CREATE TABLE `Refugio`(
    `refugioId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `pais` VARCHAR(255) NOT NULL,
    `direccion` VARCHAR(255) NOT NULL
);
CREATE TABLE `SedesColaboradoras`(
    `sedeId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `envioId` INT NOT NULL
);
CREATE TABLE `Sede`(
    `sedeId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `ciudad` VARCHAR(255) NOT NULL,
    `direccion` VARCHAR(255) NOT NULL,
    `director` VARCHAR(255) NOT NULL,
    `nombre` VARCHAR(255) NOT NULL
);
CREATE TABLE `Envio`(
    `envioId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `codigoEnvio` VARCHAR(255) NOT NULL,
    `fechaSalida` DATE NOT NULL,
    `refugioId` INT NOT NULL
);
CREATE TABLE `socio`(
    `socioId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
     `apellido` VARCHAR(255) NOT NULL,
    `correo_electronico` VARCHAR(255) NOT NULL,
     `nombre` VARCHAR(255) NOT NULL,
    `telefono` VARCHAR(255) NOT NULL,
    `sedeId` INT NOT NULL
);
CREATE TABLE reporte_cuota(
    `reporte_id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `fecha_pago` DATETIME NOT NULL,
    `cuenta_bancaria` VARCHAR(255) NOT NULL,
    `tipo_cuota` ENUM('MINIMA', 'MEDIA', 'MAXIMA') NOT NULL,
    `importe_total` DOUBLE NOT NULL
    `socio_id` INT NOT NULL
);
CREATE TABLE `AyudaHumanitaria`(
    `envioId` INT NOT NULL,
    `voluntarioId` INT NOT NULL
);
ALTER TABLE
    `ReporteCuota` ADD CONSTRAINT `reportecuota_socioid_foreign` FOREIGN KEY(`socioId`) REFERENCES `Socio`(`socioId`);
ALTER TABLE
    `Sede` ADD CONSTRAINT `sede_directorid_foreign` FOREIGN KEY(`directorId`) REFERENCES `Persona`(`id`);
ALTER TABLE
    `SedesColaboradoras` ADD CONSTRAINT `sedescolaboradoras_envioid_foreign` FOREIGN KEY(`envioId`) REFERENCES `Envio`(`envioId`);
ALTER TABLE
    `Socio` ADD CONSTRAINT `socio_sedeid_foreign` FOREIGN KEY(`sedeId`) REFERENCES `Sede`(`sedeId`);
ALTER TABLE
    `EnvioDetalles` ADD CONSTRAINT `enviodetalles_envioid_foreign` FOREIGN KEY(`envioId`) REFERENCES `Envio`(`envioId`);
ALTER TABLE
    `AyudaHumanitaria` ADD CONSTRAINT `ayudahumanitaria_voluntarioid_foreign` FOREIGN KEY(`voluntarioId`) REFERENCES `Voluntario`(`voluntarioId`);
ALTER TABLE
    `AyudaHumanitaria` ADD CONSTRAINT `ayudahumanitaria_envioid_foreign` FOREIGN KEY(`envioId`) REFERENCES `Envio`(`envioId`);
ALTER TABLE
    `Sede` ADD CONSTRAINT `sede_sedeid_foreign` FOREIGN KEY(`sedeId`) REFERENCES `SedesColaboradoras`(`sedeId`);
ALTER TABLE
    `Envio` ADD CONSTRAINT `envio_refugioid_foreign` FOREIGN KEY(`refugioId`) REFERENCES `Refugio`(`refugioId`);