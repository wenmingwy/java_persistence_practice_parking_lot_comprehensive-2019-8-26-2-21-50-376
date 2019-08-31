package tws.entity;

import java.io.Serializable;

//Story 2
//作为经理，我想创建并列出所有停车场，以便停车男孩可以将车停在他们身上。
//AC1：我应该能够在系统中创建一个停车场。停车场包含以下信息： parkingLotID：停车场ID是一个非空字符串，表示停车场的唯一ID。 容量：停车场的容量。它是1到100的整数。
//AC2：我应该能够在系统中列出所有停车场。每个停车场应包含其parkingLotID，availablePositionCount和每个停车场的容量。
public class ParkingLot implements Serializable{

		private int parkingLotID;
	    private int availablePositionCount;
	    private int capacity ;
	    private int parkingBoyId;

	    public ParkingLot()  {

	    }

	    public ParkingLot(int parkingLotID, int availablePositionCount,int capacity,int parkingBoyId) {
	        this.parkingLotID = parkingLotID;
	        this.parkingBoyId = parkingBoyId;
	        this.availablePositionCount = availablePositionCount ;
	        this.capacity = capacity;
	    }

		public int getParkingLotID() {
			return parkingLotID;
		}

		public void setParkingLotID(int parkingLotID) {
			this.parkingLotID = parkingLotID;
		}


		public int getAvailablePositionCount() {
			return availablePositionCount;
		}

		public void setAvailablePositionCount(int availablePositionCount) {
			this.availablePositionCount = availablePositionCount;
		}

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public int getParkingBoyId() {
			return parkingBoyId;
		}

		public void setParkingBoyId(int parkingBoyId) {
			this.parkingBoyId = parkingBoyId;
		}

	   
	}