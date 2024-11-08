package com.Colegio_spring.colegio_spring_sql.Controladores;

import com.Colegio_spring.colegio_spring_sql.Entidades.Materia;
import com.Colegio_spring.colegio_spring_sql.Servicios.GestionMateriasServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/materias")
public class MateriaControlador {

    @Autowired
    private GestionMateriasServicios gestionMateriasServicios;

    @PostMapping("/agregar")
    public ResponseEntity<Materia> agregarMateria(@RequestBody Materia materia) {
        Materia nuevaMateria = gestionMateriasServicios.agregarMateria(materia);
        return new ResponseEntity<>(nuevaMateria, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<Materia> actualizarMateria(@PathVariable String codigo, @RequestBody Materia materiaActualizada) {
        Optional<Materia> materiaOptional = gestionMateriasServicios.actualizarMateria(codigo, materiaActualizada);
        return materiaOptional.map(materia -> new ResponseEntity<>(materia, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<String> eliminarMateria(@PathVariable String codigo) {
        if (gestionMateriasServicios.eliminarMateria(codigo)) {
            return ResponseEntity.ok("Materia eliminada exitosamente.");
        } else {
            return new ResponseEntity<>("Materia no encontrada.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<Materia> buscarMateria(@PathVariable String codigo) {
        Optional<Materia> materiaOptional = gestionMateriasServicios.buscarMateria(codigo);
        return materiaOptional.map(materia -> new ResponseEntity<>(materia, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Materia>> listarMaterias() {
        List<Materia> materias = gestionMateriasServicios.listarMaterias();
        return ResponseEntity.ok(materias);
    }
}
