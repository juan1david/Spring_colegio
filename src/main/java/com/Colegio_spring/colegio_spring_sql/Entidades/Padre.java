package com.Colegio_spring.colegio_spring_sql.Entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Padre")
public class Padre extends Usuario {

    private String telefono;

    public Padre() {
    }

    public Padre(String nombre, String email, String telefono) {
        super(nombre, email);
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
