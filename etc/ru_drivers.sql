CREATE TABLE ru_drivers
(
  id int Identity (1, 1) primary key NOT NULL,
  driverName nvarchar(100) unique,
  productID int NOT NULL FOREIGN KEY REFERENCES ru_product(id),
  prizeID int NOT NULL FOREIGN KEY REFERENCES ru_prize(id)
)
