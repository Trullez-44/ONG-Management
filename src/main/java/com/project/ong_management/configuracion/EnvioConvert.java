package com.project.ong_management.configuracion;

import com.project.ong_management.persistance.DTO.EnvioDTO;
import com.project.ong_management.persistance.entity.Envio;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EnvioConvert {

    private final ModelMapper modelMapper;

    public EnvioDTO envioToEnvioDTO(Envio envio) {
        return modelMapper.map(envio, EnvioDTO.class);
    }

    public Envio convertDTOToEnvio(EnvioDTO envioDTO) {
        return modelMapper.map(envioDTO, Envio.class);
    }
}
