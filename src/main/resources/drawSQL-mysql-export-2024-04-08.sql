CREATE TABLE `EnvioDetalles`(
    `envioDetallesId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `envioId` INT NOT NULL,
    `tipoCarga` ENUM('Alimentos', 'Medicamentos') NOT NULL,
    `nombreProducto` VARCHAR(255) NOT NULL,
    `descripcion` VARCHAR(255) NOT NULL,
    `numUnidades` INT NOT NULL,
    `numToneladas` INT NOT NULL
);
CREATE TABLE `Voluntario`(
    `voluntarioId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre` VARCHAR(255) NOT NULL,
    `apellido` VARCHAR(255) NOT NULL,
    `telefono` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `profesion` VARCHAR(255) NOT NULL,
    `disponibilidad` TINYINT(1) NOT NULL,
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
    `nombre` VARCHAR(255) NOT NULL,
    `direccion` VARCHAR(255) NOT NULL,
    `ciudadId` INT NOT NULL,
    `directorId` INT NOT NULL
);
CREATE TABLE `Envio`(
    `envioId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `codigoEnvio` VARCHAR(255) NOT NULL,
    `fechaSalida` DATE NOT NULL,
    `refugioId` INT NOT NULL
);
CREATE TABLE `Socio`(
    `socioId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nombre` VARCHAR(255) NOT NULL,
    `apellido` VARCHAR(255) NOT NULL,
    `direccion` VARCHAR(255) NOT NULL,
    `telefono` VARCHAR(255) NOT NULL,
    `sedeId` INT NOT NULL
);
CREATE TABLE `ReporteCuota`(
    `reporteId` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `socioId` INT NOT NULL,
    `fechaPago` DATETIME NOT NULL,
    `cuentaBancaria` VARCHAR(255) NOT NULL,
    `tipoCuota` ENUM('Minima', 'Media', 'Maxima') NOT NULL,
    `importeTotal` DOUBLE NOT NULL
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