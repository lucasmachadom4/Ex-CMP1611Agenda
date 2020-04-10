-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Tempo de geração: 10-Abr-2020 às 17:32
-- Versão do servidor: 8.0.18
-- versão do PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `agenda_db`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agenda`
--

DROP TABLE IF EXISTS `agenda`;
CREATE TABLE IF NOT EXISTS `agenda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(64) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `categoria_id` (`categoria_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `agenda`
--

INSERT INTO `agenda` (`id`, `nome`, `categoria_id`) VALUES
(1, 'Lucas M', 2),
(2, 'Batman', 3),
(3, 'Matheus Machado', 1),
(4, 'Altair Flior', 4),
(5, 'Melisandra Alq', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `agenda_telefones`
--

DROP TABLE IF EXISTS `agenda_telefones`;
CREATE TABLE IF NOT EXISTS `agenda_telefones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `agenda_id` int(11) NOT NULL,
  `telfone_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `agenda_id` (`agenda_id`),
  KEY `telfone_id` (`telfone_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `agenda_telefones`
--

INSERT INTO `agenda_telefones` (`id`, `agenda_id`, `telfone_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 3, 4),
(5, 3, 5),
(6, 4, 6),
(7, 4, 7),
(8, 4, 8),
(9, 5, 9),
(10, 5, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`id`, `nome`) VALUES
(1, 'Familia'),
(2, 'Trabalho'),
(3, 'Amigos'),
(4, 'Outros');

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefone`
--

DROP TABLE IF EXISTS `telefone`;
CREATE TABLE IF NOT EXISTS `telefone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(16) NOT NULL,
  `tipo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo_id` (`tipo_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `telefone`
--

INSERT INTO `telefone` (`id`, `numero`, `tipo_id`) VALUES
(1, '(62) 9 8585-9878', 4),
(2, '(62) 3356-9888', 2),
(3, '(62) 9 8888-5233', 1),
(4, '(62) 2253-6659', 1),
(5, '(62) 9 9666-8956', 3),
(6, '(62) 0000-0009', 3),
(7, '(62) 9 5566-8009', 2),
(8, '(62) 9 8669-8111', 1),
(9, '(62) 0000-0009', 3),
(10, '(62) 9 5566-8009', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo`
--

DROP TABLE IF EXISTS `tipo`;
CREATE TABLE IF NOT EXISTS `tipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `tipo`
--

INSERT INTO `tipo` (`id`, `nome`) VALUES
(1, 'Comercial'),
(2, 'Residencial'),
(3, 'Celular'),
(4, 'Principal');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
