package tws.entity;

import java.io.Serializable;

//Story 2
//作为经理，我想创建并列出所有停车场，以便停车男孩可以将车停在他们身上。
//AC1：我应该能够在系统中创建一个停车场。停车场包含以下信息： parkingLotID：停车场ID是一个非空字符串，表示停车场的唯一ID。 容量：停车场的容量。它是1到100的整数。
//AC2：我应该能够在系统中列出所有停车场。每个停车场应包含其parkingLotID，availablePositionCount和每个停车场的容量。
public class ParkingLot implements Serializable{

	 private int parkingLotID;
	    private String name;
	    private String age;

	    public ParkingLot()  {

	    }

	    public ParkingLot(int parkingLotID, String name, String age) {
	        this.parkingLotID = parkingLotID;
	        this.name = name;
	        this.age = age;
	    }

	    public int getId() {
	        return parkingLotID;
	    }

	    public void setId(int id) {
	        this.parkingLotID = id;
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
	}