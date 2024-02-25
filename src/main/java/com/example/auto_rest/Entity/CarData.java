package com.example.auto_rest.Entity;

import jakarta.persistence.*;

@Entity
@Table(name  = "car_data")
public class CarData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    private String owner;

    private int manufacture_year;

    private String firm;

    @OneToOne(mappedBy = "car")
    private RepairData repairData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getManufacture_year() {
        return manufacture_year;
    }

    public void setManufacture_year(int manufacture_year) {
        this.manufacture_year = manufacture_year;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public RepairData getRepairData() {
        return repairData;
    }

    public void setRepairData(RepairData repairData) {
        this.repairData = repairData;
    }
}
