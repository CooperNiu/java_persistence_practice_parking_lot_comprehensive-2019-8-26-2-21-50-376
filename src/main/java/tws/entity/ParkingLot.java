package tws.entity;

public class ParkingLot {
	
	private String parkingLotId;
	
	private int availablePositionCount;
	
	private int capatity;
	
	private String parkingBoyId;
	
	public ParkingLot(String parkingLotId,int availablePositionCount,int capatity) {
		this.parkingLotId = parkingLotId;
		this.availablePositionCount = availablePositionCount;
		this.capatity = capatity;
	}
	
	public ParkingLot() {
		
	}

	public String getParkingLotId() {
		return parkingLotId;
	}

	public void setParkingLotId(String parkingLotId) {
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

	public String getParkingBoyId() {
		return parkingBoyId;
	}

	public void setParkingBoyId(String parkingBoyId) {
		this.parkingBoyId = parkingBoyId;
	}
	

}
