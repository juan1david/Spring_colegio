package com.Colegio_spring.colegio_spring_sql.Repositorios;

import com.Colegio_spring.colegio_spring_sql.Entidades.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia, String> {
}
