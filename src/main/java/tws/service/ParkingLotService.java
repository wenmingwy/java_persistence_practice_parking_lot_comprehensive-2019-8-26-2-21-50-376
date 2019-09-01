package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import tws.entity.Employee;
import tws.entity.ParkingLot;
import tws.repository.EmployeeMapper;
import tws.repository.ParkingLotMapper;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotMapper  parkingLotMapper;
    

    public List<ParkingLot> getAllParkingLotsService() {
        return parkingLotMapper.selectAllParkingLots();
    }

    public void postEmployeeService( ParkingLot parkingLot) {
        parkingLotMapper.insertParkingLot(parkingLot);
    }

    public void updateEmployeeService(int id, ParkingLot parkingLot){
        parkingLotMapper.updateParkingLot(id,parkingLot);
    }

    public void deleteEmployeeService(int id) {
        parkingLotMapper.deleteParkingLot(id);
    }
        
    public List<ParkingLot> selectAllParkingLotPage(int pageSize,int displayPage) {
      	List<ParkingLot> result = parkingLotMapper.selectAllEmployeesPage(pageSize,displayPage);
      	return result ;
      
     }
}
