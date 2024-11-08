package com.Colegio_spring.colegio_spring_sql.Servicios;

import com.Colegio_spring.colegio_spring_sql.Entidades.Usuarios;
import com.Colegio_spring.colegio_spring_sql.Repositorios.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servicios_Usuarios {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    public List<Usuarios> getLista() {
        return usuariosRepositorio.findAll();
    }

    public String agregar(Usuarios usuario) {
        if (usuariosRepositorio.existsById(usuario.getDocumento())) {
            return "El usuario con el documento " + usuario.getDocumento() + " ya existe.";
        }
        usuariosRepositorio.save(usuario);
        return "Usuario agregado exitosamente.";
    }

    public Optional<Usuarios> buscarPorDocumento(String documento) {
        return usuariosRepositorio.findById(documento);
    }

    public Usuarios login(String documento, String password) {
        Optional<Usuarios> usuario = usuariosRepositorio.findById(documento);
        return usuario.filter(u -> u.getPassword().equals(password)).orElse(null);
    }
}
