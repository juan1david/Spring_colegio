package com.Colegio_spring.colegio_spring_sql.Entidades;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Docente")
public class Docente extends Usuario {

    private String materia;

    public Docente() {
    }

    public Docente(String nombre, String email, String materia) {
        super(nombre, email);
        this.materia = materia;
    }

    // Getters y Setters
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
