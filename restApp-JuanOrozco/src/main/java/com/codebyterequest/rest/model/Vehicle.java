package com.codebyterequest.rest.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String maximum_speed;
    @Column(nullable = false)
    private String engine;
    @Column(nullable = false)
    private String features;
    @Column(nullable = false)
    private String launch_date;
}
