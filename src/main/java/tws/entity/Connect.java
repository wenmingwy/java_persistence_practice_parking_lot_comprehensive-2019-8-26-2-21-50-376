package tws.entity;

public class Connect {
	private int id;
	private int parkingBoyId;
	
	
	public Connect() {
	}
	public Connect(int parkingBoyId, int id) {
		super();
		this.id = id;
		this.parkingBoyId = parkingBoyId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParkingBoyId() {
		return parkingBoyId;
	}
	public void setParkingBoyId(int parkingBoyId) {
		this.parkingBoyId = parkingBoyId;
	}
}
