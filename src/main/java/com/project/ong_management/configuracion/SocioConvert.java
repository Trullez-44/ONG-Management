package com.project.ong_management.configuracion;

import com.project.ong_management.persistance.DTO.SocioDTO;
import com.project.ong_management.persistance.entity.Persona;
import com.project.ong_management.persistance.entity.Socio;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SocioConvert {

    private ModelMapper modelMapper;

    public Socio convertDTOToSocio(SocioDTO socioDTO) {
        return modelMapper.map(socioDTO, Socio.class);
    }

    public SocioDTO socioToSocioDTO(Socio socio) {
        SocioDTO socioDTO = modelMapper.map(socio, SocioDTO.class);

        socioDTO.setNombre(socio.getNombre());
        socioDTO.setApellido(socio.getApellido());
        socioDTO.setTelefono(socio.getTelefono());
        socioDTO.setCorreoElectronico(socio.getCorreoElectronico());

        return socioDTO;
    }
}
