package com.project.ong_management.controllers;

import com.project.ong_management.domain.service.EnvioService;
import com.project.ong_management.persistance.DTO.EnvioDTO;
import com.project.ong_management.persistance.entity.Envio;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/envios")
@RequiredArgsConstructor
public class EnvioController {

    private final EnvioService envioService;

    @PostMapping()
    public ResponseEntity<Map<String, Object>> saveEnvio(@Validated @RequestBody EnvioDTO envioDTO, BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (bindingResult.hasErrors()) {
                List<String> errors = bindingResult.getFieldErrors()
                        .stream()
                        .map(err -> "En el campo " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            EnvioDTO savedEnvio = envioService.saveEnvio(envioDTO);
            response.put("mensaje", "El Envio ha sido creado con éxito");
            response.put("envio", savedEnvio);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al guardar el Envio en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public List<EnvioDTO> findAll() {
        return envioService.findAllEnvios();
    }

    @GetMapping("/{id}")
    public Envio findById(@PathVariable Integer id) {
        return envioService.findEnvioById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Validated @RequestBody EnvioDTO envioDTO, BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (bindingResult.hasErrors()) {
                List<String> errors = bindingResult.getFieldErrors()
                        .stream()
                        .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            EnvioDTO updatedEnvio = envioService.updateEnvio(id, envioDTO);
            response.put("mensaje", "El Envio ha sido actualizado con éxito");
            response.put("envio", updatedEnvio);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el Envio en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        envioService.deleteEnvioById(id);
        return ResponseEntity.noContent().build();
    }
}
