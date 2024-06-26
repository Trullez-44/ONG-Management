package com.project.ong_management.configuracion;

import com.project.ong_management.persistance.DTO.SedeDTO;
import com.project.ong_management.persistance.entity.Sede;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SedeConvert {

    private ModelMapper dbm;

    public Sede ConvertDTOToSede(SedeDTO sedeDTO){
        return dbm.map(sedeDTO,Sede.class);

    }
    public SedeDTO SedeToSedeDTO(Sede sede){
        SedeDTO sedeDTO = dbm.map(sede, SedeDTO.class);

        sedeDTO.setSedeId(sede.getSedeId());
        sedeDTO.setNombre(sede.getNombre());
        sedeDTO.setDireccion(sede.getDireccion());
        sedeDTO.setCiudad(sede.getCiudad());
        sedeDTO.setDirector(sede.getDirector());
//        sedeDTO.setSocios(sede.getSocios());
        return sedeDTO;
    }
}
