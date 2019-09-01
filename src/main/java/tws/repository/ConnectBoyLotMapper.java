package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import tws.entity.Connect;

public class ConnectBoyLotMapper {
	@Select("select employee.id,parkingLot.id from employee,parkingLot where parkingLot.parkingBoyId=employee.id")
	List<Connect> selectALL();
	
}
