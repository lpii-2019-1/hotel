CREATE DATABASE crudJava;
USE crudJava;

CREATE TABLE hospede (
	idHospede INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
    cpf BIGINT NOT NULL, 
    telefone VARCHAR(15) NOT NULL,
	endereco VARCHAR(200) NOT NULL,
	email VARCHAR(100) NOT NULL,
    dataCadastro DATE NOT NULL,   
    PRIMARY KEY(idHospede)
);

CREATE TABLE funcionario (
	idFuncionario INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
    cpf BIGINT NOT NULL, 
    telefone VARCHAR(15) NOT NULL,
	endereco VARCHAR(200) NOT NULL,
	email VARCHAR(100) NOT NULL,
    cargo VARCHAR(80) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,   
    dataAdmissao DATE NOT NULL,
    PRIMARY KEY(idFuncionario)
);

CREATE TABLE quarto (
	idQuarto INT NOT NULL AUTO_INCREMENT,
	numeroQuarto INT NOT NULL,
    descricao VARCHAR(200) NOT NULL, 
    valor DECIMAL(10,2) NOT NULL,
    OcupacaoQuarto BOOLEAN NOT NULL,
    PRIMARY KEY(idQuarto)
);

CREATE TABLE reserva (
	idReserva INT NOT NULL AUTO_INCREMENT,
	idQuarto INT NOT NULL,
    inicioOcupacao DATE NOT NULL,
	horaEntrada TIME NOT NULL,
    fimOcupacao DATE,
    horaSaida TIME,
    idHospede INT NOT NULL,
	idFuncionario INT NOT NULL,
    valorTotal DECIMAL(10,2),
    valorPago DECIMAL(10,2),
    PRIMARY KEY(idReserva),
	FOREIGN KEY(idQuarto) REFERENCES quarto (idQuarto),
    FOREIGN KEY(idHospede) REFERENCES hospede (idHospede),
	FOREIGN KEY(idFuncionario) REFERENCES funcionario (idFuncionario)
);
