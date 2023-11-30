drop table Producto

-- **PRODUCTOS**
CREATE TABLE Producto (
    Id NVARCHAR(255) PRIMARY KEY NOT NULL,
    Name NVARCHAR(50) NOT NULL,
    Brand NVARCHAR(50) NOT NULL,
    Description NVARCHAR(MAX) NOT NULL, 
    Price FLOAT(53) NOT NULL,
	Date_Expiration Date  NOT NULL
);


INSERT INTO Producto (Id, Name, Brand, Description, Price, Date_Expiration)
VALUES
  ('001', 'Coca-cola', 'Cocacola company', 'Cocacola de 450 ml', 0.50,'2024-12-31'),
  ('002', 'Rufles', 'Frito Lay', 'Rufles de 45 gr sabor cebolla', 0.39,'2024-12-31'),
  ('003', 'Doritos', 'Frito Lay', 'Doritos grandes', 2.99,'2024-12-31');

INSERT INTO Producto (Id, Name, Brand, Description, Price, Date_Expiration)
VALUES('Asdf112a', 'papitas', 'Na', 'papitas pre fritas', 3.0,'2026-12-31');


select * from producto

SELECT Id, Name, Brand, Description, Price, Date_Expiration, CONVERT(VARCHAR, Date_Expiration, 103) AS ExpirationDateFormatted
FROM producto;

-- **USUARIOS**
drop table Users
CREATE TABLE Users (
	Id INT PRIMARY KEY IDENTITY(1,1),
    Username NVARCHAR(50) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
	Role NVARCHAR(16) NOT NULL,
);

