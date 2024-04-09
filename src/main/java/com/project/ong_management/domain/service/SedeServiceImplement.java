package com.project.ong_management.domain.service;

import com.project.ong_management.configuracion.SedeConvert;
import com.project.ong_management.domain.repository.SedeRepository;
import com.project.ong_management.exceptions.ResourceNotFoundException;
import com.project.ong_management.persistance.DTO.SedeDTO;
import com.project.ong_management.persistance.entity.Sede;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SedeServiceImplement implements SedeService {

    private SedeRepository sedeRepository;
    private SedeConvert sedeConvert;

    @Override
    @Transactional
    public SedeDTO saveSede(SedeDTO sedeDTO) {

        Sede sede = sedeConvert.ConvertDTOToSede(sedeDTO);
        sedeRepository.save(sede);
        return sedeConvert.SedeToSedeDTO(sede);

    }
    @Override
    @Transactional(readOnly = true)
    public List<SedeDTO> findAllSedes() {
        List<Sede> sedes = (List<Sede>) sedeRepository.findAll();
        return sedes.stream()
                .map(sede -> sedeConvert.SedeToSedeDTO(sede))
                .toList();
    }


    @Override
    @Transactional(readOnly = true)
    public SedeDTO findSedeById(Integer id) {
        Optional<Sede> sedeOptional = sedeRepository.findById(id);
        if (sedeOptional.isPresent()) {
            Sede sede = sedeOptional.get();
            return sedeConvert.SedeToSedeDTO(sede);
        } else {
            // Lanzar una excepción ResourceNotFoundException si no se encuentra la sede
            throw new ResourceNotFoundException("Sede no encontrada con el ID: " + id);
        }
    }




    @Override
    @Transactional
    public SedeDTO updateSede(Integer sedeId, SedeDTO sedeDTO) {

        Optional<Sede> sedeOptional = sedeRepository.findById(sedeId);

        if(sedeOptional.isPresent()){

            Sede sedeDB = sedeConvert.ConvertDTOToSede(sedeDTO);
            sedeDB.setSedeId(sedeId);
            sedeDB.setCiudad(sedeDTO.getCiudad());
            sedeDB.setDireccion(sedeDTO.getDireccion());
            sedeDB.setDirector(sedeDTO.getDirector());
//            sedeDB.setSocios(sedeDTO.getSocios());
            sedeRepository.save(sedeDB);

            return sedeConvert.SedeToSedeDTO(sedeDB);
        }
        return null;
    }
    @Override
    @Transactional
    public void deleteSedeById(Integer sedeId) {
sedeRepository.deleteById(sedeId);
    }
}
