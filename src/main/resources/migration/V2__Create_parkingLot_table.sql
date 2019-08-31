CREATE TABLE parkinglot (
  parkingLotID INTEGER PRIMARY KEY,
  capacity INTEGER NOT NULL,
  employeeId INTEGER NOT NULL,
  FOREIGN KEY (employeeId) REFERENCES employee ( id )
);