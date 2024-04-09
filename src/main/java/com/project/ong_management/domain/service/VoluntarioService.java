package com.project.ong_management.domain.service;

import com.project.ong_management.persistance.DTO.VoluntarioDTO;

import java.util.List;

public interface VoluntarioService {
    VoluntarioDTO saveVoluntario(VoluntarioDTO voluntarioDTO);

    List<VoluntarioDTO> findAllVoluntarios();

    VoluntarioDTO findVoluntarioById(Integer id);

    VoluntarioDTO updateVoluntario(Integer voluntarioId, VoluntarioDTO voluntarioDTO);

    void deleteVoluntarioById(Integer voluntarioId);
}
