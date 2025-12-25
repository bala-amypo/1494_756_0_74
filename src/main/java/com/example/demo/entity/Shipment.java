package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Location pickupLocation;

    @ManyToOne
    private Location dropLocation;

    private Double weightKg;
    private LocalDate scheduledDate;

    public Shipment() {}

    public Shipment(Vehicle vehicle, Location pickupLocation,
                    Location dropLocation, Double weightKg,
                    LocalDate scheduledDate) {
        this.vehicle = vehicle;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.weightKg = weightKg;
        this.scheduledDate = scheduledDate;
    }

    // ✅ REQUIRED GETTERS
    public Long getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public Location getPickupLocation() { return pickupLocation; }
    public Location getDropLocation() { return dropLocation; }
    public Double getWeightKg() { return weightKg; }
    public LocalDate getScheduledDate() { return scheduledDate; }

    // setters used by services
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setPickupLocation(Location pickupLocation) { this.pickupLocation = pickupLocation; }
    public void setDropLocation(Location dropLocation) { this.dropLocation = dropLocation; }
}
