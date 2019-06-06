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

CREATE TABLE ocupacaoQuarto (
	idOcupacaoQuarto INT NOT NULL AUTO_INCREMENT,
	disponibilidade VARCHAR(20) NOT NULL,
    PRIMARY KEY(idOcupacaoQuarto)
);

CREATE TABLE quarto (
	numeroQuarto INT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(200) NOT NULL, 
    valor DECIMAL(10,2) NOT NULL,
    idOcupacaoQuarto INT,
    PRIMARY KEY(numeroQuarto),
    FOREIGN KEY(idOcupacaoQuarto) REFERENCES ocupacaoQuarto (idOcupacaoQuarto)
);

CREATE TABLE reserva (
	idReserva INT NOT NULL AUTO_INCREMENT,
    inicioOcupacao DATE NOT NULL,
	fimOcupacao DATE,
    idHospede INT NOT NULL,
	idFuncionario INT NOT NULL,
    PRIMARY KEY(idReserva),
    FOREIGN KEY(idHospede) REFERENCES hospede (idHospede),
	FOREIGN KEY(idFuncionario) REFERENCES funcionario (idFuncionario)
);

CREATE TABLE reservaQuarto (
	idReservaQuarto INT NOT NULL AUTO_INCREMENT,
    numeroQuarto INT NOT NULL,
	idReserva INT NOT NULL,
    PRIMARY KEY(idReservaQuarto),
    FOREIGN KEY(numeroQuarto) REFERENCES quarto (numeroQuarto),
	FOREIGN KEY(idReserva) REFERENCES reserva (idReserva)
);

CREATE TABLE pagamento (
	idPagamento INT NOT NULL AUTO_INCREMENT,
    valorTotal DECIMAL(10,2),
    valorPago DECIMAL(10,2),
	idReservaQuarto INT NOT NULL,
    PRIMARY KEY(idPagamento),
	FOREIGN KEY(idReservaQuarto) REFERENCES reservaQuarto (idReservaQuarto)
);


INSERT INTO ocupacaoquarto (idOcupacaoQuarto, disponibilidade) VALUES  (NULL, 'DISPONIVEL'), (NULL, 'OCUPADO');