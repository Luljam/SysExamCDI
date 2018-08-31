CREATE DATABASE  IF NOT EXISTS `cdi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cdi`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: hspmins10    Database: cdi
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda` (
  `cod_agenda` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` int(11) NOT NULL,
  `dt_inicio` datetime NOT NULL,
  `dt_final` date NOT NULL,
  `qtd_vagas_periodo` int(11) NOT NULL,
  `duracao_atendimento` int(11) NOT NULL,
  `dias_da_semana` varchar(45) NOT NULL,
  `dt_criacao` datetime NOT NULL,
  `cod_grupo` int(11) NOT NULL,
  `cpf_profissional` bigint(20) NOT NULL,
  `usuario` int(11) NOT NULL,
  PRIMARY KEY (`cod_agenda`),
  KEY `fk_cod_grupo_idx` (`cod_grupo`),
  KEY `fk_cod_prof_idx` (`cpf_profissional`),
  KEY `fk_cod_usuario_idx` (`usuario`),
  CONSTRAINT `fk_cod_grupo` FOREIGN KEY (`cod_grupo`) REFERENCES `grupo_exame` (`cod_grupo_exame`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_prof` FOREIGN KEY (`cpf_profissional`) REFERENCES `profissional` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `atividade_profissional`
--

DROP TABLE IF EXISTS `atividade_profissional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atividade_profissional` (
  `cod_atividade` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_atividade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `clinica`
--

DROP TABLE IF EXISTS `clinica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinica` (
  `cod_clinica` int(11) NOT NULL AUTO_INCREMENT,
  `desc_clinica` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_clinica`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `conselho_classe`
--

DROP TABLE IF EXISTS `conselho_classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conselho_classe` (
  `cod_conselho` int(11) NOT NULL AUTO_INCREMENT,
  `des_conselho` varchar(100) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `tipo_conselho` varchar(10) NOT NULL,
  PRIMARY KEY (`cod_conselho`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `cod_consulta` int(11) NOT NULL AUTO_INCREMENT,
  `num_consulta` int(11) NOT NULL,
  `rh_paciente` int(11) NOT NULL,
  `dt_consulta` datetime NOT NULL,
  `termino_consulta` datetime DEFAULT NULL,
  `cod_exame` int(11) NOT NULL,
  `cod_especialidade` int(11) NOT NULL,
  `cpf_solicitante` bigint(20) NOT NULL,
  `status` int(11) NOT NULL,
  `dt_cadastro` datetime NOT NULL,
  `cod_usuario` int(11) NOT NULL,
  PRIMARY KEY (`cod_consulta`),
  KEY `fk_num_consulta_idx` (`num_consulta`),
  KEY `fk_cod_exame_idx` (`cod_exame`),
  KEY `fk_cod_especialidade_idx` (`cod_especialidade`),
  KEY `fk_cod_usuario_idx` (`cod_usuario`),
  KEY `fk_cpf_solicitante_idx` (`cpf_solicitante`),
  KEY `fk_rh_paciente_idx` (`rh_paciente`),
  CONSTRAINT `fk_cod_epscialidade` FOREIGN KEY (`cod_especialidade`) REFERENCES `especialidade` (`cod_especialidade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_exame_sol` FOREIGN KEY (`cod_exame`) REFERENCES `exame` (`cod_exame`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_user` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cpf_solicitante` FOREIGN KEY (`cpf_solicitante`) REFERENCES `profissional` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_num_consulta` FOREIGN KEY (`num_consulta`) REFERENCES `grade` (`cod_grade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rh_paciente` FOREIGN KEY (`rh_paciente`) REFERENCES `paciente` (`reg_hospitalar`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `especialidade`
--

DROP TABLE IF EXISTS `especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidade` (
  `cod_especialidade` int(11) NOT NULL,
  `des_especialidade` varchar(100) NOT NULL,
  `cod_clinica` int(11) NOT NULL,
  PRIMARY KEY (`cod_especialidade`),
  KEY `fk_cod_clinica_idx` (`cod_clinica`),
  CONSTRAINT `fk_cod_clinica` FOREIGN KEY (`cod_clinica`) REFERENCES `clinica` (`cod_clinica`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `exame`
--

DROP TABLE IF EXISTS `exame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exame` (
  `cod_exame` int(11) NOT NULL AUTO_INCREMENT,
  `des_exame` varchar(100) NOT NULL,
  `cod_grupo_exame` int(11) NOT NULL,
  PRIMARY KEY (`cod_exame`),
  KEY `fk_cod_grupo_exame` (`cod_grupo_exame`),
  CONSTRAINT `fk_cod_grupo_exame` FOREIGN KEY (`cod_grupo_exame`) REFERENCES `grupo_exame` (`cod_grupo_exame`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1188 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `cod_grade` int(11) NOT NULL AUTO_INCREMENT,
  `cod_agenda` int(11) NOT NULL,
  `data_atendimento` datetime NOT NULL,
  `tipo_atendimento` int(11) NOT NULL,
  `tempo_atendimento` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `cod_grupo_agenda` int(11) NOT NULL,
  `cpf_profissional` bigint(20) NOT NULL,
  PRIMARY KEY (`cod_grade`),
  KEY `fk_cod_status_idx` (`status`),
  KEY `fk_cpf_idx` (`cpf_profissional`),
  KEY `fk_cod_exame_idx` (`cod_grupo_agenda`),
  CONSTRAINT `fk_cod_agenda` FOREIGN KEY (`cod_grupo_agenda`) REFERENCES `agenda` (`cod_agenda`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_exame` FOREIGN KEY (`cod_grupo_agenda`) REFERENCES `grupo_exame` (`cod_grupo_exame`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_status` FOREIGN KEY (`status`) REFERENCES `status_grade` (`cod_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cpf_profissional` FOREIGN KEY (`cpf_profissional`) REFERENCES `profissional` (`cpf`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=911 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grupo_exame`
--

DROP TABLE IF EXISTS `grupo_exame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo_exame` (
  `cod_grupo_exame` int(11) NOT NULL AUTO_INCREMENT,
  `des_grupo_exame` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_grupo_exame`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `log_atendimento`
--

DROP TABLE IF EXISTS `log_atendimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_atendimento` (
  `cod_log` int(11) NOT NULL AUTO_INCREMENT,
  `num_atendimento` int(11) NOT NULL,
  `data_ocorrencia` datetime NOT NULL,
  `ocorrencia` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_log`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `reg_hospitalar` int(11) NOT NULL,
  `reg_funcional` int(11) NOT NULL,
  `nome` text NOT NULL,
  `sexo` int(11) NOT NULL,
  `dt_nascimento` date NOT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `dt_cadastro` datetime NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`reg_hospitalar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `profissional`
--

DROP TABLE IF EXISTS `profissional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profissional` (
  `cpf` bigint(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cr` int(11) NOT NULL,
  `cod_conselho` int(11) NOT NULL,
  `matricula` bigint(20) NOT NULL,
  `tel_celular` varchar(45) DEFAULT NULL,
  `tel_residencial` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL,
  `cod_atividade` int(11) NOT NULL,
  PRIMARY KEY (`cpf`),
  KEY `fk_cod_conselho_idx` (`cod_conselho`),
  KEY `fk_cod_atividade_idx` (`cod_atividade`),
  CONSTRAINT `fk_cod_atividade` FOREIGN KEY (`cod_atividade`) REFERENCES `atividade_profissional` (`cod_atividade`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_conselho` FOREIGN KEY (`cod_conselho`) REFERENCES `conselho_classe` (`cod_conselho`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `status_grade`
--

DROP TABLE IF EXISTS `status_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status_grade` (
  `cod_status` int(11) NOT NULL AUTO_INCREMENT,
  `des_status` varchar(50) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`cod_status`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `login` varchar(15) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(128) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  `dat_cadastro` datetime NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `usuario_permissao`
--

DROP TABLE IF EXISTS `usuario_permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_permissao` (
  `usuario` int(11) NOT NULL,
  `permissao` varchar(255) NOT NULL,
  KEY `usuario` (`usuario`),
  CONSTRAINT `usuario_permissao_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `vw_rl_consulta`
--

DROP TABLE IF EXISTS `vw_rl_consulta`;
/*!50001 DROP VIEW IF EXISTS `vw_rl_consulta`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_rl_consulta` AS SELECT 
 1 AS `data_consulta`,
 1 AS `status`,
 1 AS `Clinica`,
 1 AS `Especialidade`,
 1 AS `Grupo`,
 1 AS `Exame`,
 1 AS `Solicitante`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_rl_consulta_profissional`
--

DROP TABLE IF EXISTS `vw_rl_consulta_profissional`;
/*!50001 DROP VIEW IF EXISTS `vw_rl_consulta_profissional`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_rl_consulta_profissional` AS SELECT 
 1 AS `Data_atendimento`,
 1 AS `Profissional`,
 1 AS `Grupo`,
 1 AS `Exame`,
 1 AS `Status`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_rl_consulta`
--

/*!50001 DROP VIEW IF EXISTS `vw_rl_consulta`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_rl_consulta` AS select `consulta`.`dt_consulta` AS `data_consulta`,`consulta`.`status` AS `status`,`clinica`.`desc_clinica` AS `Clinica`,`especialidade`.`des_especialidade` AS `Especialidade`,`grupo_exame`.`des_grupo_exame` AS `Grupo`,`exame`.`des_exame` AS `Exame`,`profissional`.`nome` AS `Solicitante` from (((((`consulta` join `exame` on((`consulta`.`cod_exame` = `exame`.`cod_exame`))) join `especialidade` on((`consulta`.`cod_especialidade` = `especialidade`.`cod_especialidade`))) join `clinica` on((`especialidade`.`cod_clinica` = `clinica`.`cod_clinica`))) join `grupo_exame` on((`exame`.`cod_grupo_exame` = `grupo_exame`.`cod_grupo_exame`))) join `profissional` on((`consulta`.`cpf_solicitante` = `profissional`.`cpf`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_rl_consulta_profissional`
--

/*!50001 DROP VIEW IF EXISTS `vw_rl_consulta_profissional`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_rl_consulta_profissional` AS select `grade`.`data_atendimento` AS `Data_atendimento`,`profissional`.`nome` AS `Profissional`,`grupo_exame`.`des_grupo_exame` AS `Grupo`,`exame`.`des_exame` AS `Exame`,`grade`.`status` AS `Status` from ((((`consulta` join `grade` on((`consulta`.`num_consulta` = `grade`.`cod_grade`))) join `profissional` on((`grade`.`cpf_profissional` = `profissional`.`cpf`))) join `exame` on((`consulta`.`cod_exame` = `exame`.`cod_exame`))) join `grupo_exame` on((`exame`.`cod_grupo_exame` = `grupo_exame`.`cod_grupo_exame`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-31 15:26:20
