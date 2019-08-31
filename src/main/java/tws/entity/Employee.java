package tws.entity;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
    private int employeeID;
    private String name;
    private String age;
    private List<ParkingLot> lotList;
    private String parkingLotID;
    public Employee() {

    }

    public Employee(int employeeID, String name, String age, String parkingLotID) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.parkingLotID = parkingLotID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<ParkingLot> getLotList() {
        return lotList;
    }

    public void setLotList(List<ParkingLot> lotList) {
        this.lotList = lotList;
    }

    public String getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(String parkingLotID) {
        this.parkingLotID = parkingLotID;
    }
}
