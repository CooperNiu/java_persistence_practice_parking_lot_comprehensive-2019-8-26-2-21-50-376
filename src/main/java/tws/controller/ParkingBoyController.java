package tws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.ParkingBoy;
import tws.repository.ParkingBoyMapper;

@RestController
@RequestMapping("parkingboys")
public class ParkingBoyController {

    @Autowired
    ParkingBoyMapper parkingBoyMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ParkingBoy> queryList(){
        return parkingBoyMapper.selectAll();
    }
}