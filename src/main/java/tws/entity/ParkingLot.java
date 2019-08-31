package tws.entity;

public class ParkingLot {

    private int parkingLotId;

    private int availablePositionCount;

    private int capatity;

    private int parkingBoyId;

    public ParkingLot() {

    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getAvailablePositionCount() {
        return availablePositionCount;
    }

    public void setAvailablePositionCount(int availablePositionCount) {
        this.availablePositionCount = availablePositionCount;
    }

    public int getCapatity() {
        return capatity;
    }

    public void setCapatity(int capatity) {
        this.capatity = capatity;
    }

    public int getParkingBoyId() {
        return parkingBoyId;
    }

    public void setParkingBoyId(int parkingBoyId) {
        this.parkingBoyId = parkingBoyId;
    }


}