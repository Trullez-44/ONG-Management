package com.project.ong_management.controllers;

import com.project.ong_management.domain.service.SedeService;
import com.project.ong_management.persistance.DTO.SedeDTO;
import lombok.AllArgsConstructor;
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
@RequestMapping("api/sedes")
@RequiredArgsConstructor
public class SedeController {

    private final SedeService sedeService;
    @PostMapping()
    public ResponseEntity<Map<String, Object>> saveSede(@Validated @RequestBody SedeDTO sedeDTO, BindingResult answerResult){
        Map<String, Object> response = new HashMap<>();
        try {

            if (answerResult.hasErrors()) {
                List<String> errors = answerResult.getFieldErrors()
                        .stream()
                        .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
                response.put("errors", errors);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
            SedeDTO sedeToSave = null;
            sedeToSave = sedeService.saveSede(sedeDTO);
            response.put("mensaje", "La Sede ha sido creada con exito");
            response.put("Sede", sedeDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (DataAccessException e) {
            response.put("mensaje", "Error al guardar la entidad en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
}
@GetMapping()
public List<SedeDTO> findAll(){
        return sedeService.findAllSedes();
}
@GetMapping("/{id}")
    public SedeDTO findById(@PathVariable Integer id){
        return sedeService.findSedeById(id);
}
@PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Integer id, @Validated @RequestBody SedeDTO sedeDTO, BindingResult answerResult){
    Map<String, Object> response = new HashMap<>();
    try {
        if (answerResult.hasErrors()) {
            List<String> errors = answerResult.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        SedeDTO sedeToUpdate = null;
        sedeToUpdate = sedeService.updateSede(id, sedeDTO);
        response.put("mensaje", "La Sede ha sido actualizada con exito");
        response.put("Sede", sedeDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    catch (DataAccessException e) {
        response.put("mensaje", "Error al actualizar la entidad en la base de datos");
        response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        sedeService.deleteSedeById(id);
    }
}


