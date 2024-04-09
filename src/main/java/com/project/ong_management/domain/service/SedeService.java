package com.project.ong_management.domain.service;

import com.project.ong_management.persistance.DTO.SedeDTO;


import java.util.List;


public interface SedeService {
    SedeDTO saveSede(SedeDTO sedeDTO);
    List<SedeDTO> findAllSedes();
    SedeDTO findSedeById(Integer id);
    SedeDTO updateSede(Integer sedeId, SedeDTO sedeDTO);
    void deleteSedeById(Integer sedeId);
}
