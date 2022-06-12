package com.carrplan.CarrPlanAplication.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrplan.CarrPlanAplication.DTO.AlternativasDTO;
import com.carrplan.CarrPlanAplication.models.AlternativasModel;
import com.carrplan.CarrPlanAplication.services.AlternativasServices;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/alternativas")
public class AlternativasController {
    
    
    final AlternativasServices alternativasServices;

    public AlternativasController(AlternativasServices alternativasServices) {
        this.alternativasServices = alternativasServices;
    }

    @PostMapping
    public ResponseEntity < Object > cadastrarAlternativas(@RequestBody @Valid AlternativasDTO alternativasDTO) {

        var alternativasModel = new AlternativasModel();

        BeanUtils.copyProperties(alternativasDTO, alternativasModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(alternativasServices.cadastrarAlternativas(alternativasModel));
    }

    @GetMapping
    public ResponseEntity < List < AlternativasModel >> buscarTodasAlternativas() {
        return ResponseEntity.status(HttpStatus.OK).body(alternativasServices.buscarTodasAlternativas());
    }

    @GetMapping("/{id}")
    public ResponseEntity < Object > buscarAlternativasPorId(@PathVariable(value = "id") UUID id) {

        Optional < AlternativasModel > alternativasModelOptional = alternativasServices.buscarAlternativasPorId(id);

        if (!alternativasModelOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alternativa não encontrada!");

        }

        return ResponseEntity.status(HttpStatus.OK).body(alternativasModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity < Object > deletarAlternativas(@PathVariable(value = "id") UUID id) {

        Optional < AlternativasModel > alternativasModelOptional = alternativasServices.buscarAlternativasPorId(id);

        if (!alternativasModelOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alternativa não encontrada!");
        }

        alternativasServices.deletarAlternativas(alternativasModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Alternativa deletada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity <Object> atualizarAlternativas(@PathVariable(value = "id") UUID id, @RequestBody @Valid AlternativasDTO alternativasDTO) {
        
        Optional < AlternativasModel > alternativasModelOptional = alternativasServices.buscarAlternativasPorId(id);

        if (!alternativasModelOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alternativa não encontrada!");
        }

        var alternativasModel = new AlternativasModel();

        alternativasModel.setId(alternativasModelOptional.get().getId());
        BeanUtils.copyProperties(alternativasDTO, alternativasModel);

        return ResponseEntity.status(HttpStatus.OK).body(alternativasServices.cadastrarAlternativas(alternativasModel));

    }


}
