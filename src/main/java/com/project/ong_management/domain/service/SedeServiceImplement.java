package com.project.ong_management.domain.service;

import com.project.ong_management.domain.repository.SedeRepository;
import com.project.ong_management.persistance.entity.Sede;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SedeServiceImplement implements SedeService {

    private SedeRepository sedeRepository;

    @Override
    public void saveSede(Sede sede) {

    }
}
