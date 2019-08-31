package tws.entity;

public class ParkingLot {
    private String parkingLotID;
    private int capacity;
    private int employeeID;

    public ParkingLot() {
    }

    public ParkingLot(String parkingLotID, int capacity,int employeeID) {
        this.parkingLotID = parkingLotID;
        this.capacity = capacity;
        this.employeeID = employeeID;
    }

    public String getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(String parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
