package com.project.ong_management.domain.service;

import com.project.ong_management.persistance.DTO.SocioDTO;
import com.project.ong_management.persistance.entity.TipoCuota;

import java.util.List;

public interface SocioService {
    SocioDTO saveSocio(SocioDTO SocioDTO);
    List<SocioDTO> findAllSocios();
    SocioDTO findSocioById(Integer id);
    SocioDTO updateSocio(Integer SocioId, SocioDTO SocioDTO);
    void deleteSocioById(Integer SocioId);

    List<SocioDTO> findByTipoCuota(TipoCuota tipoCuota);
}
