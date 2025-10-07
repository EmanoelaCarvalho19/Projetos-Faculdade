CREATE DATABASE bdamanu;

-- Selecionando o banco de dados para uso
USE bdamanu;

-- Tabela de endereçamento
-- O ID foi alterado de INT para BIGINT para suportar um número maior de endereços.
CREATE TABLE enderecamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cep CHAR(8) NOT NULL UNIQUE,
    estado CHAR(2) NOT NULL,
    municipio VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    logradouro VARCHAR(255) NOT NULL
);

-- Tabela de pessoa física
-- O ID foi alterado de INT para BIGINT.
CREATE TABLE pessoa_fisica (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cep CHAR(8) NOT NULL,
    numero_endereco VARCHAR(10),
    complemento VARCHAR(100),
    telefone VARCHAR(20),
    cliente_desde DATE NOT NULL,
    situacao ENUM('Ativo', 'Inativo') DEFAULT 'Ativo',
    cpf CHAR(11) NOT NULL UNIQUE,
    nome_registro VARCHAR(100) NOT NULL,
    nome_social VARCHAR(100),
    data_nascimento DATE NOT NULL,
    sexo ENUM('Masculino_Cis', 'Feminino_Cis', 'Masculino_Trans', 'Feminino_Trans', 'Neutro'),
    renda_mensal DECIMAL(10,2),
    FOREIGN KEY (cep) REFERENCES enderecamento(cep)
);

-- Tabela de pessoa jurídica
-- O ID foi alterado de INT para BIGINT.
CREATE TABLE pessoa_juridica (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cep CHAR(8) NOT NULL,
    numero_endereco VARCHAR(10),
    complemento VARCHAR(100),
    telefone VARCHAR(20),
    cliente_desde DATE NOT NULL,
    situacao ENUM('Ativo', 'Inativo') DEFAULT 'Ativo',
    cnpj CHAR(14) NOT NULL UNIQUE,
    razao_social VARCHAR(150) NOT NULL,
    nome_fantasia VARCHAR(150),
    data_abertura DATE,
    quadro_societario TEXT,
    capital_social DECIMAL(15,2),
    FOREIGN KEY (cep) REFERENCES enderecamento(cep)
);

-- Tabela de banco
-- O ID foi alterado de INT para BIGINT.
CREATE TABLE banco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigo_febraban CHAR(3) NOT NULL UNIQUE,
    nome VARCHAR(100) NOT NULL,
    mascara_conta VARCHAR(20)
);

-- Tabela de agência
-- O ID e a chave estrangeira banco_id foram alterados para BIGINT para manter a consistência.
CREATE TABLE agencia (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    -- Chaves Estrangeiras que ligam a agência a outras tabelas
    banco_id BIGINT NOT NULL,          -- Agência pertence a um Banco
    id_enderecamento BIGINT NOT NULL,  -- Agência possui um Endereçamento

    -- Colunas que são EXCLUSIVAS da agência
    nome VARCHAR(100) NOT NULL,        -- Nome da agência (ex: "Agência Centro")
    telefone VARCHAR(20),
    situacao ENUM('Ativo', 'Inativo') NOT NULL DEFAULT 'Ativo',

    -- Definição dos relacionamentos
    -- ON DELETE RESTRICT: Impede que um banco ou endereço seja deletado se uma agência estiver ligada a ele.
    FOREIGN KEY (banco_id) REFERENCES banco(id) ON DELETE RESTRICT,
    FOREIGN KEY (id_enderecamento) REFERENCES enderecamento(id) ON DELETE RESTRICT
);

-- Tabela de conta bancária
-- Todas as colunas de ID (primário e estrangeiras) foram alteradas para BIGINT.
CREATE TABLE conta_bancaria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    agencia_id BIGINT NOT NULL,
    titular_1 BIGINT NOT NULL,
    titular_2 BIGINT,
    data_abertura DATE NOT NULL,
    saldo DECIMAL(12,2) DEFAULT 0.00,
    senha VARCHAR(100) NOT NULL,
    bandeira_cartao VARCHAR(20),
    numero_cartao CHAR(16),
    validade_cartao DATE,
    cvv CHAR(3),
    situacao ENUM('Ativa', 'Bloqueada', 'Encerrada') DEFAULT 'Ativa',
    FOREIGN KEY (agencia_id) REFERENCES agencia(id)
);

-- Tabela de conta poupança
-- A chave primária/estrangeira conta_id foi alterada para BIGINT.
CREATE TABLE conta_poupanca (
    conta_id BIGINT PRIMARY KEY,
    indice_reajuste DECIMAL(5,2) NOT NULL,
    FOREIGN KEY (conta_id) REFERENCES conta_bancaria(id)
);

-- Tabela de conta salário
-- Todas as colunas de ID (primário e estrangeiras) foram alteradas para BIGINT.
CREATE TABLE conta_salario (
    conta_id BIGINT PRIMARY KEY,
    cnpj_empresa CHAR(14) NOT NULL,
    limite_adiantamento DECIMAL(10,2),
    conta_portabilidade BIGINT,
    FOREIGN KEY (conta_id) REFERENCES conta_bancaria(id),
    FOREIGN KEY (cnpj_empresa) REFERENCES pessoa_juridica(cnpj),
    FOREIGN KEY (conta_portabilidade) REFERENCES conta_bancaria(id)
);

-- Tabela de conta especial
-- A chave primária/estrangeira conta_id foi alterada para BIGINT.
CREATE TABLE conta_especial (
    conta_id BIGINT PRIMARY KEY,
    limite_credito DECIMAL(10,2),
    vencimento_limite DATE,
    FOREIGN KEY (conta_id) REFERENCES conta_bancaria(id)
);

-- Tabela de pessoa (geral)
-- O ID e a chave estrangeira id_enderecamento foram alterados para BIGINT.
CREATE TABLE pessoa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_enderecamento BIGINT NOT NULL,
    numero_endereco VARCHAR(10) NOT NULL,
    complemento_endereco VARCHAR(100),
    telefone VARCHAR(20),
    cliente_desde DATE NOT NULL,
    situacao ENUM('Ativo', 'Inativo') NOT NULL DEFAULT 'Ativo',
    FOREIGN KEY (id_enderecamento) REFERENCES enderecamento(id) ON DELETE RESTRICT
);