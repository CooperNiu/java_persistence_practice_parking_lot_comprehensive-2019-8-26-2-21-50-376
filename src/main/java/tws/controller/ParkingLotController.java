package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/parklots")
public class ParkingLotController {

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @GetMapping("")
    public ResponseEntity<List<ParkingLot>> getAll() {
        return ResponseEntity.ok(parkingLotMapper.selectAll());
    }

    public ResponseEntity<List<ParkingLot>> getEmployees(int id) {
        List<ParkingLot> lotList = parkingLotMapper.selectById(id);
        return ResponseEntity.ok(lotList);
    }

    @PostMapping("")
    public ResponseEntity<ParkingLot> insert(@RequestBody ParkingLot parkingLot) {
        parkingLotMapper.insert(parkingLot);
        return ResponseEntity.created(URI.create("/parklots/" + parkingLot.getParkingLotID())).body(parkingLot);
    }
}
