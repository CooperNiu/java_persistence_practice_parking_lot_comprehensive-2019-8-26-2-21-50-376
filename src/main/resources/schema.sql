CREATE TABLE employee (
  employeeID varchar PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  age   int(4) NOT NULL,
  parkingLotID varchar (100)
);
CREATE TABLE parkinglot (
  parkingLotID INTEGER PRIMARY KEY,
  capacity INTEGER NOT NULL,
  employeeID INTEGER NOT NULL,
  FOREIGN KEY (employeeID) REFERENCES employee ( employeeID )
);
