package com.example.apirest.entity;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Primary;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Entity
@Table(name = "animals")
public class Animal implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 250, name = "name", nullable = false)
    private String name;
    @Column(length = 250, name = "type", nullable = false)
    private String type;

    public Animal() {
    }

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static Animal saveAnimal(EntityManager entityManager, String name, String type) {
        Animal newAnimal = new Animal(name, type);
        entityManager.persist(newAnimal);
        return newAnimal;
    }

}
