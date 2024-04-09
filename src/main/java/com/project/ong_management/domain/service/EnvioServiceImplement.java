package com.project.ong_management.domain.service;

import com.project.ong_management.configuracion.EnvioConvert;
import com.project.ong_management.domain.repository.EnvioRepository;
import com.project.ong_management.exceptions.ResourceNotFoundException;
import com.project.ong_management.persistance.DTO.EnvioDTO;
import com.project.ong_management.persistance.entity.Envio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnvioServiceImplement implements EnvioService {

    private final EnvioRepository envioRepository;
    private final EnvioConvert envioConvert;

    @Override
    @Transactional
    public EnvioDTO saveEnvio(EnvioDTO envioDTO) {
        Envio envio = envioConvert.convertDTOToEnvio(envioDTO);
        envioRepository.save(envio);
        return envioConvert.envioToEnvioDTO(envio);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EnvioDTO> findAllEnvios() {
        List<Envio> envios = envioRepository.findAll();
        return envios.stream()
                .map(envioConvert::envioToEnvioDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public EnvioDTO findEnvioById(int id) {
        Optional<Envio> envioOptional = envioRepository.findById(id);
        if (envioOptional.isPresent()) {
            Envio envio = envioOptional.get();
            return envioConvert.envioToEnvioDTO(envio);
        } else {
            throw new ResourceNotFoundException("Envio no encontrado con el ID: " + id);
        }
    }

    @Override
    @Transactional
    public EnvioDTO updateEnvio(int envioId, EnvioDTO envioDTO) {
        Optional<Envio> envioOptional = envioRepository.findById(envioId);
        if (envioOptional.isPresent()) {
            Envio envioDB = envioOptional.get();
            // Actualizar los campos del envioDB con los valores del envioDTO
            // ...
            envioRepository.save(envioDB);
            return envioConvert.envioToEnvioDTO(envioDB);
        } else {
            throw new ResourceNotFoundException("Envio no encontrado con el ID: " + envioId);
        }
    }

    @Override
    @Transactional
    public void deleteEnvioById(int envioId) {
        envioRepository.deleteById(envioId);
    }
}
