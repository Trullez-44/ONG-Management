package com.project.ong_management.configuracion;

import com.project.ong_management.persistance.DTO.VoluntarioDTO;
import com.project.ong_management.persistance.entity.Voluntario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoluntarioConvert {

    private final ModelMapper modelMapper;
    public Voluntario convertDTOToVoluntario(VoluntarioDTO voluntarioDTO) {
        return modelMapper.map(voluntarioDTO, Voluntario.class);
    }

    public VoluntarioDTO voluntarioToVoluntarioDTO(Voluntario voluntario) {

        return modelMapper.map(voluntario, VoluntarioDTO.class);
    }
}
