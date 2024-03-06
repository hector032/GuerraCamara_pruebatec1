-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 06-03-2024 a las 22:33:14
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empleados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT '0',
  `apellido` varchar(255) DEFAULT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  `fecha_inicio` datetime DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID`, `activo`, `apellido`, `cargo`, `fecha_inicio`, `nombre`, `salario`) VALUES
(1, 0, 'Guerra', 'CEO', '2015-10-24 22:00:00', 'Hector', 9999.99),
(2, 0, 'Guerra', 'testing', '1998-10-29 23:00:00', 'ana', 800),
(3, 0, 'Gomez', 'SeniorTester', '2024-12-11 23:00:00', 'Petrica', 6),
(4, 0, 'test', 'test test', '1998-10-29 23:00:00', 'test', 5),
(5, 1, 'Guerra Cámara', 'Beta tester', '2015-12-08 23:00:00', 'Hector', 90000),
(6, 1, 'ultimoTest', 'ultimo test', '2024-03-05 23:00:00', 'ultimoTest', 998.9),
(7, 1, 'ultimoTest', 'ultimo test', '2025-03-05 23:00:00', 'ultimoTest', 7777),
(8, 0, 'perez test', 'ultimo test', '2023-03-04 23:00:00', 'maria de los angeles', 1000000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
