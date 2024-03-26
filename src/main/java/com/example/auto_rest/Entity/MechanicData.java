package com.example.auto_rest.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mechanic_data")
public class MechanicData {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mechanic_data_seq_gen")
    @SequenceGenerator(name = "mechanic_data_seq_gen", sequenceName = "mechanic_data_id_seq")
    private long id;

    private String name;

    private String surname;

    private String specialisation;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
