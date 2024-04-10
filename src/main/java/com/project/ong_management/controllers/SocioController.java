package com.project.ong_management.controllers;

import com.project.ong_management.domain.service.SocioService;
import com.project.ong_management.persistance.DTO.SocioDTO;
import com.project.ong_management.persistance.entity.TipoCuota;
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
@RequestMapping("api/socios")
@RequiredArgsConstructor
public class SocioController {

    private final SocioService socioService;

    @GetMapping("/tipo-cuota/{tipoCuota}")
    public ResponseEntity<List<SocioDTO>> findAllSociosByTipoCuota(@PathVariable TipoCuota tipoCuota) {
        List<SocioDTO> socios = socioService.findByTipoCuota(tipoCuota);
        return new ResponseEntity<>(socios, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Map<String, Object>> saveSocio(@Validated @RequestBody SocioDTO socioDTO, BindingResult bindingResult) {
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
            SocioDTO savedSocio = socioService.saveSocio(socioDTO);
            response.put("mensaje", "El Socio ha sido creado con éxito");
            response.put("socio", savedSocio);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al guardar AL socio en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public List<SocioDTO> findAll() {
        return socioService.findAllSocios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        SocioDTO socioDTO = socioService.findSocioById(id);
        return ResponseEntity.ok(socioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Validated @RequestBody SocioDTO socioDTO, BindingResult bindingResult) {
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
            SocioDTO updatedSocio = socioService.updateSocio(id, socioDTO);
            response.put("mensaje", "El Socio ha sido actualizado con éxito");
            response.put("socio", updatedSocio);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el socio en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        socioService.deleteSocioById(id);
        return ResponseEntity.noContent().build();
    }
}
