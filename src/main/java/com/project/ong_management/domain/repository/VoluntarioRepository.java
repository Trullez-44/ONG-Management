package com.project.ong_management.domain.repository;

import com.project.ong_management.persistance.entity.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer> {
    @Query(value = "SELECT * FROM voluntario WHERE sede_id = ?1", nativeQuery = true)
    List<Voluntario> findByIdSede(Integer sede_id);

    @Query(value = "SELECT * FROM voluntario WHERE LOWER(profesion) = LOWER(?1)", nativeQuery = true)
    List<Voluntario> findByProfesion(String profesion);

}
