package com.project.ong_management.domain.repository;

import com.project.ong_management.persistance.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SedeRepository extends JpaRepository<Sede, Integer> {

}
