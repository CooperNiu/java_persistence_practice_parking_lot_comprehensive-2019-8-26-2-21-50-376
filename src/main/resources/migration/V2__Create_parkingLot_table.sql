CREATE TABLE parkinglot (
  parkingLotID INTEGER PRIMARY KEY,
  capacity INTEGER NOT NULL,
  employeeID INTEGER NOT NULL,
  FOREIGN KEY (employeeID) REFERENCES parkingBoy ( employeeID )
);