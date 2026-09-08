package com.raever.controller;
import com.raever.model.Vehicle;
import com.raever.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {
    @Autowired private VehicleService vehicleService;
    @GetMapping("/search")
    public ResponseEntity<List<Vehicle>> searchVehicles(@RequestParam(required = false) String brand, @RequestParam(required = false) String series, @RequestParam(required = false) String motor) {
        return ResponseEntity.ok(vehicleService.searchVehicles(brand, series, motor));
    }
    @GetMapping("/hsn-tsn")
    public ResponseEntity<List<Vehicle>> findByHsnTsn(@RequestParam String hsn, @RequestParam String tsn) {
        return ResponseEntity.ok(vehicleService.findByHsnAndTsn(hsn, tsn));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable Long id) {
        return vehicleService.getVehicle(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}