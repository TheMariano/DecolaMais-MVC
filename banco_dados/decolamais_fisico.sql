CREATE DATABASE decolamais;

use decolamais;

CREATE TABLE Usuarios (
id_usuario INTEGER PRIMARY KEY,
nome_usuario VARCHAR(40),
email_usuario VARCHAR(80),
telefone_usuario NUMERIC(10),
senha_usuario VARCHAR(40),
endereco_usuario VARCHAR(80)
)

CREATE TABLE Compra (
id_compra INTEGER PRIMARY KEY,
data_compra DATETIME,
valor_compra NUMERIC(20),
id_usuario INTEGER,
FOREIGN KEY(id_usuario) REFERENCES Usuarios (id_usuario)
)

CREATE TABLE Destinos (
id_destino INTEGER PRIMARY KEY,
cidade_destino VARCHAR(40),
hotel_destino VARCHAR(40),
dias_hotel_destino NUMERIC(10)
)

CREATE TABLE Viagens (
id_destino INTEGER,
id_compra INTEGER,
FOREIGN KEY(id_destino) REFERENCES Destinos (id_destino),
FOREIGN KEY(id_compra) REFERENCES Compra (id_compra)
)

select * from Usuarios;
select * from Compra;
select * from Destinos;
select * from Viagens;