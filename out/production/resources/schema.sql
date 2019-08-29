CREATE TABLE employee (
  id INTEGER PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  age   int(4) NOT NULL
);
CREATE TABLE parkinglot (
  parkingLotID INTEGER PRIMARY KEY,
  capacity INTEGER NOT NULL,
  employeeId INTEGER NOT NULL,
  FOREIGN KEY (employeeId) REFERENCES employee ( id )
);
