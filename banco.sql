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
    inicioOcupacao DATE NOT NULL,
	fimOcupacao DATE,
    idHospede INT NOT NULL,
	idFuncionario INT NOT NULL,
    valorTotal DECIMAL(10,2),
    valorPago DECIMAL(10,2),
    PRIMARY KEY(idReserva),
    FOREIGN KEY(idHospede) REFERENCES hospede (idHospede),
	FOREIGN KEY(idFuncionario) REFERENCES funcionario (idFuncionario)
);

CREATE TABLE reservaQuarto (
	idReservaQuarto INT NOT NULL AUTO_INCREMENT,
    idQuarto INT NOT NULL,
	idReserva INT NOT NULL,
    PRIMARY KEY(idReservaQuarto),
    FOREIGN KEY(idQuarto) REFERENCES quarto (idQuarto),
	FOREIGN KEY(idReserva) REFERENCES reserva (idReserva)
);

INSERT INTO hospede (nome,cpf,telefone,endereco,email,dataCadastro) VALUES ('Alexandre',12345678901,'996369636','Rua tal n 1','algumacoisa@gmail.com','2000-12-23'),
																		   ('Hospede',98745612311,'915155151','Rua qual n 1','outracoisa@gmail.com','2015-12-15'),
                                                                           ('Hospede',97878454545,'915155151','Rua qual n 1','outracoisa@gmail.com','2015-12-23');

INSERT INTO funcionario (nome,cpf,telefone,endereco,email,cargo,salario,dataAdmissao) VALUES ('pedrim',12345678901,'996369636','Rua tal n 1','algumacoisa@gmail.com','limpeza',500.50,'2010-12-23'),
																							 ('pedrim',98745612311,'915155151','Rua qual n 1','outracoisa@gmail.com','limpeza',500.50,'2011-12-25'),
																							 ('tiao',97878454545,'915155151','Rua qual n 1','outracoisa@gmail.com','manutencao',700.50,'2009-12-15');
