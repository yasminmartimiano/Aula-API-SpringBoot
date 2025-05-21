-- Banco de Estudo

CREATE DATABASE estudo_pessoas
    DEFAULT CHARACTER SET = 'utf8mb4';
--
-- Table structure for table `table_name`
--
Use estudo_pessoas

DROP DATABASE estudo_pessoas;

CREATE TABLE `Pessoas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT 'Create Time',
  `name` varchar(255) NOT NULL,
  `telefone` varchar(15) DEFAULT NULL COMMENT 'Telefone no formato XXXXXXXXXXX',
  `endereco` varchar(150) DEFAULT NULL COMMENT 'Endereço Completo',
  `imagem_perfil` varchar(2083) DEFAULT NULL COMMENT 'URL da Imagem de Perfil',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Cadastro de Pessoas';

-- Inserção de dados de exemplo
INSERT INTO pessoas (name, telefone, endereco, imagem_perfil) VALUES
('João Silva', '(31) 91234-5678', 'Rua das Flores, 123', 'https://imagem.com/perfil.png'),
('Maria Oliveira', '(31) 99887-1234', 'Avenida Central, 456', 'https://imagem.com/perfil2.png');

/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-14  8:56:50

/*Criação da tabela de produtos*/
CREATE TABLE Produtos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    quantidadeEstoque INT NOT NULL,
    descricao TEXT
);

/*criando a tabela de compras*/
CREATE TABLE Compras (
  id INT PRIMARY KEY AUTO_INCREMENT,
  dataCompra DATETIME NOT NULL,
  pessoa_id BIGINT NOT NULL,
  FOREIGN KEY (pessoa_id) REFERENCES Pessoas(id)
);


/*criando a tabela itens de compra*/
CREATE TABLE ItensCompra (
  id INT PRIMARY KEY AUTO_INCREMENT,
  compra_id INT NOT NULL,
  produto_id INT NOT NULL,
  quantidade INT NOT NULL,
  precoUnitario DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (compra_id) REFERENCES Compras(id),
  FOREIGN KEY (produto_id) REFERENCES Produtos(id)
);

DROP TABLE IF EXISTS ItensCompra;
CREATE TABLE ItensCompra (
  id INT PRIMARY KEY AUTO_INCREMENT,
  compra_id INT NOT NULL,
  produto_id INT NOT NULL,
  quantidade INT NOT NULL,
  precoUnitario DECIMAL(10,2) NOT NULL,
  FOREIGN KEY (compra_id) REFERENCES Compras(id),
  FOREIGN KEY (produto_id) REFERENCES Produtos(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE ItensCompra DROP FOREIGN KEY itenscompra_ibfk_2;
