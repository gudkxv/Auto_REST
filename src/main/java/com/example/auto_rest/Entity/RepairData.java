package com.example.auto_rest.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "repair_data")
public class RepairData {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "repair_data_seq_gen")
    @SequenceGenerator(name = "repair_data_seq_gen", sequenceName = "repair_data_id_seq")
    private long id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private int price;
    @ManyToOne(cascade = CascadeType.ALL)
    private MechanicData mechanic;
    @ManyToOne(cascade = CascadeType.ALL)
    private CarData car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public MechanicData getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicData mechanic) {
        this.mechanic = mechanic;
    }

    public CarData getCar() {
        return car;
    }

    public void setCar(CarData car) {
        this.car = car;
    }
}
