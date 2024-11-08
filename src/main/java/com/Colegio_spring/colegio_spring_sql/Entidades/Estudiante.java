package com.Colegio_spring.colegio_spring_sql.Entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Estudiante")
public class Estudiante extends Usuario {

    private String carrera;

    public Estudiante() {
    }

    public Estudiante(String nombre, String email, String carrera) {
        super(nombre, email);
        this.carrera = carrera;
    }

    // Getters y Setters
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
