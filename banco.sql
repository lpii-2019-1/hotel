CREATE DATABASE crudJava;
USE crudJava;

CREATE TABLE hospede (
	idHospede INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
    cpf BIGINT NOT NULL, 
    telefone VARCHAR(15) NOT NULL,
	endereco VARCHAR(200) NOT NULL,
	email VARCHAR(100) NOT NULL,
    dataCadastro VARCHAR(15) NOT NULL,   
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
    dataAdmissao VARCHAR(15) NOT NULL,
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
    inicioOcupacao VARCHAR(15) NOT NULL,
	horaEntrada TIME NOT NULL,
    fimOcupacao VARCHAR(15),
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


INSERT INTO hospede (nome,cpf,telefone,endereco,email,dataCadastro) VALUES 
('Alexandre',12345678901,'996369636','Rua tal n 1','algumacoisa@gmail.com','23/12/2000'),
('Hospede',98745612311,'915155151','Rua qual n 1','outracoisa@gmail.com','15/12/2015'),
('Hospede',97878454545,'915155151','Rua qual n 1','outracoisa@gmail.com','23/12/2015'),
('Teste', 00000,'987654321','Rua 20 n 1','teste@gmail.com','23/12/2015'),
('Exemplo', 11111,'123456789','Rua 40 n 2','exemplo@gmail.com','23/12/2015');



INSERT INTO funcionario (nome,cpf,telefone,endereco,email,cargo,salario,dataAdmissao) VALUES 
('pedrim',12345678901,'996369636','Rua tal n 1','algumacoisa@gmail.com','limpeza',500.50,'23/12/2010'),
('pedrim',98745612311,'915155151','Rua qual n 1','outracoisa@gmail.com','limpeza',500.50,'25/11/2011'),
('tiao',97878454545,'915155123','Rua qual n 1','outracoisa@gmail.com','manutencao',700.50,'15/12/2009'),
('Funcionario',22222,'147852369','Rua 50 n 10','funcionario@gmail.com','recepcionista',700.50,'25/11/2011'),
('TesteF',33333,'369852147','Rua WW n 100','testef@gmail.com','chefe-limpeza',700.50,'25/11/2011');


INSERT INTO quarto (numeroQuarto,descricao,valor,OcupacaoQuarto) VALUES 
(1, '1 cama de solteiro', 25.00, 0),
(2, '1 cama de solteiro e 1 cama de casal', 75.00, 0),
(3, '1 cama de casal e 1 cama de solteiro', 75.00, 0),
(4, '1 cama de casal', 50.00, 0),
(5, '2 camas de solteiro', 50.00, 0),
(6, '2 camas de casal', 100.00, 0);

INSERT INTO reserva (idQuarto,inicioOcupacao,horaEntrada,fimOcupacao,horaSaida,idHospede,idFuncionario,valorTotal,valorPago) VALUES 
(1, '12/05/2019', '22:00', '13/05/2019', '09:00', 1, 2, 25.00, 25.00),
(2, '12/05/2019', '23:00', '13/06/2019', '13:00', 2, 2, 150.00, 150.00),
(1, '01/06/2019', '21:00', '02/06/2019', '06:00', 3, 1, 25.00, 25.00),
(3, '05/06/2019', '05:00', '05/06/2019', '16:00', 4, 3, 75.00, 75.00),
(3, '05/06/2019', '22:00', '06/062019', '08:00', 5, 4, 75.00, 75.00),
(4, '11/06/2019', '23:30', '12/06/2019', '06:00', 1, 5, 50.00, 50.00);