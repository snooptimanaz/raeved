package com.raever.service;
import com.raever.model.Product;
import com.raever.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    @Autowired private ProductRepository productRepository;
    public List<Product> getProductsForVehicle(Long vehicleId) { return productRepository.findProductsForVehicle(vehicleId); }
    public List<Product> getProductsByCategory(String category) { return productRepository.findByCategory(category); }
    public List<Product> getAllProducts() { return productRepository.findAll(); }
    public Product saveProduct(Product product) { if (product.getCreatedAt() == null) { product.setCreatedAt(LocalDateTime.now()); } return productRepository.save(product); }
    public void deleteProduct(Long id) { productRepository.deleteById(id); }
}