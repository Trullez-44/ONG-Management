package com.project.ong_management.domain.service;

import com.project.ong_management.persistance.DTO.EnvioDTO;

import java.util.List;

public interface EnvioService {

    EnvioDTO saveEnvio(EnvioDTO envioDTO);

    List<EnvioDTO> findAllEnvios();

    EnvioDTO findEnvioById(int id);

    EnvioDTO updateEnvio(int envioId, EnvioDTO envioDTO);

    void deleteEnvioById(int envioId);
}
