package com.project.ong_management.controllers;

import com.project.ong_management.configuracion.VoluntarioConvert;
import com.project.ong_management.domain.repository.VoluntarioRepository;
import com.project.ong_management.domain.service.VoluntarioService;
import com.project.ong_management.persistance.DTO.VoluntarioDTO;
import com.project.ong_management.persistance.entity.Voluntario;
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
@RequestMapping("api/voluntarios")
@RequiredArgsConstructor
public class VoluntarioController {

    private final VoluntarioService voluntarioService;
    private final VoluntarioRepository voluntarioRepository;
    private final VoluntarioConvert voluntarioConvert;

    @GetMapping("/sede/{sede_id}")
    public List<VoluntarioDTO> findVoluntariosBySede(@PathVariable Integer sede_id){
        return voluntarioService.findVoluntarioBySede(sede_id);
    }

    @GetMapping("/profesion/{profesion}")
    public List<VoluntarioDTO> findVoluntariosByProfesion(@PathVariable String profesion){
        return voluntarioService.findVoluntarioByProfesion(profesion);
    }
    @PostMapping()
    public ResponseEntity<Map<String, Object>> saveVoluntario(@Validated @RequestBody VoluntarioDTO voluntarioDTO, BindingResult bindingResult) {
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
            VoluntarioDTO savedVoluntario = voluntarioService.saveVoluntario(voluntarioDTO);
            response.put("mensaje", "El Voluntario ha sido creado con éxito");
            response.put("voluntario", savedVoluntario);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al guardar el Voluntario en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public List<VoluntarioDTO> findAll() {
        List<Voluntario> voluntarios = (List<Voluntario>) voluntarioRepository.findAll();
        return voluntarios.stream().map(voluntarioConvert::voluntarioToVoluntarioDTO).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        VoluntarioDTO voluntarioDTO = voluntarioService.findVoluntarioById(id);
        return ResponseEntity.ok(voluntarioDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Validated @RequestBody VoluntarioDTO voluntarioDTO, BindingResult bindingResult) {
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
            voluntarioDTO.setVoluntarioId(id);
            VoluntarioDTO updatedVoluntario = voluntarioService.updateVoluntario(voluntarioDTO);
            response.put("mensaje", "El Voluntario ha sido actualizado con éxito");
            response.put("voluntario", updatedVoluntario);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el voluntario en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        voluntarioService.deleteVoluntarioById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/asociar")
    public void associateVolunteers(@RequestBody Map<String,Integer> valores){
        int envioDetalleId = valores.get("envioDetalleId");
        int voluntarioId = valores.get("voluntarioId");
        voluntarioService.associateVolunteers(envioDetalleId, voluntarioId);
    }
}
