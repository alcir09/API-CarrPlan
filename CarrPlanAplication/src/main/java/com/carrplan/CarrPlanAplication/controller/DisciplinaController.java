package com.carrplan.CarrPlanAplication.controller;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import com.carrplan.CarrPlanAplication.DTO.DisciplinaDTO;
import com.carrplan.CarrPlanAplication.models.DisciplinaModel;
import com.carrplan.CarrPlanAplication.services.DisciplinaServices;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/disciplina")
public class DisciplinaController {

    final DisciplinaServices disciplinaServices;

    public DisciplinaController(DisciplinaServices disciplinaServices) {
        this.disciplinaServices = disciplinaServices;
    }

    @PostMapping
    public ResponseEntity < Object > cadastrarDisciplina(@RequestBody @Valid DisciplinaDTO disciplinaDTO) {

        var disciplinaModel = new DisciplinaModel();

        BeanUtils.copyProperties(disciplinaDTO, disciplinaModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaServices.cadastrarDisciplna(disciplinaModel));
    }

    @GetMapping
    public ResponseEntity < List < DisciplinaModel >> buscarTodasDisciplinas() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaServices.buscarTodasDisciplinas());
    }

    @GetMapping("/{id}")
    public ResponseEntity < Object > buscarDisciplinaPorId(@PathVariable(value = "id") UUID id) {

        Optional < DisciplinaModel > discplinaModelOptional = disciplinaServices.buscarDisciplinaPorId(id);

        if (!discplinaModelOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disciplina não encontrada!");

        }

        return ResponseEntity.status(HttpStatus.OK).body(discplinaModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity < Object > deletarDisciplina(@PathVariable(value = "id") UUID id) {

        Optional < DisciplinaModel > disciplinaModelOptional = disciplinaServices.buscarDisciplinaPorId(id);

        if (!disciplinaModelOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disciplina não encontrada!");
        }

        disciplinaServices.deletarDisciplina(disciplinaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity <Object> atualizarDisciplina(@PathVariable(value = "id") UUID id, @RequestBody @Valid DisciplinaDTO disciplinaDTO) {
        
        Optional < DisciplinaModel > disciplinaModelOptional = disciplinaServices.buscarDisciplinaPorId(id);

        if (!disciplinaModelOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disciplina não encontrada!");
        }

        var disciplinaModel = new DisciplinaModel();

        disciplinaModel.setId(disciplinaModelOptional.get().getId());
        BeanUtils.copyProperties(disciplinaDTO, disciplinaModel);

        return ResponseEntity.status(HttpStatus.OK).body(disciplinaServices.cadastrarDisciplna(disciplinaModel));

    }

}