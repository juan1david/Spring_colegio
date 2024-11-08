package com.Colegio_spring.colegio_spring_sql.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Usuarios extends Usuario {

    @Column(nullable = false, length = 50)
    private String documento;

    @Column(nullable = false, length = 50)
    private String password;

    public Usuarios() {
        super();
    }

    public Usuarios(String nombre, Rol rol, String documento, String password) {
        super(nombre, "Usuario", rol);  // Llamamos al constructor de la clase base con el tipo de usuario "Usuario"
        this.documento = documento;
        this.password = password;
    }

    // Getters y setters
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "documento='" + documento + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", rol='" + getRol() + '\'' +
                '}';
    }
}
