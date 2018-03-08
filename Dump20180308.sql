CREATE DATABASE  IF NOT EXISTS `gre` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `gre`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: gre
-- ------------------------------------------------------
-- Server version	5.7.14

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
-- Table structure for table `tb_adicoes`
--

DROP TABLE IF EXISTS `tb_adicoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_adicoes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_adicao` date DEFAULT NULL,
  `num_doc` varchar(10) DEFAULT NULL,
  `historico_adicao` varchar(45) DEFAULT NULL,
  `vlr_adicao` double DEFAULT NULL,
  `id_programa` int(11) DEFAULT NULL,
  `id_uex` int(11) DEFAULT NULL,
  `id_ano` int(11) DEFAULT NULL,
  `id_trimestre` int(11) DEFAULT NULL,
  `conciliado` tinyint(4) DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_adicoes_tb_programa_idx` (`id_programa`),
  KEY `fk_adicoes_tb_ano_idx` (`id_ano`),
  KEY `fk_adicoes_tb_trimestre_idx` (`id_trimestre`),
  KEY `fk_adicoes_tb_uex_idx` (`id_uex`),
  KEY `fk_adicoes_tb_conta_idx` (`id_conta`),
  CONSTRAINT `fk_adicoes_tb_ano` FOREIGN KEY (`id_ano`) REFERENCES `tb_ano` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_adicoes_tb_conta` FOREIGN KEY (`id_conta`) REFERENCES `tb_conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_adicoes_tb_programa` FOREIGN KEY (`id_programa`) REFERENCES `tb_programa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_adicoes_tb_trimestre` FOREIGN KEY (`id_trimestre`) REFERENCES `tb_trimestre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_adicoes_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_adicoes`
--

LOCK TABLES `tb_adicoes` WRITE;
/*!40000 ALTER TABLE `tb_adicoes` DISABLE KEYS */;
INSERT INTO `tb_adicoes` VALUES (1,'2018-02-13','567','Valor ref. a ajuste de recebimento',600,1,1,1,1,NULL,1),(2,'2018-02-13','123','Mais uma adição',100,1,1,1,1,0,1);
/*!40000 ALTER TABLE `tb_adicoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ano`
--

DROP TABLE IF EXISTS `tb_ano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_ano` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ano` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ano`
--

LOCK TABLES `tb_ano` WRITE;
/*!40000 ALTER TABLE `tb_ano` DISABLE KEYS */;
INSERT INTO `tb_ano` VALUES (1,'2017'),(2,'2018'),(3,'2019'),(4,'2020'),(5,'2021'),(6,'2022'),(7,'2023'),(8,'2024'),(9,'2025'),(10,'2026'),(11,'2027'),(12,'2028'),(13,'2029'),(14,'2030');
/*!40000 ALTER TABLE `tb_ano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_bairro`
--

DROP TABLE IF EXISTS `tb_bairro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_bairro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(45) DEFAULT NULL,
  `id_cidade` int(11) DEFAULT NULL,
  `id_uf` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bairro_tb_cidade_idx` (`id_cidade`),
  KEY `fk_bairro_tb_uf_idx` (`id_uf`),
  CONSTRAINT `fk_bairro_tb_cidade` FOREIGN KEY (`id_cidade`) REFERENCES `tb_cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bairro_tb_uf` FOREIGN KEY (`id_uf`) REFERENCES `tb_uf` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_bairro`
--

LOCK TABLES `tb_bairro` WRITE;
/*!40000 ALTER TABLE `tb_bairro` DISABLE KEYS */;
INSERT INTO `tb_bairro` VALUES (1,'TATUAPÉ',1,1),(2,'CENTRO',2,1),(3,'SÃO RAFAEL',1,1);
/*!40000 ALTER TABLE `tb_bairro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_banco`
--

DROP TABLE IF EXISTS `tb_banco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_banco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `banco` varchar(45) DEFAULT NULL,
  `numBanco` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_banco`
--

LOCK TABLES `tb_banco` WRITE;
/*!40000 ALTER TABLE `tb_banco` DISABLE KEYS */;
INSERT INTO `tb_banco` VALUES (1,'BANCO DO BRASIL','001'),(2,'CAIXA','104'),(3,'BRADESCO','237'),(4,'ITAU','341'),(5,'SANTANDER','033');
/*!40000 ALTER TABLE `tb_banco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_bem`
--

DROP TABLE IF EXISTS `tb_bem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_bem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `vlr_unit` double DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `id_uex` int(11) NOT NULL,
  `id_ano` int(11) DEFAULT NULL,
  `id_trimestre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`id_uex`),
  KEY `fk_tb_cadBem_tb_uex1_idx` (`id_uex`),
  KEY `fk_cadbem_tb_ano_idx` (`id_ano`),
  KEY `fk_cabem_tb_trimestre_idx` (`id_trimestre`),
  CONSTRAINT `fk_cabem_tb_trimestre` FOREIGN KEY (`id_trimestre`) REFERENCES `tb_trimestre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cadbem_tb_ano` FOREIGN KEY (`id_ano`) REFERENCES `tb_ano` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cadbem_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_bem`
--

LOCK TABLES `tb_bem` WRITE;
/*!40000 ALTER TABLE `tb_bem` DISABLE KEYS */;
INSERT INTO `tb_bem` VALUES (1,'Armário Duplo com 3 Gavetas Internas',500,1,1,NULL,NULL),(2,'Notebook Lenovo',1000,1,1,1,1),(3,'Nobreak para Servidor - NBS',400,1,1,1,1);
/*!40000 ALTER TABLE `tb_bem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cidade`
--

DROP TABLE IF EXISTS `tb_cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cidade` varchar(45) DEFAULT NULL,
  `uf_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tb_cidade_tb_uf_idx` (`uf_id`),
  CONSTRAINT `fk_tb_cidade_tb_uf` FOREIGN KEY (`uf_id`) REFERENCES `tb_uf` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cidade`
--

LOCK TABLES `tb_cidade` WRITE;
/*!40000 ALTER TABLE `tb_cidade` DISABLE KEYS */;
INSERT INTO `tb_cidade` VALUES (1,'SÃO PAULO',1),(2,'CAMPINAS',1),(3,'AMERICANAS',1),(4,'ARTUR NOGUEIRA',NULL),(5,'COSMÓPOLIS',1),(6,'ENGENHEIRO COELHO',1),(7,'HOLAMBRA',1),(8,'HORTOLÂNDIA',1),(9,'INDAIATUBA',1),(10,'ITATIBA',1),(11,'JAGUARIÚNA',1),(12,'MONTE MOR',1),(13,'MORUNGABA',1),(14,'NOVA DESSA',1),(15,'PAULÍNIA',1),(16,'PEDREIRA',1),(17,'STA BÁRBARA D\'OESTE',1),(18,'STO ANDRÉ DA POSSE',1),(19,'SUMARÉ',1),(20,'VALINHOS',1),(21,'VINHEDO',1);
/*!40000 ALTER TABLE `tb_cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_conta`
--

DROP TABLE IF EXISTS `tb_conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_conta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numConta` varchar(45) DEFAULT NULL,
  `numAgencia` varchar(45) DEFAULT NULL,
  `id_uex` int(11) DEFAULT NULL,
  `id_programa` int(11) NOT NULL,
  `id_banco` int(11) NOT NULL,
  `conciliado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`,`id_programa`,`id_banco`),
  KEY `fk_conta_tb_uex_idx` (`id_uex`),
  KEY `fk_conta_tb_banco_idx` (`id_banco`),
  KEY `fk_conta_tb_programa_idx` (`id_programa`),
  CONSTRAINT `fk_conta_tb_banco` FOREIGN KEY (`id_banco`) REFERENCES `tb_banco` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_conta_tb_programa` FOREIGN KEY (`id_programa`) REFERENCES `tb_programa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_conta_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_conta`
--

LOCK TABLES `tb_conta` WRITE;
/*!40000 ALTER TABLE `tb_conta` DISABLE KEYS */;
INSERT INTO `tb_conta` VALUES (1,'1333','9999',1,1,1,NULL),(2,'3456','9999',10,1,1,NULL),(5,'989.989-1','1234',8,1,2,NULL);
/*!40000 ALTER TABLE `tb_conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_conta_has_tb_uex`
--

DROP TABLE IF EXISTS `tb_conta_has_tb_uex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_conta_has_tb_uex` (
  `tb_conta_id` int(11) NOT NULL,
  `tb_conta_tb_programa_id` int(11) NOT NULL,
  `tb_conta_tb_banco_id` int(11) NOT NULL,
  `tb_uex_id` int(11) NOT NULL,
  PRIMARY KEY (`tb_conta_id`,`tb_conta_tb_programa_id`,`tb_conta_tb_banco_id`,`tb_uex_id`),
  KEY `fk_tb_conta_has_tb_uex_tb_uex1_idx` (`tb_uex_id`),
  KEY `fk_tb_conta_has_tb_uex_tb_conta1_idx` (`tb_conta_id`,`tb_conta_tb_programa_id`,`tb_conta_tb_banco_id`),
  CONSTRAINT `fk_tb_conta_has_tb_uex_tb_conta1` FOREIGN KEY (`tb_conta_id`, `tb_conta_tb_programa_id`, `tb_conta_tb_banco_id`) REFERENCES `tb_conta` (`id`, `id_programa`, `id_banco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_conta_has_tb_uex_tb_uex1` FOREIGN KEY (`tb_uex_id`) REFERENCES `tb_uex` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_conta_has_tb_uex`
--

LOCK TABLES `tb_conta_has_tb_uex` WRITE;
/*!40000 ALTER TABLE `tb_conta_has_tb_uex` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_conta_has_tb_uex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cpag`
--

DROP TABLE IF EXISTS `tb_cpag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cpag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_emissao` date DEFAULT NULL,
  `nr_docto` varchar(45) DEFAULT NULL,
  `data_pg` date DEFAULT NULL,
  `historico` varchar(60) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `vlr_inss` double DEFAULT NULL,
  `vlr_ir` double DEFAULT NULL,
  `vlr_iss` double DEFAULT NULL,
  `vlr_piscofins` double DEFAULT NULL,
  `vlr_adeduzir` double DEFAULT NULL,
  `vlr_liquido` double DEFAULT NULL,
  `cheque` varchar(7) DEFAULT NULL,
  `dt_cheque` date DEFAULT NULL,
  `conciliado` tinyint(4) DEFAULT '0',
  `contmatic` varchar(10) DEFAULT NULL,
  `apelido` varchar(16) DEFAULT NULL,
  `salaDeRecursos` tinyint(4) DEFAULT NULL,
  `id_tipocontratacao` int(11) DEFAULT NULL,
  `id_tipodespesa` int(11) DEFAULT NULL,
  `id_tipodoc` int(11) DEFAULT NULL,
  `id_tipopessoa` int(11) DEFAULT NULL,
  `id_fornecedor` int(11) DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL,
  `id_ano` int(11) DEFAULT NULL,
  `id_trimestre` int(11) DEFAULT NULL,
  `id_programa` int(11) NOT NULL,
  `id_uex` int(11) NOT NULL,
  PRIMARY KEY (`id`,`id_uex`),
  KEY `fk_tb_cpag_tb_programa_idx` (`id_programa`),
  KEY `fk_tb_cpag_tb_tipocontratacao_idx` (`id_tipocontratacao`),
  KEY `fk_tb_cpag_tb_tipodoc_idx` (`id_tipodoc`),
  KEY `fk_tb_cpag_tb_trimestre_idx` (`id_trimestre`),
  KEY `fk_tb_cpag_tb_ano_idx` (`id_ano`),
  KEY `fk_tb_cpag_tb_pessoa_idx` (`id_tipopessoa`),
  KEY `fk_tb_cpag_tb_tipodesp_idx` (`id_tipodespesa`),
  KEY `fk_cpag_fornecedor_idx` (`id_fornecedor`),
  KEY `fk_cpag_conta_idx` (`id_conta`),
  KEY `fk_tb_cpag_tb_uex1_idx` (`id_uex`),
  CONSTRAINT `fk_cpag_ano` FOREIGN KEY (`id_ano`) REFERENCES `tb_ano` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cpag_conta` FOREIGN KEY (`id_conta`) REFERENCES `tb_conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cpag_fornecedor` FOREIGN KEY (`id_fornecedor`) REFERENCES `tb_pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cpag_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_cpag_tb_pessoa` FOREIGN KEY (`id_tipopessoa`) REFERENCES `tb_tipopessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_cpag_tb_programa` FOREIGN KEY (`id_programa`) REFERENCES `tb_programa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_cpag_tb_tipocontratacao` FOREIGN KEY (`id_tipocontratacao`) REFERENCES `tb_tipocontratacao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_cpag_tb_tipodesp` FOREIGN KEY (`id_tipodespesa`) REFERENCES `tb_tipodesp` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_cpag_tb_tipodoc` FOREIGN KEY (`id_tipodoc`) REFERENCES `tb_tipodoc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_cpag_tb_trimestre` FOREIGN KEY (`id_trimestre`) REFERENCES `tb_trimestre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cpag`
--

LOCK TABLES `tb_cpag` WRITE;
/*!40000 ALTER TABLE `tb_cpag` DISABLE KEYS */;
INSERT INTO `tb_cpag` VALUES (6,'2018-02-05','999','2018-02-06','Despesas ref. a contratação de servicos',123.25,0,0,0,0,0,123.25,'098.099','2018-02-06',1,NULL,NULL,0,NULL,NULL,4,NULL,5,5,3,2,2,8),(7,'2018-02-08','12341243','2018-02-06','Despesas ref. a contratação de servicos',143.25,0,0,0,0,0,143.25,'098.099','2018-02-08',1,NULL,NULL,0,NULL,NULL,3,NULL,4,2,2,2,2,1),(8,'2018-02-07','9879','2018-02-07','Despesas ref. a contratação de servicos',42.25,0,0,0,0,0,42.25,'098.154','2018-02-06',0,NULL,NULL,0,NULL,NULL,1,NULL,4,5,4,2,1,8),(9,'2018-02-08','987U','2018-02-08','Despesas ref. a contratação de servicos',1423.25,0,0,0,0,0,1423.25,'098.012','2018-02-07',0,NULL,NULL,0,NULL,NULL,2,NULL,3,5,2,2,2,8),(15,'2018-02-16','56789','2018-02-07','Despesas com diversas coisas diversas',143.25,0,0,0,0,0,143.25,'123.456','2018-02-17',0,NULL,NULL,0,NULL,NULL,1,NULL,3,2,2,2,1,10),(16,'2018-02-17','123.456','2018-02-17','Despesas com diversas coisas diversas',42.25,0,0,0,0,0,42.25,'123.678','2018-02-17',0,NULL,NULL,0,NULL,NULL,1,NULL,10,2,2,2,1,10),(17,'2018-02-17','78909','2018-02-17','Despesas com diversas coisas diversas',5423.25,0,0,0,0,0,5423.25,'567.987','2018-02-17',1,NULL,NULL,0,NULL,NULL,1,NULL,4,2,2,1,1,10),(18,'2018-02-18','98734','2018-02-25','Despesas referente a compra de artigos diversos',1234.54,0,0,0,0,0,1234.54,'123.987','2018-02-25',1,NULL,NULL,0,NULL,NULL,1,NULL,4,1,1,1,1,1),(19,'2018-02-25','6785','2018-02-25','Despesas com a compra de monitores',345.89,0,0,0,0,0,345.89,'567.897','2018-02-25',1,NULL,NULL,0,NULL,NULL,2,NULL,8,1,1,1,1,1),(20,'2018-02-25','567.890','2018-02-25','Despesa referente a prestação de serviços',876.88,0,0,0,0,0,876.88,'567.890','2018-02-25',1,NULL,NULL,0,NULL,NULL,1,NULL,10,1,1,1,1,1),(21,'2018-02-28','567.789','2018-02-28','Despesas referente aos serviços prestrados',2345.7,0,0,0,0,0,2345.7,'123.456','2018-02-28',0,NULL,NULL,0,NULL,NULL,1,NULL,4,1,1,1,1,1),(22,'2018-02-28','123456','2018-02-28','Aquisição de diversos itens para a escola',1234.54,0,0,0,0,0,12334.45,'123.456','2018-02-18',0,NULL,NULL,0,NULL,NULL,1,NULL,4,1,1,1,1,9),(23,'2018-02-28','123.456','2018-02-28','Despesas milionários de jantares',1234,12,12,12,12,12,1034,'123.456','2017-01-18',0,NULL,NULL,0,NULL,NULL,1,NULL,7,1,1,1,1,9),(24,'2018-02-28','876','2018-02-28','Aquisição de reatores para sala de estudo',1000,10,10,10,10,10,950,'129.675','2018-02-28',0,NULL,NULL,0,NULL,NULL,1,NULL,12,1,1,1,1,12);
/*!40000 ALTER TABLE `tb_cpag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_crec`
--

DROP TABLE IF EXISTS `tb_crec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_crec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_entrada` date DEFAULT NULL,
  `num_doc` varchar(45) DEFAULT NULL,
  `vlr_receita` varchar(45) DEFAULT NULL,
  `historico` varchar(120) DEFAULT NULL,
  `conciliado` varchar(45) DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL,
  `id_trimestre` int(11) DEFAULT NULL,
  `id_programa` int(11) NOT NULL,
  `id_ano` int(11) NOT NULL,
  `id_uex` int(11) NOT NULL,
  PRIMARY KEY (`id`,`id_programa`,`id_ano`,`id_uex`),
  KEY `fk_tb_crec_tb_programa1_idx` (`id_programa`),
  KEY `fk_tb_crec_tb_ano1_idx` (`id_ano`),
  KEY `fk_tb_crec_tb_uex1_idx` (`id_uex`),
  KEY `fk_crec_trimestre_idx` (`id_trimestre`),
  KEY `fk_crec_tb_conta_idx` (`id_conta`),
  CONSTRAINT `fk_crec_tb_ano` FOREIGN KEY (`id_ano`) REFERENCES `tb_ano` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_crec_tb_conta` FOREIGN KEY (`id_conta`) REFERENCES `tb_conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_crec_tb_programa` FOREIGN KEY (`id_programa`) REFERENCES `tb_programa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_crec_tb_trimestre` FOREIGN KEY (`id_trimestre`) REFERENCES `tb_trimestre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_crec_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_crec`
--

LOCK TABLES `tb_crec` WRITE;
/*!40000 ALTER TABLE `tb_crec` DISABLE KEYS */;
INSERT INTO `tb_crec` VALUES (1,'2018-02-07','123','1000','Recebimento de Repasse - 1º Semestre','1',1,1,1,1,1),(2,'2018-02-13','123','10000.0','Recebimento de Repasse - 1º Semestre','1',1,1,1,1,1),(3,'2018-02-25','567890','3000.0','Repasse FNDE - 1º Semestre','1',1,1,1,1,1),(4,'2018-02-25','78909','2300.0','Recebimento de repasse FNDE - 1º Semestre','0',2,1,1,1,9),(5,'2018-02-25','456','2345.0','Repasse','0',1,1,1,1,1),(6,'2018-03-01','1298','50.0','Ajuste do cheque nº 123.456','0',1,1,1,1,1);
/*!40000 ALTER TABLE `tb_crec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_deduc`
--

DROP TABLE IF EXISTS `tb_deduc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_deduc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_deducao` date DEFAULT NULL,
  `num_doc` varchar(45) DEFAULT NULL,
  `historico_deducao` varchar(45) DEFAULT NULL,
  `vlr_deducao` double DEFAULT NULL,
  `conciliado` tinyint(4) DEFAULT NULL,
  `id_programa` int(11) NOT NULL,
  `id_uex` int(11) NOT NULL,
  `id_ano` int(11) DEFAULT NULL,
  `id_trimestre` int(11) DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`id_programa`,`id_uex`),
  KEY `fk_tb_deduc_tb_programa1_idx` (`id_programa`),
  KEY `fk_tb_deduc_tb_uex1_idx` (`id_uex`),
  KEY `fk_deduc_tb_ano_idx` (`id_ano`),
  KEY `fk_deduc_tb_trimestre_idx` (`id_trimestre`),
  KEY `fk_deduc_tb_conta_idx` (`id_conta`),
  CONSTRAINT `fk_deduc_tb_ano` FOREIGN KEY (`id_ano`) REFERENCES `tb_ano` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_deduc_tb_conta` FOREIGN KEY (`id_conta`) REFERENCES `tb_conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_deduc_tb_programa` FOREIGN KEY (`id_programa`) REFERENCES `tb_programa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_deduc_tb_trimestre` FOREIGN KEY (`id_trimestre`) REFERENCES `tb_trimestre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_deduc_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_deduc`
--

LOCK TABLES `tb_deduc` WRITE;
/*!40000 ALTER TABLE `tb_deduc` DISABLE KEYS */;
INSERT INTO `tb_deduc` VALUES (1,'2018-02-12','123','Ajuste de despesa ref. a cheque',1000,0,1,1,1,1,1),(2,'2018-02-25','3456','Dedução de dedutores',100,0,1,1,1,1,1),(3,'2018-02-28','123456','Valor a deduzir',60,0,1,8,1,2,1);
/*!40000 ALTER TABLE `tb_deduc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estadocivil`
--

DROP TABLE IF EXISTS `tb_estadocivil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_estadocivil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estadocivil` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estadocivil`
--

LOCK TABLES `tb_estadocivil` WRITE;
/*!40000 ALTER TABLE `tb_estadocivil` DISABLE KEYS */;
INSERT INTO `tb_estadocivil` VALUES (1,'Solteiro'),(2,'Casado'),(3,'Desquitado'),(4,'Divorciado'),(5,'Viuvo'),(6,'Outros');
/*!40000 ALTER TABLE `tb_estadocivil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_historico`
--

DROP TABLE IF EXISTS `tb_historico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_historico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `historico` varchar(80) DEFAULT NULL,
  `cta_deb` varchar(3) DEFAULT NULL,
  `cta_cred` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_historico`
--

LOCK TABLES `tb_historico` WRITE;
/*!40000 ALTER TABLE `tb_historico` DISABLE KEYS */;
INSERT INTO `tb_historico` VALUES (1,'Despesas Diversas','299','399'),(3,'Despesas com Energia Elétrica','101','102'),(4,'Despesas Bancárias','100','200');
/*!40000 ALTER TABLE `tb_historico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pais`
--

DROP TABLE IF EXISTS `tb_pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pais` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pais`
--

LOCK TABLES `tb_pais` WRITE;
/*!40000 ALTER TABLE `tb_pais` DISABLE KEYS */;
INSERT INTO `tb_pais` VALUES (1,'Brasil');
/*!40000 ALTER TABLE `tb_pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_pessoa`
--

DROP TABLE IF EXISTS `tb_pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `nomeFantasia` varchar(45) DEFAULT NULL,
  `doc_fornecedor` varchar(45) DEFAULT NULL,
  `ccm` varchar(45) DEFAULT NULL,
  `inscEstadual` varchar(45) DEFAULT NULL,
  `identidade` varchar(45) DEFAULT NULL,
  `orgemissor` varchar(45) DEFAULT NULL,
  `emissao_rg` date DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `endNum` varchar(45) DEFAULT NULL,
  `endCompl` varchar(10) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `telFixo` varchar(45) DEFAULT NULL,
  `telCel` varchar(45) DEFAULT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `site` varchar(45) DEFAULT NULL,
  `id_bairro` int(11) NOT NULL,
  `id_cidade` int(11) NOT NULL,
  `id_uf` int(11) NOT NULL,
  `id_pais` int(11) NOT NULL,
  `id_tipopessoa` int(11) NOT NULL,
  `id_sexo` int(11) DEFAULT NULL,
  `id_estadocivil` int(11) DEFAULT NULL,
  `id_uex` int(11) DEFAULT NULL,
  `nacionalidade` varchar(45) DEFAULT NULL,
  `ddd` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`,`id_bairro`,`id_cidade`,`id_pais`,`id_tipopessoa`),
  KEY `fk_tb_pessoa_tb_bairro1_idx` (`id_bairro`),
  KEY `fk_tb_pessoa_tb_cidade1_idx` (`id_cidade`),
  KEY `fk_tb_pessoa_tb_uf1_idx` (`id_uf`),
  KEY `fk_tb_pessoa_tb_pais1_idx` (`id_pais`),
  KEY `fk_tb_pessoa_tb_tipoPessoa1_idx` (`id_tipopessoa`),
  KEY `fk_pessoa_tb_sexo_idx` (`id_sexo`),
  KEY `fk_pessoa_tb_estadocivil_idx` (`id_estadocivil`),
  KEY `fk_pessoa_tb_uex_idx` (`id_uex`),
  CONSTRAINT `fk_pessoa_tb_estadocivil` FOREIGN KEY (`id_estadocivil`) REFERENCES `tb_estadocivil` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pessoa_tb_sexo` FOREIGN KEY (`id_sexo`) REFERENCES `tb_sexo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pessoa_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_pessoa_tb_bairro1` FOREIGN KEY (`id_bairro`) REFERENCES `tb_bairro` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_pessoa_tb_cidade1` FOREIGN KEY (`id_cidade`) REFERENCES `tb_cidade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_pessoa_tb_pais1` FOREIGN KEY (`id_pais`) REFERENCES `tb_pais` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_pessoa_tb_tipoPessoa1` FOREIGN KEY (`id_tipopessoa`) REFERENCES `tb_tipopessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tb_pessoa_tb_uf1` FOREIGN KEY (`id_uf`) REFERENCES `tb_uf` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_pessoa`
--

LOCK TABLES `tb_pessoa` WRITE;
/*!40000 ALTER TABLE `tb_pessoa` DISABLE KEYS */;
INSERT INTO `tb_pessoa` VALUES (2,'OI TELECOMUNICAÇÕES S/A','OI','12.666.666/0001-95','1','2','4',NULL,NULL,'RUA ERNESTO MARIMBA','123','2º ANDAR','06789-000','3456-4567','999',NULL,'email','site',1,1,1,1,2,NULL,NULL,NULL,NULL,NULL),(3,'AQUELA EMPRESA COM IND LTDA','AQUELA','55.555.555/0001-55',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'email','site',1,1,1,1,2,NULL,NULL,NULL,NULL,NULL),(4,'AGORA IND COM LTDA','AGORA','12.123.123/0001-12',NULL,NULL,NULL,NULL,NULL,'RUA NASSER','123','123','04571000','5432-1234',NULL,NULL,'teste@teste.com.br',NULL,1,1,1,1,2,NULL,NULL,NULL,NULL,NULL),(5,'TESTE E TESTADO S/A','TESTE','12.123.123/0001-11',NULL,NULL,NULL,NULL,NULL,'RUA TESTE','123','123','04444-000','5432-1111',NULL,NULL,'teste@teste.com.br',NULL,1,1,1,1,2,NULL,NULL,NULL,NULL,NULL),(6,'METALUZ IND COM LTDA','METALUZ','13.134.134/0001-55',NULL,NULL,NULL,NULL,NULL,'RUA NOVENTA','123','123','04444-000','5432-1234',NULL,NULL,'teste@gmail.com',NULL,1,1,1,1,2,NULL,NULL,NULL,NULL,NULL),(7,'FUTEBOL CLUBE S/A','FUTEBOLCLUBE','56.567.123/0001-99',NULL,NULL,NULL,NULL,NULL,'RUA SETENTA E NOVE','456','UIA','05454-000','2222-2222',NULL,NULL,'eitanois@futebol.com.br',NULL,1,1,1,1,2,NULL,NULL,NULL,NULL,NULL),(8,'JURANDIR JURANDO DE SOUZA',NULL,'113.113.113-99',NULL,NULL,NULL,NULL,NULL,'RUA TREZE','123','123','04455-000','5432-1234',NULL,NULL,'teste@teste.com.br',NULL,1,1,1,1,1,NULL,NULL,NULL,NULL,NULL),(9,'MARLINDA DA SILVA','ii','456.789.000-99',NULL,NULL,NULL,NULL,NULL,'RUA NORTE','145','SERN','04455-000','9934-5670',NULL,NULL,'email','site',1,1,1,1,1,NULL,NULL,NULL,NULL,NULL),(10,'CARDOSO E MELO ASSOCIADOS LTDA','CARDOSO','33.133.445/0001-99',NULL,NULL,NULL,NULL,NULL,'RUA NOVEMGATUR','345','234','04455000','4567-4567',NULL,NULL,'teste@gmailc.om',NULL,1,1,1,1,2,NULL,NULL,NULL,NULL,NULL),(11,'MANOEL BANDEIRA DA SILVA',NULL,'111.111.111-11',NULL,NULL,NULL,NULL,NULL,'RUA NOVENTA E SETE','123',NULL,'05543-000','3456-7890',NULL,NULL,'MMMM',NULL,1,1,1,1,1,NULL,NULL,NULL,NULL,NULL),(12,'JOSE DA SILVA',NULL,'999.999.999-00',NULL,NULL,NULL,NULL,NULL,'RUA NOELI ','34',NULL,'00000-000','3456-7890',NULL,NULL,'IIII',NULL,1,1,1,1,1,NULL,NULL,NULL,NULL,NULL),(13,'MANOELZINHO DA ROCHA',NULL,'456.789.098-00',NULL,NULL,NULL,NULL,NULL,'RUA MONELETO','78',NULL,'06768-990','3456-7890',NULL,NULL,'email','site',1,1,1,1,1,NULL,NULL,NULL,NULL,NULL),(16,'LUIZ INACIO',NULL,'154.567.890-22',NULL,NULL,'Diretor','SSP-SP','2018-02-12','Rua Tome de Souza ','165','Sala 2','04567-909','2345-6789','98762-2345','19.987.987-X','lula@email.com.br',NULL,1,1,1,1,1,1,1,1,'Brasileira','11'),(17,'JOAO DA SILVA','JOAO','123.456.789-00',NULL,NULL,NULL,NULL,NULL,'RUA DA LUA','22','12','04456-000','3456-6666',NULL,NULL,'@',NULL,1,1,1,1,1,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_plancontas`
--

DROP TABLE IF EXISTS `tb_plancontas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_plancontas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_conta` varchar(45) DEFAULT NULL,
  `cod_reduzido` varchar(3) DEFAULT NULL,
  `natureza` varchar(1) DEFAULT NULL,
  `classe` varchar(45) DEFAULT NULL,
  `grupo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_plancontas`
--

LOCK TABLES `tb_plancontas` WRITE;
/*!40000 ALTER TABLE `tb_plancontas` DISABLE KEYS */;
INSERT INTO `tb_plancontas` VALUES (1,'Despesas Diversas','299','1','1','2');
/*!40000 ALTER TABLE `tb_plancontas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_programa`
--

DROP TABLE IF EXISTS `tb_programa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_programa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `programa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_programa`
--

LOCK TABLES `tb_programa` WRITE;
/*!40000 ALTER TABLE `tb_programa` DISABLE KEYS */;
INSERT INTO `tb_programa` VALUES (1,'CONTA ESCOLA'),(2,'PDDE - Programa Dinheiro Direto na Escola'),(3,'PDDE - Acessibilidade'),(7,'PDDE - Mais Educação');
/*!40000 ALTER TABLE `tb_programa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_saldos`
--

DROP TABLE IF EXISTS `tb_saldos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_saldos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `sdo_inicial` double DEFAULT NULL,
  `vlr_repasse` double DEFAULT NULL,
  `vlr_aplicacao` double DEFAULT NULL,
  `vlr_rendAplicacao` double DEFAULT NULL,
  `vlr_poupanca` double DEFAULT NULL,
  `sdo_investimentos` double DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL,
  `id_trimestre` int(11) DEFAULT NULL,
  `id_ano` int(11) DEFAULT NULL,
  `id_programa` int(11) NOT NULL,
  `id_uex` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tb_saldo_tb_programa1_idx` (`id_programa`),
  KEY `fk_tb_saldo_tb_uex1_idx` (`id_uex`),
  KEY `fk_saldos_tb_ano_idx` (`id_ano`),
  KEY `fk_saldos_tb_trimestre_idx` (`id_trimestre`),
  KEY `fk_saldo_tb_conta_idx` (`id_conta`),
  CONSTRAINT `fk_saldos_tb_ano` FOREIGN KEY (`id_ano`) REFERENCES `tb_ano` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_saldos_tb_conta` FOREIGN KEY (`id_conta`) REFERENCES `tb_conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_saldos_tb_programa` FOREIGN KEY (`id_programa`) REFERENCES `tb_programa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_saldos_tb_trimestre` FOREIGN KEY (`id_trimestre`) REFERENCES `tb_trimestre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_saldos_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_saldos`
--

LOCK TABLES `tb_saldos` WRITE;
/*!40000 ALTER TABLE `tb_saldos` DISABLE KEYS */;
INSERT INTO `tb_saldos` VALUES (1,'2018-02-13',1234,123,123,123,123,123,1,1,1,1,1),(3,'2018-02-18',797.31,5432.01,1456.09,23.46,234.59,34567.8,2,2,2,1,10),(4,'2018-02-20',7890,8500,5678,234.95,1234.56,7891.01,5,1,2,1,8);
/*!40000 ALTER TABLE `tb_saldos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sexo`
--

DROP TABLE IF EXISTS `tb_sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sexo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sexo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sexo`
--

LOCK TABLES `tb_sexo` WRITE;
/*!40000 ALTER TABLE `tb_sexo` DISABLE KEYS */;
INSERT INTO `tb_sexo` VALUES (1,'Feminino'),(2,'Masculino');
/*!40000 ALTER TABLE `tb_sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sradicoes`
--

DROP TABLE IF EXISTS `tb_sradicoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sradicoes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_adicao` date DEFAULT NULL,
  `num_doc` varchar(45) DEFAULT NULL,
  `historico_adicao` varchar(45) DEFAULT NULL,
  `vlr_adicao` double DEFAULT NULL,
  `conciliado` tinyint(4) DEFAULT NULL,
  `id_programa` int(11) NOT NULL,
  `id_uex` int(11) DEFAULT NULL,
  `id_ano` int(11) DEFAULT NULL,
  `id_trimestre` int(11) DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tb_adicoesSR_tb_programa1_idx` (`id_programa`),
  KEY `fk_sradicoes_tb_uex_idx` (`id_uex`),
  KEY `fk_sradicoes_tb_ano_idx` (`id_ano`),
  KEY `fk_sradicoes_tb_trimestre_idx` (`id_trimestre`),
  KEY `fk_sradicoes_tb_conta_idx` (`id_conta`),
  CONSTRAINT `fk_sradicoes_tb_ano` FOREIGN KEY (`id_ano`) REFERENCES `tb_ano` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sradicoes_tb_conta` FOREIGN KEY (`id_conta`) REFERENCES `tb_conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sradicoes_tb_programa` FOREIGN KEY (`id_programa`) REFERENCES `tb_programa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sradicoes_tb_trimestre` FOREIGN KEY (`id_trimestre`) REFERENCES `tb_trimestre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sradicoes_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sradicoes`
--

LOCK TABLES `tb_sradicoes` WRITE;
/*!40000 ALTER TABLE `tb_sradicoes` DISABLE KEYS */;
INSERT INTO `tb_sradicoes` VALUES (1,'2018-02-13','123.456','Valor referente a adição',100,0,1,1,1,1,1),(2,'2018-03-07','567.890','Adição SR',111.01,1,1,1,1,1,1);
/*!40000 ALTER TABLE `tb_sradicoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_srcpag`
--

DROP TABLE IF EXISTS `tb_srcpag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_srcpag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_emissao` date DEFAULT NULL,
  `nr_docto` varchar(45) DEFAULT NULL,
  `data_pg` date DEFAULT NULL,
  `historico` varchar(45) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `vlr_inss` double DEFAULT NULL,
  `vlr_ir` double DEFAULT NULL,
  `vlr_iss` double DEFAULT NULL,
  `vlr_piscofins` double DEFAULT NULL,
  `vlr_adeduzir` double DEFAULT NULL,
  `vlr_liquido` double DEFAULT NULL,
  `cheque` varchar(45) DEFAULT NULL,
  `dt_cheque` date DEFAULT NULL,
  `conciliado` tinyint(4) DEFAULT NULL,
  `contmatic` varchar(45) DEFAULT NULL,
  `id_ano` int(11) DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL,
  `id_programa` int(11) NOT NULL,
  `id_uex` int(11) NOT NULL,
  `id_tipopessoa` int(11) DEFAULT NULL,
  `id_tipodespesa` int(11) DEFAULT NULL,
  `id_tipocontratacao` int(11) DEFAULT NULL,
  `id_tipodoc` int(11) DEFAULT NULL,
  `id_fornecedor` int(11) DEFAULT NULL,
  `id_trimestre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`id_programa`,`id_uex`),
  KEY `fk_tb_pagSR_tb_programa1_idx` (`id_programa`),
  KEY `fk_tb_pagSR_tb_uex1_idx` (`id_uex`),
  KEY `fk_srcpag_tb_tipocontratacao_idx` (`id_tipocontratacao`),
  KEY `fk_srsaldo_tb_tipodespesa_idx` (`id_tipodespesa`),
  KEY `fk_srscpag_tb_tipodoc_idx` (`id_tipodoc`),
  KEY `fk_srscpag_tb_tipopessoa_idx` (`id_tipopessoa`),
  KEY `fk_srscpag_tb_conta_idx` (`id_conta`),
  KEY `fk_srscpag_tb_ano_idx` (`id_ano`),
  KEY `fk_srscpag_tb_trimestre_idx` (`id_trimestre`),
  KEY `fk_srscpag_tb_pessoa_idx` (`id_fornecedor`),
  CONSTRAINT `fk_srcpag_tb_programa` FOREIGN KEY (`id_programa`) REFERENCES `tb_programa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srcpag_tb_tipocontratacao` FOREIGN KEY (`id_tipocontratacao`) REFERENCES `tb_tipocontratacao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srcpag_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srscpag_tb_conta` FOREIGN KEY (`id_conta`) REFERENCES `tb_conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srscpag_tb_pessoa` FOREIGN KEY (`id_fornecedor`) REFERENCES `tb_pessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srscpag_tb_tipocontratacao` FOREIGN KEY (`id_tipocontratacao`) REFERENCES `tb_tipocontratacao` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srscpag_tb_tipodespesa` FOREIGN KEY (`id_tipodespesa`) REFERENCES `tb_tipodesp` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srscpag_tb_tipodoc` FOREIGN KEY (`id_tipodoc`) REFERENCES `tb_tipodoc` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srscpag_tb_tipopessoa` FOREIGN KEY (`id_tipopessoa`) REFERENCES `tb_tipopessoa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_srcpag`
--

LOCK TABLES `tb_srcpag` WRITE;
/*!40000 ALTER TABLE `tb_srcpag` DISABLE KEYS */;
INSERT INTO `tb_srcpag` VALUES (1,'2018-02-13','123.456','2018-02-13','Despesas diversas',1234,0,0,0,0,0,0,'123.456','2018-02-13',0,NULL,1,1,1,1,NULL,NULL,NULL,1,4,1),(2,'2018-03-07','123.567','2018-03-07','Pagamento SR',567.01,0,0,0,0,0,0,'345.678','2018-03-23',0,NULL,1,1,1,1,NULL,NULL,NULL,1,8,1);
/*!40000 ALTER TABLE `tb_srcpag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_srcrec`
--

DROP TABLE IF EXISTS `tb_srcrec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_srcrec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_entrada` date DEFAULT NULL,
  `num_doc` varchar(45) DEFAULT NULL,
  `vlr_receita` double DEFAULT NULL,
  `historico` varchar(120) DEFAULT NULL,
  `conciliado` tinyint(4) DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL,
  `id_trimestre` int(11) DEFAULT NULL,
  `id_programa` int(11) DEFAULT NULL,
  `id_ano` int(11) DEFAULT NULL,
  `id_uex` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_srcrec_tb_conta_idx` (`id_conta`),
  KEY `fk_srcrec_tb_trimestre_idx` (`id_trimestre`),
  KEY `fk_srcrec_tb_programa_idx` (`id_programa`),
  KEY `fk_srcrec_tb_ano_idx` (`id_ano`),
  KEY `fk_srcrec_tb_uex_idx` (`id_uex`),
  CONSTRAINT `fk_srcrec_tb_ano` FOREIGN KEY (`id_ano`) REFERENCES `tb_ano` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srcrec_tb_conta` FOREIGN KEY (`id_conta`) REFERENCES `tb_conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srcrec_tb_programa` FOREIGN KEY (`id_programa`) REFERENCES `tb_programa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srcrec_tb_trimestre` FOREIGN KEY (`id_trimestre`) REFERENCES `tb_trimestre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srcrec_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_srcrec`
--

LOCK TABLES `tb_srcrec` WRITE;
/*!40000 ALTER TABLE `tb_srcrec` DISABLE KEYS */;
INSERT INTO `tb_srcrec` VALUES (1,'2018-02-13','123456',1234,'Receitas ssssssssssss',NULL,1,1,1,1,1),(2,'2018-03-07','345.678',567.02,'Recebimento SR',NULL,1,1,1,1,1);
/*!40000 ALTER TABLE `tb_srcrec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_srdeducao`
--

DROP TABLE IF EXISTS `tb_srdeducao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_srdeducao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_deducao` date DEFAULT NULL,
  `num_doc` varchar(45) DEFAULT NULL,
  `historico_deducao` varchar(45) DEFAULT NULL,
  `vlr_deducao` double DEFAULT NULL,
  `conciliado` tinyint(4) DEFAULT NULL,
  `id_programa` int(11) NOT NULL,
  `id_uex` int(11) NOT NULL,
  `id_ano` int(11) DEFAULT NULL,
  `id_trimestre` int(11) DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`id_programa`,`id_uex`),
  KEY `fk_tb_deducSR_tb_programa1_idx` (`id_programa`),
  KEY `fk_tb_deducSR_tb_uex1_idx` (`id_uex`),
  KEY `fk_srdeducao_tb_ano_idx` (`id_ano`),
  KEY `fk_trimestre_tb_trimestre_idx` (`id_trimestre`),
  KEY `fk_srdeducao_tb_conta_idx` (`id_conta`),
  CONSTRAINT `fk_srdeducao_tb_ano` FOREIGN KEY (`id_ano`) REFERENCES `tb_ano` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srdeducao_tb_conta` FOREIGN KEY (`id_conta`) REFERENCES `tb_conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srdeducao_tb_programa` FOREIGN KEY (`id_programa`) REFERENCES `tb_programa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srdeducao_tb_trimestre` FOREIGN KEY (`id_trimestre`) REFERENCES `tb_trimestre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srdeducao_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_srdeducao`
--

LOCK TABLES `tb_srdeducao` WRITE;
/*!40000 ALTER TABLE `tb_srdeducao` DISABLE KEYS */;
INSERT INTO `tb_srdeducao` VALUES (1,'2018-02-13','123.456','Valor referete a dedução SR',123,NULL,1,1,1,1,NULL),(2,'2018-03-07','123','SR Dedução',100.01,NULL,1,1,1,1,NULL),(3,'2018-03-07','567','SR Dedução',56.71,NULL,1,1,1,1,1);
/*!40000 ALTER TABLE `tb_srdeducao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_srsaldos`
--

DROP TABLE IF EXISTS `tb_srsaldos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_srsaldos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `sdo_inicial` double DEFAULT NULL,
  `vlr_repasse` double DEFAULT NULL,
  `vlr_aplicacao` double DEFAULT NULL,
  `vlr_rendAplicacao` double DEFAULT NULL,
  `vlr_poupanca` double DEFAULT NULL,
  `sdo_investimentos` double DEFAULT NULL,
  `sala_recursos` tinyint(4) DEFAULT NULL,
  `id_conta` int(11) DEFAULT NULL,
  `id_programa` int(11) NOT NULL,
  `id_uex` int(11) NOT NULL,
  `id_ano` int(11) DEFAULT NULL,
  `id_trimestre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`id_programa`,`id_uex`),
  KEY `fk_tb_saldoSR_tb_programa1_idx` (`id_programa`),
  KEY `fk_tb_saldoSR_tb_uex1_idx` (`id_uex`),
  KEY `fk_srsaldo_tb_conta_idx` (`id_conta`),
  KEY `fk_srsaldo_tb_ano_idx` (`id_ano`),
  KEY `fk_srsaldo_tb_trimestre_idx` (`id_trimestre`),
  CONSTRAINT `fk_srsaldo_tb_ano` FOREIGN KEY (`id_ano`) REFERENCES `tb_ano` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srsaldo_tb_conta` FOREIGN KEY (`id_conta`) REFERENCES `tb_conta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srsaldo_tb_programa` FOREIGN KEY (`id_programa`) REFERENCES `tb_programa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srsaldo_tb_trimestre` FOREIGN KEY (`id_trimestre`) REFERENCES `tb_trimestre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_srsaldo_tb_uex` FOREIGN KEY (`id_uex`) REFERENCES `tb_uex` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_srsaldos`
--

LOCK TABLES `tb_srsaldos` WRITE;
/*!40000 ALTER TABLE `tb_srsaldos` DISABLE KEYS */;
INSERT INTO `tb_srsaldos` VALUES (1,'2018-02-13',123,123,123,123,123,123,NULL,1,1,1,1,1);
/*!40000 ALTER TABLE `tb_srsaldos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipocontratacao`
--

DROP TABLE IF EXISTS `tb_tipocontratacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipocontratacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipoContratacao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipocontratacao`
--

LOCK TABLES `tb_tipocontratacao` WRITE;
/*!40000 ALTER TABLE `tb_tipocontratacao` DISABLE KEYS */;
INSERT INTO `tb_tipocontratacao` VALUES (1,'Produto'),(2,'Serviço');
/*!40000 ALTER TABLE `tb_tipocontratacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipodesp`
--

DROP TABLE IF EXISTS `tb_tipodesp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipodesp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipoDesp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipodesp`
--

LOCK TABLES `tb_tipodesp` WRITE;
/*!40000 ALTER TABLE `tb_tipodesp` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tipodesp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipodoc`
--

DROP TABLE IF EXISTS `tb_tipodoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipodoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipoDoc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipodoc`
--

LOCK TABLES `tb_tipodoc` WRITE;
/*!40000 ALTER TABLE `tb_tipodoc` DISABLE KEYS */;
INSERT INTO `tb_tipodoc` VALUES (1,'NF'),(2,'Fatura'),(3,'Recibo'),(4,'Tarifa'),(5,'Darf'),(6,'GPS'),(7,'Guia'),(8,'Debito Conta'),(9,'Cartão de Crédito');
/*!40000 ALTER TABLE `tb_tipodoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipoentidade`
--

DROP TABLE IF EXISTS `tb_tipoentidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipoentidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_entidade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipoentidade`
--

LOCK TABLES `tb_tipoentidade` WRITE;
/*!40000 ALTER TABLE `tb_tipoentidade` DISABLE KEYS */;
INSERT INTO `tb_tipoentidade` VALUES (1,'PREFEITURA MUNICIPAL'),(3,'SECRETARIA DE EDUCAÇÃO ESTADUAL'),(4,'SECRETARIA MUNICIPAL DE EDUCAÇÃO'),(5,'OUTRO ORGÃO ESTADUAL'),(6,'ORGÃO FEDERAL'),(7,'ENTIDADE PRIVADA SEM FINS LUCRATIVOS');
/*!40000 ALTER TABLE `tb_tipoentidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipopessoa`
--

DROP TABLE IF EXISTS `tb_tipopessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tipopessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipoPessoa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipopessoa`
--

LOCK TABLES `tb_tipopessoa` WRITE;
/*!40000 ALTER TABLE `tb_tipopessoa` DISABLE KEYS */;
INSERT INTO `tb_tipopessoa` VALUES (1,'Física'),(2,'Jurídica');
/*!40000 ALTER TABLE `tb_tipopessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tiporec`
--

DROP TABLE IF EXISTS `tb_tiporec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_tiporec` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipoRec` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tiporec`
--

LOCK TABLES `tb_tiporec` WRITE;
/*!40000 ALTER TABLE `tb_tiporec` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tiporec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_trimestre`
--

DROP TABLE IF EXISTS `tb_trimestre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_trimestre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trimestre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_trimestre`
--

LOCK TABLES `tb_trimestre` WRITE;
/*!40000 ALTER TABLE `tb_trimestre` DISABLE KEYS */;
INSERT INTO `tb_trimestre` VALUES (1,'1º Trimestre'),(2,'2º Trimestre'),(3,'3º Trimestre'),(4,'4º Trimestre');
/*!40000 ALTER TABLE `tb_trimestre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_uex`
--

DROP TABLE IF EXISTS `tb_uex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_uex` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uExF` varchar(150) DEFAULT NULL,
  `uEx` varchar(150) DEFAULT NULL,
  `apelido` varchar(20) DEFAULT NULL,
  `CNPJ` varchar(20) DEFAULT NULL,
  `endRua` varchar(150) DEFAULT NULL,
  `endNum` varchar(10) DEFAULT NULL,
  `endCompl` varchar(15) DEFAULT NULL,
  `CEP` varchar(9) DEFAULT NULL,
  `idBairro` int(11) DEFAULT NULL,
  `idCidade` int(11) DEFAULT NULL,
  `idUf` int(11) DEFAULT NULL,
  `cxPostal` varchar(45) DEFAULT NULL,
  `ddd` varchar(45) DEFAULT NULL,
  `telefone` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telEntidade` varchar(45) DEFAULT NULL,
  `faxEntidade` varchar(45) DEFAULT NULL,
  `undGestoraOrgFed` varchar(45) DEFAULT NULL,
  `CNAS` varchar(45) DEFAULT NULL,
  `codCenso` varchar(45) DEFAULT NULL,
  `nomeEscola` varchar(120) DEFAULT NULL,
  `contmatic` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idx` (`idBairro`),
  KEY `fk_uex_tb_cidade_idx` (`idCidade`),
  KEY `fk_uex_tb_uf_idx` (`idUf`),
  CONSTRAINT `fk_uex_tb_bairro` FOREIGN KEY (`idBairro`) REFERENCES `tb_bairro` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_uex_tb_cidade` FOREIGN KEY (`idCidade`) REFERENCES `tb_cidade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_uex_tb_uf` FOREIGN KEY (`idUf`) REFERENCES `tb_uf` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_uex`
--

LOCK TABLES `tb_uex` WRITE;
/*!40000 ALTER TABLE `tb_uex` DISABLE KEYS */;
INSERT INTO `tb_uex` VALUES (1,'CEI ADÃO EMILIANO','CEI ADÃO EMILIANO','ADAOEMILIANO','13.134.145/0001-98','Rua Certa','123',NULL,'04571-000',2,2,1,'12345-5','11',NULL,'5432-1234','teste@teste.com.br',NULL,'5432-1234','12345','12345','12345','ESCOLA ADAO EMILIANO','2009'),(8,'CEI JOSÉ FIDELIS','CENTRO DE EDUCAÇÃO INFANTIL JOSE FIDELIS ','JOSEFIDELIS','12.123.123/0001-55','RUA TREZE DE MAIO','123',NULL,'04554-000',2,2,1,'1234567','11',NULL,'5432-1234','teste@teste.com.br',NULL,'5432-1234','12345','12345-5','1234-5','ESCOLA MUNICIPAL JOSÉ FIDÉLIS','2024'),(9,'EMEI AGOSTINHO PATTARO','EMEI AGOSTINHO PATTARO','AGOSTINHOPATTAR','15.134.145/0001-98','Rua Bem Ali','123',NULL,NULL,2,2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016'),(10,'CEMEI ALEXANDRE SARTORI FARIA','CEMEI ALEXANDRE SARTORI FARIA','ALEXANDRESARTOR','16.134.145/0001-98','Rua Bem Ali','123',NULL,NULL,2,2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2053'),(12,'ESCOLA EMEF ANALIA FERRAZ DA COSTA COUTO','ESCOLA EMEF ANALIA FERRAZ DA COSTA COUTO','ANALIAFERRAZ','56.134.145/0001-98','Rua Bem Ali','123',NULL,NULL,2,2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'ESCOLA EMEF ANALIA FERRAZ DA COSTA COUTO','2221'),(13,'CENTRO DE EDUCAÇÃO INFANTIL PROF. MARIA HERMINIA FERNANDES MAGALHAES','CENTRO DE EDUCAÇÃO INFANTIL PROF. MARIA HERMINIA FERNANDES MAGALHAES','MARIAHERMINIA','51.134.145/0001-98','Rua Bem Ali','123',NULL,NULL,2,2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CENTRO DE EDUCAÇÃO INFANTIL PROF. MARIA HERMINIA FERNANDES MAGALHAES','2007'),(14,'CEI MARIA ODETE DE SOUZA MOTTA','CEI MARIA ODETE DE SOUZA MOTTA','MARIAODETE','11.134.145/0001-98','Rua Bem Ali','123',NULL,NULL,2,2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CEI MARIA ODETE DE SOUZA MOTTA','2062');
/*!40000 ALTER TABLE `tb_uex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_uf`
--

DROP TABLE IF EXISTS `tb_uf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_uf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uf` varchar(45) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_uf`
--

LOCK TABLES `tb_uf` WRITE;
/*!40000 ALTER TABLE `tb_uf` DISABLE KEYS */;
INSERT INTO `tb_uf` VALUES (1,'SP','SÃO PAULO'),(2,'AC','ACRE'),(3,'AM','AMAZONAS'),(4,'AP','AMAPÁ'),(5,'BA','BAHIA'),(6,'CE','CEARÁ'),(7,'DF','DISTRITO FEDERAL'),(8,'ES','ESPÍRITO SANTO'),(9,'GO','GOIÁS'),(10,'MA','MARANHÃO'),(11,'MG','MINAS GERAIS'),(12,'MS','MATO GROSSO DO SUL'),(13,'MT','MATO GROSSO'),(14,'PA','PARÁ'),(15,'PB','PARAÍBA'),(16,'PE','PERNAMBUCO'),(17,'PI','PIAUÍ'),(18,'PR','PARANÁ'),(19,'RJ','RIO DE JANIEIRO'),(20,'RN','RIO GRANDE DO NORTE'),(21,'RO','RONDONIA'),(22,'RR','RORAIMA'),(23,'RS','RIO GRANDE DO SUL'),(24,'SC','SANTA CATARINA'),(25,'SE','SERGIPE'),(26,'TO','TOCANTINS');
/*!40000 ALTER TABLE `tb_uf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_adicoes`
--

DROP TABLE IF EXISTS `vw_adicoes`;
/*!50001 DROP VIEW IF EXISTS `vw_adicoes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_adicoes` AS SELECT 
 1 AS `id`,
 1 AS `data_adicao`,
 1 AS `num_doc`,
 1 AS `historico_adicao`,
 1 AS `vlr_adicao`,
 1 AS `id_programa`,
 1 AS `id_uex`,
 1 AS `id_ano`,
 1 AS `id_trimestre`,
 1 AS `id_conta`,
 1 AS `pid`,
 1 AS `programa`,
 1 AS `uid`,
 1 AS `uex`,
 1 AS `aid`,
 1 AS `ano`,
 1 AS `tid`,
 1 AS `trimestre`,
 1 AS `cid`,
 1 AS `conta`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_bairrocidadeuf`
--

DROP TABLE IF EXISTS `vw_bairrocidadeuf`;
/*!50001 DROP VIEW IF EXISTS `vw_bairrocidadeuf`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_bairrocidadeuf` AS SELECT 
 1 AS `idbairro`,
 1 AS `bairro`,
 1 AS `id_cidade`,
 1 AS `cid`,
 1 AS `cidadelabel`,
 1 AS `id_uf`,
 1 AS `uid`,
 1 AS `uflabel`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_bemuexanotrimestre`
--

DROP TABLE IF EXISTS `vw_bemuexanotrimestre`;
/*!50001 DROP VIEW IF EXISTS `vw_bemuexanotrimestre`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_bemuexanotrimestre` AS SELECT 
 1 AS `id`,
 1 AS `descricao`,
 1 AS `vlr_unit`,
 1 AS `qtd`,
 1 AS `id_trimestre`,
 1 AS `id_ano`,
 1 AS `cid`,
 1 AS `trimestre`,
 1 AS `id_uex`,
 1 AS `uid`,
 1 AS `uex`,
 1 AS `ano`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_cidadeuf`
--

DROP TABLE IF EXISTS `vw_cidadeuf`;
/*!50001 DROP VIEW IF EXISTS `vw_cidadeuf`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_cidadeuf` AS SELECT 
 1 AS `idcidade`,
 1 AS `municipio`,
 1 AS `uf_id`,
 1 AS `uid`,
 1 AS `uflabel`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_conciliacaodadosbancarios`
--

DROP TABLE IF EXISTS `vw_conciliacaodadosbancarios`;
/*!50001 DROP VIEW IF EXISTS `vw_conciliacaodadosbancarios`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_conciliacaodadosbancarios` AS SELECT 
 1 AS `id`,
 1 AS `numConta`,
 1 AS `numAgencia`,
 1 AS `id_uex`,
 1 AS `uex`,
 1 AS `id_programa`,
 1 AS `programa`,
 1 AS `id_banco`,
 1 AS `numBanco`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_conciliacaosaldoscontabyuex`
--

DROP TABLE IF EXISTS `vw_conciliacaosaldoscontabyuex`;
/*!50001 DROP VIEW IF EXISTS `vw_conciliacaosaldoscontabyuex`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_conciliacaosaldoscontabyuex` AS SELECT 
 1 AS `id`,
 1 AS `sdo_inicial`,
 1 AS `vlr_repasse`,
 1 AS `vlr_aplicacao`,
 1 AS `vlr_rendAplicacao`,
 1 AS `vlr_poupanca`,
 1 AS `sdo_investimentos`,
 1 AS `id_conta`,
 1 AS `ctid`,
 1 AS `numConta`,
 1 AS `numAgencia`,
 1 AS `id_banco`,
 1 AS `bid`,
 1 AS `numBanco`,
 1 AS `id_uex`,
 1 AS `uid`,
 1 AS `uex`,
 1 AS `id_programa`,
 1 AS `id_ano`,
 1 AS `aid`,
 1 AS `ano`,
 1 AS `id_trimestre`,
 1 AS `tid`,
 1 AS `trimestre`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_contabancouex`
--

DROP TABLE IF EXISTS `vw_contabancouex`;
/*!50001 DROP VIEW IF EXISTS `vw_contabancouex`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_contabancouex` AS SELECT 
 1 AS `idconta`,
 1 AS `conta`,
 1 AS `agencia`,
 1 AS `id_programa`,
 1 AS `idbanco`,
 1 AS `banco`,
 1 AS `id_uex`,
 1 AS `uid`,
 1 AS `uexlabel`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_cpagpessoa`
--

DROP TABLE IF EXISTS `vw_cpagpessoa`;
/*!50001 DROP VIEW IF EXISTS `vw_cpagpessoa`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_cpagpessoa` AS SELECT 
 1 AS `idcpag`,
 1 AS `data_emissao`,
 1 AS `nr_docto`,
 1 AS `data_pg`,
 1 AS `historico`,
 1 AS `id_fornecedor`,
 1 AS `cheque`,
 1 AS `dt_cheque`,
 1 AS `valor`,
 1 AS `vlr_inss`,
 1 AS `vlr_piscofins`,
 1 AS `vlr_ir`,
 1 AS `vlr_iss`,
 1 AS `vlr_adeduzir`,
 1 AS `vlr_liquido`,
 1 AS `id_uex`,
 1 AS `id_trimestre`,
 1 AS `trid`,
 1 AS `trimestre`,
 1 AS `id_ano`,
 1 AS `aid`,
 1 AS `ano`,
 1 AS `uid`,
 1 AS `uex`,
 1 AS `prid`,
 1 AS `programa`,
 1 AS `pid`,
 1 AS `nomelabel`,
 1 AS `doc_fornecedor`,
 1 AS `id_conta`,
 1 AS `ctid`,
 1 AS `conta`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_crecprogramauexanotrimestre`
--

DROP TABLE IF EXISTS `vw_crecprogramauexanotrimestre`;
/*!50001 DROP VIEW IF EXISTS `vw_crecprogramauexanotrimestre`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_crecprogramauexanotrimestre` AS SELECT 
 1 AS `id`,
 1 AS `data_entrada`,
 1 AS `num_doc`,
 1 AS `historico`,
 1 AS `vlr_receita`,
 1 AS `id_uex`,
 1 AS `id_trimestre`,
 1 AS `id_programa`,
 1 AS `trid`,
 1 AS `trimestre`,
 1 AS `id_ano`,
 1 AS `aid`,
 1 AS `ano`,
 1 AS `uid`,
 1 AS `uex`,
 1 AS `prid`,
 1 AS `programa`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_deducoes`
--

DROP TABLE IF EXISTS `vw_deducoes`;
/*!50001 DROP VIEW IF EXISTS `vw_deducoes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_deducoes` AS SELECT 
 1 AS `id`,
 1 AS `data_deducao`,
 1 AS `num_doc`,
 1 AS `historico_deducao`,
 1 AS `vlr_deducao`,
 1 AS `id_programa`,
 1 AS `id_uex`,
 1 AS `id_ano`,
 1 AS `id_trimestre`,
 1 AS `id_conta`,
 1 AS `pid`,
 1 AS `programa`,
 1 AS `uid`,
 1 AS `uex`,
 1 AS `aid`,
 1 AS `ano`,
 1 AS `tid`,
 1 AS `trimestre`,
 1 AS `cid`,
 1 AS `conta`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_fornecedorpj`
--

DROP TABLE IF EXISTS `vw_fornecedorpj`;
/*!50001 DROP VIEW IF EXISTS `vw_fornecedorpj`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_fornecedorpj` AS SELECT 
 1 AS `id`,
 1 AS `nome`,
 1 AS `nomeFantasia`,
 1 AS `doc_fornecedor`,
 1 AS `ccm`,
 1 AS `inscEstadual`,
 1 AS `identidade`,
 1 AS `orgemissor`,
 1 AS `emissao_rg`,
 1 AS `endereco`,
 1 AS `endNum`,
 1 AS `endCompl`,
 1 AS `cep`,
 1 AS `telFixo`,
 1 AS `telCel`,
 1 AS `cargo`,
 1 AS `email`,
 1 AS `site`,
 1 AS `id_bairro`,
 1 AS `bid`,
 1 AS `bairro`,
 1 AS `id_cidade`,
 1 AS `cid`,
 1 AS `cidade`,
 1 AS `id_uf`,
 1 AS `ufid`,
 1 AS `uf`,
 1 AS `id_pais`,
 1 AS `paid`,
 1 AS `pais`,
 1 AS `id_tipopessoa`,
 1 AS `tpid`,
 1 AS `tipopessoa`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_sradicoes`
--

DROP TABLE IF EXISTS `vw_sradicoes`;
/*!50001 DROP VIEW IF EXISTS `vw_sradicoes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_sradicoes` AS SELECT 
 1 AS `id`,
 1 AS `data_adicao`,
 1 AS `num_doc`,
 1 AS `historico_adicao`,
 1 AS `vlr_adicao`,
 1 AS `id_programa`,
 1 AS `id_uex`,
 1 AS `id_ano`,
 1 AS `id_trimestre`,
 1 AS `id_conta`,
 1 AS `pid`,
 1 AS `programa`,
 1 AS `uid`,
 1 AS `uex`,
 1 AS `aid`,
 1 AS `ano`,
 1 AS `tid`,
 1 AS `trimestre`,
 1 AS `cid`,
 1 AS `conta`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'gre'
--

--
-- Dumping routines for database 'gre'
--

--
-- Final view structure for view `vw_adicoes`
--

/*!50001 DROP VIEW IF EXISTS `vw_adicoes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_adicoes` AS select `ad`.`id` AS `id`,`ad`.`data_adicao` AS `data_adicao`,`ad`.`num_doc` AS `num_doc`,`ad`.`historico_adicao` AS `historico_adicao`,`ad`.`vlr_adicao` AS `vlr_adicao`,`ad`.`id_programa` AS `id_programa`,`ad`.`id_uex` AS `id_uex`,`ad`.`id_ano` AS `id_ano`,`ad`.`id_trimestre` AS `id_trimestre`,`ad`.`id_conta` AS `id_conta`,`p`.`id` AS `pid`,`p`.`programa` AS `programa`,`u`.`id` AS `uid`,`u`.`uEx` AS `uex`,`a`.`id` AS `aid`,`a`.`ano` AS `ano`,`t`.`id` AS `tid`,`t`.`trimestre` AS `trimestre`,`c`.`id` AS `cid`,`c`.`numConta` AS `conta` from (((((`tb_adicoes` `ad` join `tb_programa` `p` on((`p`.`id` = `ad`.`id_programa`))) join `tb_uex` `u` on((`u`.`id` = `ad`.`id_uex`))) join `tb_ano` `a` on((`a`.`id` = `ad`.`id_ano`))) join `tb_trimestre` `t` on((`t`.`id` = `ad`.`id_trimestre`))) join `tb_conta` `c` on((`c`.`id` = `ad`.`id_conta`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_bairrocidadeuf`
--

/*!50001 DROP VIEW IF EXISTS `vw_bairrocidadeuf`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_bairrocidadeuf` AS select `b`.`id` AS `idbairro`,`b`.`bairro` AS `bairro`,`b`.`id_cidade` AS `id_cidade`,`c`.`id` AS `cid`,`c`.`cidade` AS `cidadelabel`,`b`.`id_uf` AS `id_uf`,`u`.`id` AS `uid`,`u`.`uf` AS `uflabel` from ((`tb_bairro` `b` join `tb_uf` `u` on((`u`.`id` = `b`.`id_uf`))) join `tb_cidade` `c` on((`c`.`id` = `b`.`id_cidade`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_bemuexanotrimestre`
--

/*!50001 DROP VIEW IF EXISTS `vw_bemuexanotrimestre`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_bemuexanotrimestre` AS select `b`.`id` AS `id`,`b`.`descricao` AS `descricao`,`b`.`vlr_unit` AS `vlr_unit`,`b`.`qtd` AS `qtd`,`b`.`id_trimestre` AS `id_trimestre`,`b`.`id_ano` AS `id_ano`,`t`.`id` AS `cid`,`t`.`trimestre` AS `trimestre`,`b`.`id_uex` AS `id_uex`,`u`.`id` AS `uid`,`u`.`uEx` AS `uex`,`a`.`ano` AS `ano` from (((`tb_bem` `b` join `tb_uex` `u` on((`u`.`id` = `b`.`id_uex`))) join `tb_trimestre` `t` on((`t`.`id` = `b`.`id_trimestre`))) join `tb_ano` `a` on((`a`.`id` = `b`.`id_ano`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_cidadeuf`
--

/*!50001 DROP VIEW IF EXISTS `vw_cidadeuf`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_cidadeuf` AS select `p`.`id` AS `idcidade`,`p`.`cidade` AS `municipio`,`p`.`uf_id` AS `uf_id`,`u`.`id` AS `uid`,`u`.`uf` AS `uflabel` from (`tb_cidade` `p` join `tb_uf` `u` on((`u`.`id` = `p`.`uf_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_conciliacaodadosbancarios`
--

/*!50001 DROP VIEW IF EXISTS `vw_conciliacaodadosbancarios`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_conciliacaodadosbancarios` AS select `c`.`id` AS `id`,`c`.`numConta` AS `numConta`,`c`.`numAgencia` AS `numAgencia`,`c`.`id_uex` AS `id_uex`,`u`.`uEx` AS `uex`,`c`.`id_programa` AS `id_programa`,`p`.`programa` AS `programa`,`c`.`id_banco` AS `id_banco`,`b`.`numBanco` AS `numBanco` from (((`tb_conta` `c` join `tb_banco` `b` on((`b`.`id` = `c`.`id_banco`))) join `tb_uex` `u` on((`u`.`id` = `c`.`id_uex`))) join `tb_programa` `p` on((`p`.`id` = `c`.`id_programa`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_conciliacaosaldoscontabyuex`
--

/*!50001 DROP VIEW IF EXISTS `vw_conciliacaosaldoscontabyuex`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_conciliacaosaldoscontabyuex` AS select `s`.`id` AS `id`,`s`.`sdo_inicial` AS `sdo_inicial`,`s`.`vlr_repasse` AS `vlr_repasse`,`s`.`vlr_aplicacao` AS `vlr_aplicacao`,`s`.`vlr_rendAplicacao` AS `vlr_rendAplicacao`,`s`.`vlr_poupanca` AS `vlr_poupanca`,`s`.`sdo_investimentos` AS `sdo_investimentos`,`s`.`id_conta` AS `id_conta`,`ct`.`id` AS `ctid`,`ct`.`numConta` AS `numConta`,`ct`.`numAgencia` AS `numAgencia`,`ct`.`id_banco` AS `id_banco`,`b`.`id` AS `bid`,`b`.`numBanco` AS `numBanco`,`s`.`id_uex` AS `id_uex`,`u`.`id` AS `uid`,`u`.`uEx` AS `uex`,`s`.`id_programa` AS `id_programa`,`s`.`id_ano` AS `id_ano`,`a`.`id` AS `aid`,`a`.`ano` AS `ano`,`s`.`id_trimestre` AS `id_trimestre`,`t`.`id` AS `tid`,`t`.`trimestre` AS `trimestre` from ((((((`tb_saldos` `s` join `tb_uex` `u` on((`u`.`id` = `s`.`id_uex`))) join `tb_conta` `ct` on((`ct`.`id` = `s`.`id_conta`))) join `tb_programa` `p` on((`p`.`id` = `s`.`id_programa`))) join `tb_ano` `a` on((`a`.`id` = `s`.`id_ano`))) join `tb_trimestre` `t` on((`t`.`id` = `s`.`id_trimestre`))) join `tb_banco` `b` on((`b`.`id` = `ct`.`id_banco`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_contabancouex`
--

/*!50001 DROP VIEW IF EXISTS `vw_contabancouex`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_contabancouex` AS select `tbct`.`id` AS `idconta`,`tbct`.`numConta` AS `conta`,`tbct`.`numAgencia` AS `agencia`,`tbct`.`id_programa` AS `id_programa`,`tbb`.`id` AS `idbanco`,`tbb`.`banco` AS `banco`,`tbct`.`id_uex` AS `id_uex`,`u`.`id` AS `uid`,`u`.`uEx` AS `uexlabel` from ((`tb_conta` `tbct` join `tb_uex` `u` on((`u`.`id` = `tbct`.`id_uex`))) join `tb_banco` `tbb` on((`tbb`.`id` = `tbct`.`id_banco`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_cpagpessoa`
--

/*!50001 DROP VIEW IF EXISTS `vw_cpagpessoa`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_cpagpessoa` AS select `cpag`.`id` AS `idcpag`,`cpag`.`data_emissao` AS `data_emissao`,`cpag`.`nr_docto` AS `nr_docto`,`cpag`.`data_pg` AS `data_pg`,`cpag`.`historico` AS `historico`,`cpag`.`id_fornecedor` AS `id_fornecedor`,`cpag`.`cheque` AS `cheque`,`cpag`.`dt_cheque` AS `dt_cheque`,`cpag`.`valor` AS `valor`,`cpag`.`vlr_inss` AS `vlr_inss`,`cpag`.`vlr_piscofins` AS `vlr_piscofins`,`cpag`.`vlr_ir` AS `vlr_ir`,`cpag`.`vlr_iss` AS `vlr_iss`,`cpag`.`vlr_adeduzir` AS `vlr_adeduzir`,`cpag`.`vlr_liquido` AS `vlr_liquido`,`cpag`.`id_uex` AS `id_uex`,`cpag`.`id_trimestre` AS `id_trimestre`,`tr`.`id` AS `trid`,`tr`.`trimestre` AS `trimestre`,`cpag`.`id_ano` AS `id_ano`,`a`.`id` AS `aid`,`a`.`ano` AS `ano`,`u`.`id` AS `uid`,`u`.`uEx` AS `uex`,`pr`.`id` AS `prid`,`pr`.`programa` AS `programa`,`p`.`id` AS `pid`,`p`.`nome` AS `nomelabel`,`p`.`doc_fornecedor` AS `doc_fornecedor`,`cpag`.`id_conta` AS `id_conta`,`ct`.`id` AS `ctid`,`ct`.`numConta` AS `conta` from ((((((`tb_cpag` `cpag` join `tb_pessoa` `p` on((`p`.`id` = `cpag`.`id_fornecedor`))) join `tb_uex` `u` on((`u`.`id` = `cpag`.`id_uex`))) join `tb_trimestre` `tr` on((`tr`.`id` = `cpag`.`id_trimestre`))) join `tb_ano` `a` on((`a`.`id` = `cpag`.`id_ano`))) join `tb_programa` `pr` on((`pr`.`id` = `cpag`.`id_programa`))) join `tb_conta` `ct` on((`ct`.`id` = `cpag`.`id_conta`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_crecprogramauexanotrimestre`
--

/*!50001 DROP VIEW IF EXISTS `vw_crecprogramauexanotrimestre`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_crecprogramauexanotrimestre` AS select `crec`.`id` AS `id`,`crec`.`data_entrada` AS `data_entrada`,`crec`.`num_doc` AS `num_doc`,`crec`.`historico` AS `historico`,`crec`.`vlr_receita` AS `vlr_receita`,`crec`.`id_uex` AS `id_uex`,`crec`.`id_trimestre` AS `id_trimestre`,`crec`.`id_programa` AS `id_programa`,`tr`.`id` AS `trid`,`tr`.`trimestre` AS `trimestre`,`crec`.`id_ano` AS `id_ano`,`a`.`id` AS `aid`,`a`.`ano` AS `ano`,`u`.`id` AS `uid`,`u`.`uEx` AS `uex`,`pr`.`id` AS `prid`,`pr`.`programa` AS `programa` from ((((`tb_crec` `crec` join `tb_uex` `u` on((`u`.`id` = `crec`.`id_uex`))) join `tb_trimestre` `tr` on((`tr`.`id` = `crec`.`id_trimestre`))) join `tb_ano` `a` on((`a`.`id` = `crec`.`id_ano`))) join `tb_programa` `pr` on((`pr`.`id` = `crec`.`id_programa`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_deducoes`
--

/*!50001 DROP VIEW IF EXISTS `vw_deducoes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_deducoes` AS select `d`.`id` AS `id`,`d`.`data_deducao` AS `data_deducao`,`d`.`num_doc` AS `num_doc`,`d`.`historico_deducao` AS `historico_deducao`,`d`.`vlr_deducao` AS `vlr_deducao`,`d`.`id_programa` AS `id_programa`,`d`.`id_uex` AS `id_uex`,`d`.`id_ano` AS `id_ano`,`d`.`id_trimestre` AS `id_trimestre`,`d`.`id_conta` AS `id_conta`,`p`.`id` AS `pid`,`p`.`programa` AS `programa`,`u`.`id` AS `uid`,`u`.`uEx` AS `uex`,`a`.`id` AS `aid`,`a`.`ano` AS `ano`,`t`.`id` AS `tid`,`t`.`trimestre` AS `trimestre`,`c`.`id` AS `cid`,`c`.`numConta` AS `conta` from (((((`tb_deduc` `d` join `tb_programa` `p` on((`p`.`id` = `d`.`id_programa`))) join `tb_uex` `u` on((`u`.`id` = `d`.`id_uex`))) join `tb_ano` `a` on((`a`.`id` = `d`.`id_ano`))) join `tb_trimestre` `t` on((`t`.`id` = `d`.`id_trimestre`))) join `tb_conta` `c` on((`c`.`id` = `d`.`id_conta`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_fornecedorpj`
--

/*!50001 DROP VIEW IF EXISTS `vw_fornecedorpj`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_fornecedorpj` AS select `p`.`id` AS `id`,`p`.`nome` AS `nome`,`p`.`nomeFantasia` AS `nomeFantasia`,`p`.`doc_fornecedor` AS `doc_fornecedor`,`p`.`ccm` AS `ccm`,`p`.`inscEstadual` AS `inscEstadual`,`p`.`identidade` AS `identidade`,`p`.`orgemissor` AS `orgemissor`,`p`.`emissao_rg` AS `emissao_rg`,`p`.`endereco` AS `endereco`,`p`.`endNum` AS `endNum`,`p`.`endCompl` AS `endCompl`,`p`.`cep` AS `cep`,`p`.`telFixo` AS `telFixo`,`p`.`telCel` AS `telCel`,`p`.`cargo` AS `cargo`,`p`.`email` AS `email`,`p`.`site` AS `site`,`p`.`id_bairro` AS `id_bairro`,`b`.`id` AS `bid`,`b`.`bairro` AS `bairro`,`p`.`id_cidade` AS `id_cidade`,`c`.`id` AS `cid`,`c`.`cidade` AS `cidade`,`p`.`id_uf` AS `id_uf`,`uf`.`id` AS `ufid`,`uf`.`uf` AS `uf`,`p`.`id_pais` AS `id_pais`,`pa`.`id` AS `paid`,`pa`.`pais` AS `pais`,`p`.`id_tipopessoa` AS `id_tipopessoa`,`tp`.`id` AS `tpid`,`tp`.`tipoPessoa` AS `tipopessoa` from (((((`tb_pessoa` `p` join `tb_bairro` `b` on((`b`.`id` = `p`.`id_bairro`))) join `tb_cidade` `c` on((`c`.`id` = `p`.`id_cidade`))) join `tb_uf` `uf` on((`uf`.`id` = `p`.`id_uf`))) join `tb_pais` `pa` on((`pa`.`id` = `p`.`id_pais`))) join `tb_tipopessoa` `tp` on((`tp`.`id` = `p`.`id_tipopessoa`))) where (`p`.`id_tipopessoa` = 2) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_sradicoes`
--

/*!50001 DROP VIEW IF EXISTS `vw_sradicoes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_sradicoes` AS select `ad`.`id` AS `id`,`ad`.`data_adicao` AS `data_adicao`,`ad`.`num_doc` AS `num_doc`,`ad`.`historico_adicao` AS `historico_adicao`,`ad`.`vlr_adicao` AS `vlr_adicao`,`ad`.`id_programa` AS `id_programa`,`ad`.`id_uex` AS `id_uex`,`ad`.`id_ano` AS `id_ano`,`ad`.`id_trimestre` AS `id_trimestre`,`ad`.`id_conta` AS `id_conta`,`p`.`id` AS `pid`,`p`.`programa` AS `programa`,`u`.`id` AS `uid`,`u`.`uEx` AS `uex`,`a`.`id` AS `aid`,`a`.`ano` AS `ano`,`t`.`id` AS `tid`,`t`.`trimestre` AS `trimestre`,`c`.`id` AS `cid`,`c`.`numConta` AS `conta` from (((((`tb_sradicoes` `ad` join `tb_programa` `p` on((`p`.`id` = `ad`.`id_programa`))) join `tb_uex` `u` on((`u`.`id` = `ad`.`id_uex`))) join `tb_ano` `a` on((`a`.`id` = `ad`.`id_ano`))) join `tb_trimestre` `t` on((`t`.`id` = `ad`.`id_trimestre`))) join `tb_conta` `c` on((`c`.`id` = `ad`.`id_conta`))) */;
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

-- Dump completed on 2018-03-08 16:29:28
