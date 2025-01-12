package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.entity.Employee;
import tws.entity.ParkingLot;

//作为经理，我想创建并列出所有停车场，以便停车男孩可以将车停在他们身上。
//AC1：我应该能够在系统中创建一个停车场。停车场包含以下信息： parkingLotID：停车场ID是一个非空字符串，表示停车场的唯一ID。 容量：停车场的容量。它是1到100的整数。
//AC2：我应该能够在系统中列出所有停车场。每个停车场应包含其parkingLotID，availablePositionCount和每个停车场的容量。
@Mapper
public interface ParkingLotMapper {
	
	@Select("select * from parkingLot")
	List<ParkingLot> selectAllParkingLots();
	
	@Insert("insert into parkingLot values(#{parkingLot.parkingLotID},#{parkingLot.availablePositionCount},#{parkingLot.capacity},#{parkingLot.parkingBoyId})")
	void insertParkingLot(@Param("parkingLot") ParkingLot parkingLot);
	
	@Update("update parkingLot set availablePositionCount=#{parkingLot.availablePositionCount}, capacity=#{parkingLot.capacity},parkingBoyId = #{parkingLot.parkingBoyId}  where id = #{id};")
	   void updateParkingLot(@Param("id") int id, @Param("parkingLot") ParkingLot parkingLot);
	
    @Delete("delete from parkingLot where parkingLot.id = #{id};")
    void deleteParkingLot(@Param("id") int id);
    
    @Select("select * from parkingLot OFFSET #{skipItemCount} ROWS FETCH NEXT #{pageSize} ROWS ONLY" )
    List<ParkingLot> selectAllEmployeesPage(@Param("skipItemCount")int skipItemCount,@Param("pageSize")int pageSize);
	
}

