package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tws.entity.Employee;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ParkingLot> getAll() {
        return parkingLotMapper.selectAllParkingLots();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void postEmployee(@RequestBody ParkingLot parkingLot) {
        parkingLotMapper.insertParkingLot(parkingLot);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@PathVariable int id, @RequestBody ParkingLot parkingLot){
        parkingLotMapper.updateParkingLot(id,parkingLot);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int id) {
        parkingLotMapper.deleteParkingLot(id);
    }

}
