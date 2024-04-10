package com.project.ong_management.domain.service;

import com.project.ong_management.persistance.DTO.EnvioDTO;
import com.project.ong_management.persistance.entity.Envio;

import java.util.List;

public interface EnvioService {

    EnvioDTO saveEnvio(EnvioDTO envioDTO);

    List<EnvioDTO> findAllEnvios();

    Envio findEnvioById(int id);

    EnvioDTO updateEnvio(int envioId, EnvioDTO envioDTO);

    void deleteEnvioById(int envioId);
}
