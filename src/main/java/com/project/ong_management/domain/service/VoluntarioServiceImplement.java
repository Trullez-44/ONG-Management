package com.project.ong_management.domain.service;

import com.project.ong_management.configuracion.SedeConvert;
import com.project.ong_management.configuracion.VoluntarioConvert;
import com.project.ong_management.domain.repository.SedeRepository;
import com.project.ong_management.domain.repository.VoluntarioRepository;
import com.project.ong_management.exceptions.ResourceNotFoundException;
import com.project.ong_management.persistance.DTO.VoluntarioDTO;
import com.project.ong_management.persistance.entity.Sede;
import com.project.ong_management.persistance.entity.Voluntario;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
    private final SedeRepository sedeRepository;
    private final SedeConvert sedeConvert;

    @Override
    @Transactional
    public VoluntarioDTO saveVoluntario(VoluntarioDTO voluntarioDTO) {
        Voluntario voluntario = voluntarioConvert.convertDTOToVoluntario(voluntarioDTO);
        Sede sede = sedeRepository.findById(voluntarioDTO.getSedeId()).orElse(null);

        if(sede == null){
            throw new IllegalArgumentException("La sede no existe");
        }

        voluntario.setSede(sede);
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
    public VoluntarioDTO updateVoluntario(VoluntarioDTO voluntarioDTO) {
        try {
            Voluntario voluntario = voluntarioRepository.findById(voluntarioDTO.getVoluntarioId()).orElseThrow(() -> new NotFoundException());
         voluntario.setNombre(voluntarioDTO.getNombre());
            voluntario.setApellido(voluntarioDTO.getApellido() != null ? voluntarioDTO.getApellido() : voluntario.getApellido());
            voluntario.setCorreoElectronico(voluntarioDTO.getCorreoElectronico() != null ? voluntarioDTO.getCorreoElectronico() : voluntario.getCorreoElectronico());
            voluntario.setTelefono(voluntarioDTO.getTelefono() != null ? voluntarioDTO.getTelefono() : voluntario.getTelefono());
            voluntario.setProfesion(voluntarioDTO.getProfesion());
            voluntario.setDisponibilidad(voluntarioDTO.isDisponibilidad());
            voluntario.setTipoVoluntario(voluntarioDTO.getTipoVoluntario());
            if(voluntarioDTO.getSedeId() != null){
                Sede sedeExist = sedeRepository.findById(voluntarioDTO.getSedeId()).orElseThrow(NotFoundException::new);
                voluntario.setSede(sedeExist);
            }
            Voluntario voluntarioUpdated = voluntarioRepository.save(voluntario);
            VoluntarioDTO voluntarioAns = voluntarioConvert.voluntarioToVoluntarioDTO(voluntarioUpdated);
            return voluntarioAns;
        }
        catch (NotFoundException e) {
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteVoluntarioById(Integer voluntarioId) {
        voluntarioRepository.deleteById(voluntarioId);
    }

    @Override
    public List<VoluntarioDTO> findVoluntarioBySede(Integer sedeId) {
        List<Voluntario> voluntarioEntities = voluntarioRepository.findByIdSede(sedeId);
        return voluntarioEntities.stream()
                .map(voluntarioConvert::voluntarioToVoluntarioDTO)
                .toList();
    }

    @Override
    public List<VoluntarioDTO> findVoluntarioByProfesion(String profesion) {

        List<Voluntario> voluntarioEntities = voluntarioRepository.findByProfesion(profesion);
        return voluntarioEntities.stream()
                .map(voluntarioConvert::voluntarioToVoluntarioDTO)
                .toList();
    }
}
