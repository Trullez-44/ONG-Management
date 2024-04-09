package com.project.ong_management.domain.service;

import com.project.ong_management.configuracion.VoluntarioConvert;
import com.project.ong_management.domain.repository.VoluntarioRepository;
import com.project.ong_management.exceptions.ResourceNotFoundException;
import com.project.ong_management.persistance.DTO.VoluntarioDTO;
import com.project.ong_management.persistance.entity.Voluntario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoluntarioServiceImplement implements VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;
    private final VoluntarioConvert voluntarioConvert;

    @Override
    @Transactional
    public VoluntarioDTO saveVoluntario(VoluntarioDTO voluntarioDTO) {
        Voluntario voluntario = voluntarioConvert.convertDTOToVoluntario(voluntarioDTO);
        voluntario.setSede(voluntarioDTO.getSede());
        voluntarioRepository.save(voluntario);
        return voluntarioConvert.voluntarioToVoluntarioDTO(voluntario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VoluntarioDTO> findAllVoluntarios() {
        List<Voluntario> voluntarios = voluntarioRepository.findAll();
        return voluntarios.stream()
                .map(voluntarioConvert::voluntarioToVoluntarioDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public VoluntarioDTO findVoluntarioById(Integer id) {
        Optional<Voluntario> voluntarioOptional = voluntarioRepository.findById(id);
        if (voluntarioOptional.isPresent()) {
            Voluntario voluntario = voluntarioOptional.get();
            return voluntarioConvert.voluntarioToVoluntarioDTO(voluntario);
        } else {
            throw new ResourceNotFoundException("Voluntario no encontrado con el ID: " + id);
        }
    }

    @Override
    @Transactional
    public VoluntarioDTO updateVoluntario(Integer voluntarioId, VoluntarioDTO voluntarioDTO) {
        Optional<Voluntario> voluntarioOptional = voluntarioRepository.findById(voluntarioId);
        if (voluntarioOptional.isPresent()) {
            Voluntario voluntarioDB = voluntarioOptional.get();
            // Actualizar los campos del voluntarioDB con los valores de voluntarioDTO
            // No incluido en este código
            voluntarioRepository.save(voluntarioDB);
            return voluntarioConvert.voluntarioToVoluntarioDTO(voluntarioDB);
        } else {
            throw new ResourceNotFoundException("Voluntario no encontrado con el ID: " + voluntarioId);
        }
    }

    @Override
    @Transactional
    public void deleteVoluntarioById(Integer voluntarioId) {
        voluntarioRepository.deleteById(voluntarioId);
    }
}
