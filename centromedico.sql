-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Apr 14, 2026 alle 10:56
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `centro medico polispecialistico`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `medico`
--

CREATE TABLE `medico` (
  `ID_MEDICO` int(10) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `COGNOME` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `TELEFONO` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `medico`
--

INSERT INTO `medico` (`ID_MEDICO`, `NOME`, `COGNOME`, `EMAIL`, `TELEFONO`) VALUES
(16, 'GENESIS', 'CEDENO', 'GENESIS.CEDENO@GMAIL.COM', '+393270761369'),
(17, 'JEFERSON', 'DEMERA', 'JEFFERSON.DEMERA@GMAIL.COM', '+393468157962'),
(18, 'ALBA', 'CAROLINA', 'ALBA.CAROLINA@GMAIL.COM', '+393471025689');

-- --------------------------------------------------------

--
-- Struttura della tabella `pazienti`
--

CREATE TABLE `pazienti` (
  `ID_PAZIENTE` int(50) NOT NULL,
  `NOME` varchar(50) NOT NULL,
  `COGNOME` varchar(50) NOT NULL,
  `DATANASCITA` date NOT NULL,
  `C.F` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `pazienti`
--

INSERT INTO `pazienti` (`ID_PAZIENTE`, `NOME`, `COGNOME`, `DATANASCITA`, `C.F`) VALUES
(21, 'MARILIN', 'CEDENO', '1997-01-09', 0),
(22, 'IRMA', 'CUSME', '2001-05-10', 0),
(23, 'ALEXA', 'TURMI', '2015-10-13', 0),
(24, 'ADRIANA', 'FAJARDO', '2006-08-09', 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `prestazioni`
--

CREATE TABLE `prestazioni` (
  `ID_PRESTAZIONE` int(10) NOT NULL,
  `DESCRIZIONE` varchar(200) NOT NULL,
  `COSTO` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `prestazioni`
--

INSERT INTO `prestazioni` (`ID_PRESTAZIONE`, `DESCRIZIONE`, `COSTO`) VALUES
(2, 'RX BACINO', 230),
(3, 'TERAPIA', 60),
(4, 'VALUTAZIONE PSICOLOGICA', 80),
(5, 'RX MANO', 150);

-- --------------------------------------------------------

--
-- Struttura della tabella `specializzazione`
--

CREATE TABLE `specializzazione` (
  `ID_SPECIALIZZAZIONE` int(10) NOT NULL,
  `NOME` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `specializzazione`
--

INSERT INTO `specializzazione` (`ID_SPECIALIZZAZIONE`, `NOME`) VALUES
(49, 'NEUROLOGO'),
(50, 'PSICOLOGO'),
(51, 'CARDIOLOGO');

-- --------------------------------------------------------

--
-- Struttura della tabella `visita`
--

CREATE TABLE `visita` (
  `ID_VISITA` int(50) NOT NULL,
  `DATA` date NOT NULL,
  `ORA` time(6) NOT NULL,
  `ESITO` varchar(50) NOT NULL,
  `ID_MEDICO` int(20) NOT NULL,
  `ID_PAZIENTE` int(20) NOT NULL,
  `ID_PRESTAZIONI` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `visita`
--

INSERT INTO `visita` (`ID_VISITA`, `DATA`, `ORA`, `ESITO`, `ID_MEDICO`, `ID_PAZIENTE`, `ID_PRESTAZIONI`) VALUES
(19, '2026-01-25', '15:30:00.000000', 'INTERVENTO', 17, 21, 5),
(20, '2026-02-15', '10:00:00.000000', 'INTERVENTO', 16, 23, 4),
(21, '2026-05-30', '16:15:00.000000', 'POSITIVO', 18, 22, 2),
(22, '2026-06-17', '11:30:00.000000', 'INTERVENTO', 17, 24, 3),
(23, '2026-02-25', '09:30:00.000000', 'POSITIVO', 16, 24, 5),
(24, '2026-04-11', '13:00:00.000000', 'RIFARE', 16, 22, 4);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`ID_MEDICO`);

--
-- Indici per le tabelle `pazienti`
--
ALTER TABLE `pazienti`
  ADD PRIMARY KEY (`ID_PAZIENTE`);

--
-- Indici per le tabelle `prestazioni`
--
ALTER TABLE `prestazioni`
  ADD PRIMARY KEY (`ID_PRESTAZIONE`);

--
-- Indici per le tabelle `specializzazione`
--
ALTER TABLE `specializzazione`
  ADD PRIMARY KEY (`ID_SPECIALIZZAZIONE`);

--
-- Indici per le tabelle `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`ID_VISITA`),
  ADD KEY `ID_MEDICO` (`ID_MEDICO`),
  ADD KEY `ID_PAZIENTE` (`ID_PAZIENTE`),
  ADD KEY `ID_PRESTAZIONI` (`ID_PRESTAZIONI`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `medico`
--
ALTER TABLE `medico`
  MODIFY `ID_MEDICO` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT per la tabella `pazienti`
--
ALTER TABLE `pazienti`
  MODIFY `ID_PAZIENTE` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT per la tabella `prestazioni`
--
ALTER TABLE `prestazioni`
  MODIFY `ID_PRESTAZIONE` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `specializzazione`
--
ALTER TABLE `specializzazione`
  MODIFY `ID_SPECIALIZZAZIONE` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT per la tabella `visita`
--
ALTER TABLE `visita`
  MODIFY `ID_VISITA` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `pazienti`
--
ALTER TABLE `pazienti`
  ADD CONSTRAINT `pazienti_ibfk_1` FOREIGN KEY (`ID_PAZIENTE`) REFERENCES `visita` (`ID_PAZIENTE`);

--
-- Limiti per la tabella `prestazioni`
--
ALTER TABLE `prestazioni`
  ADD CONSTRAINT `prestazioni_ibfk_1` FOREIGN KEY (`ID_PRESTAZIONE`) REFERENCES `visita` (`ID_PRESTAZIONI`);

--
-- Limiti per la tabella `specializzazione`
--
ALTER TABLE `specializzazione`
  ADD CONSTRAINT `REL_SPECI_MEDICO` FOREIGN KEY (`ID_SPECIALIZZAZIONE`) REFERENCES `medico` (`ID_MEDICO`);

--
-- Limiti per la tabella `visita`
--
ALTER TABLE `visita`
  ADD CONSTRAINT `visita_ibfk_1` FOREIGN KEY (`ID_MEDICO`) REFERENCES `medico` (`ID_MEDICO`),
  ADD CONSTRAINT `visita_ibfk_2` FOREIGN KEY (`ID_PAZIENTE`) REFERENCES `pazienti` (`ID_PAZIENTE`),
  ADD CONSTRAINT `visita_ibfk_3` FOREIGN KEY (`ID_PRESTAZIONI`) REFERENCES `prestazioni` (`ID_PRESTAZIONE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
