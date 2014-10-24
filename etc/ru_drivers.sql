CREATE TABLE ru_drivers
(
  id int Identity (1, 1) primary key NOT NULL,
  userID int unique NOT NULL,
  productID int NOT NULL,
  prizeID int NOT NULL
)
