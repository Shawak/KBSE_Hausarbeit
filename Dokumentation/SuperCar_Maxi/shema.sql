-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 27. Nov 2014 um 18:46
-- Server Version: 5.6.16
-- PHP-Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `supercar`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `fahrzeug`
--

CREATE TABLE IF NOT EXISTS `fahrzeug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `modell_id` int(11) NOT NULL,
  `kennzeichen` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Daten fÃ¼r Tabelle `fahrzeug`
--

INSERT INTO `fahrzeug` (`id`, `modell_id`, `kennzeichen`) VALUES
(1, 1, 'HH CR 0001'),
(2, 2, 'HH CR 0002'),
(3, 3, 'HH CR 0003'),
(4, 4, 'HH CR 0004'),
(5, 5, 'HH CR 0005'),
(6, 6, 'HH CR 0006'),
(7, 7, 'HH CR 0007'),
(8, 8, 'HH CR 0008'),
(9, 9, 'HH CR 0009'),
(10, 10, 'HH CR 0010');

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `hersteller`
--

CREATE TABLE IF NOT EXISTS `hersteller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `plz` int(11) NOT NULL,
  `adresse` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Daten fÃ¼r Tabelle `hersteller`
--

INSERT INTO `hersteller` (`id`, `name`, `plz`, `adresse`) VALUES
(1, 'Opel', 0, ''),
(3, 'Mercedes-Benz', 0, ''),
(4, 'Lamobrghini', 0, ''),
(5, 'Nissan', 0, ''),
(6, 'Porsche', 0, ''),
(7, 'Renault', 0, ''),
(8, 'VW', 0, ''),
(9, 'Toyota', 0, ''),
(10, 'Volvo', 0, ''),
(11, 'Maserati', 0, '');

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `kunde`
--

CREATE TABLE IF NOT EXISTS `kunde` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `vorname` varchar(256) NOT NULL,
  `geburtstag` date NOT NULL,
  `plz` int(11) NOT NULL,
  `adresse` varchar(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Daten fÃ¼r Tabelle `kunde`
--

INSERT INTO `kunde` (`id`, `name`, `vorname`, `geburtstag`, `plz`, `adresse`) VALUES
(1, 'Mustermann', 'Max', '2014-10-08', 49492, 'Velper Str 8'),
(2, 'Lustig', 'Peter', '1992-04-01', 49492, 'Lustigweg 3'),
(7, 'MÃ¼ller', 'Ulli', '1994-02-04', 49492, 'Heidelberg 5'),
(8, 'Meyer', 'Ulf', '1991-12-04', 49492, 'Kreisweg 66'),
(9, 'Heide', 'Lea', '1995-01-03', 49492, 'Landstr 1');

-- --------------------------------------------------------

--
-- Tabellenstruktur fÃ¼r Tabelle `modell`
--

CREATE TABLE IF NOT EXISTS `modell` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hersteller_id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `leistung` int(11) NOT NULL,
  `hubraum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Daten fÃ¼r Tabelle `modell`
--

INSERT INTO `modell` (`id`, `hersteller_id`, `name`, `leistung`, `hubraum`) VALUES
(1, 1, 'Astra', 0, 0),
(2, 3, 'Sprinter', 0, 0),
(3, 4, 'Aventador', 0, 0),
(4, 5, 'GT-R', 0, 0),
(5, 6, '911 Turbo', 0, 0),
(6, 7, 'Kangoo', 0, 0),
(7, 8, 'Caddy', 0, 0),
(8, 9, 'Aygo', 0, 0),
(9, 10, 'V70', 0, 0),
(10, 11, 'GranTurismo', 0, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
