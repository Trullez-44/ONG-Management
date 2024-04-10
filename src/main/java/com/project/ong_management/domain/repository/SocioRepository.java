package com.project.ong_management.domain.repository;

import com.project.ong_management.persistance.entity.Socio;
import com.project.ong_management.persistance.entity.TipoCuota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Integer> {
    @Query("SELECT s FROM Socio s JOIN s.reportes r WHERE r.tipoCuota = :tipoCuota")
    List<Socio> findByTipoCuota(@Param("tipoCuota") TipoCuota tipoCuota);

}
