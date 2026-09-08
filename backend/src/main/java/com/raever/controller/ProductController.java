package com.raever.controller;
import com.raever.model.Product;
import com.raever.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired private ProductService productService;
    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<Product>> getProductsForVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(productService.getProductsForVehicle(vehicleId));
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() { return ResponseEntity.ok(productService.getAllProducts()); }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) { return ResponseEntity.ok(productService.saveProduct(product)); }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        return ResponseEntity.ok(productService.saveProduct(product));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) { productService.deleteProduct(id); return ResponseEntity.ok().build(); }
}