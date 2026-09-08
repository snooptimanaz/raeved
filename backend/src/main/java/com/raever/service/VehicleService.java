package com.raever.service;
import com.raever.model.Vehicle;
import com.raever.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired private VehicleRepository vehicleRepository;
    public List<Vehicle> searchVehicles(String brand, String series, String motor) { return vehicleRepository.searchVehicles(brand, series, motor); }
    public List<Vehicle> findByHsnAndTsn(String hsn, String tsn) { return vehicleRepository.findByHsnAndTsn(hsn, tsn); }
    public Optional<Vehicle> getVehicle(Long id) { return vehicleRepository.findById(id); }
    public Vehicle saveVehicle(Vehicle vehicle) { if (vehicle.getCreatedAt() == null) { vehicle.setCreatedAt(LocalDateTime.now()); } return vehicleRepository.save(vehicle); }
}