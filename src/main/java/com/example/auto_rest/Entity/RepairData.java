package com.example.auto_rest.Entity;


import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "repair_data")
public class RepairData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private int price;
    @ManyToOne
    @JoinColumn(name = "mechanic_data_id",nullable = false)
    private MechanicData mechanic;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_data_id",referencedColumnName = "id")
    private CarData car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
