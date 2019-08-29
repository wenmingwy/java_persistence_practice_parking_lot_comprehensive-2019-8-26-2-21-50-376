package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @GetMapping("")
    public ResponseEntity<List<ParkingLot>> getAll() {
        return ResponseEntity.ok(parkingLotMapper.selectAllParkingLots());
    }

    @PostMapping("")
    public ResponseEntity<ParkingLot> createEmployee(@RequestBody ParkingLot parkingLot) {
        parkingLotMapper.insertParkingLot(parkingLot);
        return ResponseEntity.created(URI.create("/parkinglots/" + parkingLot.getId())).body(parkingLot);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingLot> updateEmployee(@PathVariable int id, @RequestBody ParkingLot parkingLot){
        parkingLotMapper.updateParkingLot(id,parkingLot);
        return ResponseEntity.ok(parkingLot);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int id) {
        parkingLotMapper.deleteParkingLot(id);
    }

}
