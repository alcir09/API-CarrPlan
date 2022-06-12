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
import com.carrplan.CarrPlanAplication.DTO.QuestoesDTO;
import com.carrplan.CarrPlanAplication.models.QuestoesModel;
import com.carrplan.CarrPlanAplication.services.QuestoesServices;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/questoes")
public class QuestoesController {

    final QuestoesServices questoesServices;

    public QuestoesController(QuestoesServices questoesServices){
        this.questoesServices = questoesServices;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarQuestao(@RequestBody @Valid QuestoesDTO questoesDTO){
        
        var questoesModel = new QuestoesModel();

        BeanUtils.copyProperties(questoesDTO, questoesModel);

        return ResponseEntity.status(HttpStatus.OK).body(questoesServices.cadastrarQuestao(questoesModel));

    }

    @GetMapping
    public ResponseEntity< List<QuestoesModel>> buscarTodasQuestoes(){

        return ResponseEntity.status(HttpStatus.OK).body(questoesServices.buscarTodasQuestoes());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarQuestaoPorId(@PathVariable(value = "id") UUID id){

        Optional <QuestoesModel> questoesModelOptional = questoesServices.buscarQuestaoPorId(id);

        if (!questoesModelOptional.isPresent()) {
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Questão não encontrada!");

        }

        return ResponseEntity.status(HttpStatus.OK).body(questoesModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarDisciplina(@PathVariable(value = "id") UUID id){

        Optional <QuestoesModel> questoesModelOptional = questoesServices.buscarQuestaoPorId(id);

        if (!questoesModelOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Questão não encontrada!");
            
        }

        questoesServices.deletarQuestao(questoesModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Questão deletada com sucesso!");
    }

    @PutMapping
    public ResponseEntity<Object> atualizarQuestao(@PathVariable( value = "id") UUID id, @RequestBody @Valid QuestoesDTO questoesDTO){

        Optional <QuestoesModel> questoesModelOptional = questoesServices.buscarQuestaoPorId(id);

        if (!questoesModelOptional.isPresent()) {
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Questão não encontrada!");
        }

        var questoesModel = new QuestoesModel();

        questoesModel.setIdQuestao(questoesModelOptional.get().getIdQuestao());
        BeanUtils.copyProperties(questoesDTO, questoesModel);

        return ResponseEntity.status(HttpStatus.OK).body(questoesServices.cadastrarQuestao(questoesModel));
    }

}
