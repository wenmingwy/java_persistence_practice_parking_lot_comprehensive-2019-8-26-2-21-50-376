package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tws.entity.Employee;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;
import tws.service.ParkingLotService;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ParkingLot> getAll() {
        return parkingLotService.getAllParkingLotsService();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void postEmployee(@RequestBody ParkingLot parkingLot) {
    	parkingLotService.postEmployeeService(parkingLot);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@PathVariable int id, @RequestBody ParkingLot parkingLot){
    	parkingLotService.updateEmployeeService(id,parkingLot);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int id) {
    	parkingLotService.deleteEmployeeService(id);
    }
    
//  分页功能
  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<ParkingLot> displayPageParkingLotControll(@RequestParam(name = "pageSize")int pageSize,@RequestParam(name = "displayPage")int displayPage) {
  		return parkingLotService.selectAllParkingLotPage(pageSize,displayPage);
   }

}
