package com.raever.repository;
import com.raever.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v FROM Vehicle v WHERE (:brand IS NULL OR LOWER(v.brand) LIKE LOWER(CONCAT('%', :brand, '%'))) AND (:series IS NULL OR LOWER(v.series) LIKE LOWER(CONCAT('%', :series, '%'))) AND (:motor IS NULL OR LOWER(v.motor) LIKE LOWER(CONCAT('%', :motor, '%')))")
    List<Vehicle> searchVehicles(@Param("brand") String brand, @Param("series") String series, @Param("motor") String motor);
    List<Vehicle> findByHsnAndTsn(String hsn, String tsn);
}