package com.Colegio_spring.colegio_spring_sql.Servicios;

import com.Colegio_spring.colegio_spring_sql.Entidades.Materia;
import com.Colegio_spring.colegio_spring_sql.Repositorios.MateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionMateriasServicios {

    @Autowired
    private MateriaRepositorio materiaRepositorio;

    public Materia agregarMateria(Materia materia) {
        return materiaRepositorio.save(materia);
    }

    public Optional<Materia> actualizarMateria(String codigo, Materia materiaActualizada) {
        Optional<Materia> materiaExistente = materiaRepositorio.findById(codigo);
        if (materiaExistente.isPresent()) {
            materiaActualizada.setCodigo(codigo);
            return Optional.of(materiaRepositorio.save(materiaActualizada));
        }
        return Optional.empty();
    }

    public boolean eliminarMateria(String codigo) {
        if (materiaRepositorio.existsById(codigo)) {
            materiaRepositorio.deleteById(codigo);
            return true;
        }
        return false;
    }

    public Optional<Materia> buscarMateria(String codigo) {
        return materiaRepositorio.findById(codigo);
    }

    public List<Materia> listarMaterias() {
        return materiaRepositorio.findAll();
    }
}
