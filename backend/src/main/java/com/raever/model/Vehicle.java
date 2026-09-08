package com.raever.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(length = 4) private String hsn;
    @Column(length = 3) private String tsn;
    @Column(nullable = false) private String brand;
    private String model; private String series; private String motor;
    @Column(name = "year_from") private Integer yearFrom;
    @Column(name = "year_to") private Integer yearTo;
    @Column(name = "created_at") private LocalDateTime createdAt;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getHsn() { return hsn; }
    public void setHsn(String hsn) { this.hsn = hsn; }
    public String getTsn() { return tsn; }
    public void setTsn(String tsn) { this.tsn = tsn; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getSeries() { return series; }
    public void setSeries(String series) { this.series = series; }
    public String getMotor() { return motor; }
    public void setMotor(String motor) { this.motor = motor; }
    public Integer getYearFrom() { return yearFrom; }
    public void setYearFrom(Integer yearFrom) { this.yearFrom = yearFrom; }
    public Integer getYearTo() { return yearTo; }
    public void setYearTo(Integer yearTo) { this.yearTo = yearTo; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}