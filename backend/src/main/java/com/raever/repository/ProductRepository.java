package com.raever.repository;
import com.raever.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p.* FROM products p JOIN product_vehicle_match pvm ON p.id = pvm.product_id WHERE pvm.vehicle_id = :vehicleId", nativeQuery = true)
    List<Product> findProductsForVehicle(@Param("vehicleId") Long vehicleId);
    List<Product> findByCategory(String category);
}