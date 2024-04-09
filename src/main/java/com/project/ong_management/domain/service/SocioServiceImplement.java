package com.project.ong_management.domain.service;

import com.project.ong_management.configuracion.SocioConvert;
import com.project.ong_management.domain.repository.SocioRepository;
import com.project.ong_management.exceptions.ResourceNotFoundException;
import com.project.ong_management.persistance.DTO.SocioDTO;
import com.project.ong_management.persistance.entity.Socio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocioServiceImplement implements SocioService {

    private final SocioRepository socioRepository;
    private final SocioConvert socioConvert;

    @Autowired
    public SocioServiceImplement(SocioRepository socioRepository, SocioConvert socioConvert) {
        this.socioRepository = socioRepository;
        this.socioConvert = socioConvert;
    }

    @Override
    @Transactional
    public SocioDTO saveSocio(SocioDTO socioDTO) {
        Socio socio = socioConvert.convertDTOToSocio(socioDTO);
        socioDTO.getReportes().forEach(reporteCuenta -> reporteCuenta.setSocio(socio));
        socioRepository.save(socio);
        return socioConvert.socioToSocioDTO(socio);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SocioDTO> findAllSocios() {
        List<Socio> socios = socioRepository.findAll();
        return socios.stream()
                .map(socioConvert::socioToSocioDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public SocioDTO findSocioById(Integer id) {
        Socio socioOptional = socioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Socio no encontrado con el ID: " + id));
        return socioConvert.socioToSocioDTO(socioOptional);

    }

    @Override
    @Transactional
    public SocioDTO updateSocio(Integer socioId, SocioDTO socioDTO) {
        Optional<Socio> socioOptional = socioRepository.findById(socioId);
        if (socioOptional.isPresent()) {
            Socio socioDB = socioOptional.get();
            socioDB.setNombre(socioDTO.getNombre());
            socioDB.setApellido(socioDTO.getApellido());
            socioDB.setTelefono(socioDTO.getTelefono());
            socioDB.setCorreoElectronico(socioDTO.getCorreoElectronico());
            socioRepository.save(socioDB);
            return socioConvert.socioToSocioDTO(socioDB);
        } else {
            throw new ResourceNotFoundException("Socio no encontrado con el ID: " + socioId);
        }
    }

    @Override
    @Transactional
    public void deleteSocioById(Integer socioId) {
        socioRepository.deleteById(socioId);
    }
}
