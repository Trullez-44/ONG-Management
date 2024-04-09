package com.project.ong_management.domain.repository;

import com.project.ong_management.persistance.entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio, Integer> {
}
