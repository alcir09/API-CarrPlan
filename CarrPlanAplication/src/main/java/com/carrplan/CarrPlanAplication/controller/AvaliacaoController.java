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

import com.carrplan.CarrPlanAplication.DTO.AvaliacoesDTO;
import com.carrplan.CarrPlanAplication.models.AvaliacaoModel;
import com.carrplan.CarrPlanAplication.services.AvalicaoServices;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    final AvalicaoServices avaliacaoServices;

    public AvaliacaoController(AvalicaoServices avaliacaoServices){
        this.avaliacaoServices = avaliacaoServices;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarAvaliacao(@RequestBody @Valid AvaliacoesDTO avaliacaoDTO){
        
        var avaliacaoModel = new AvaliacaoModel();

        BeanUtils.copyProperties(avaliacaoDTO, avaliacaoModel);

        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoServices.cadastrarAvaliacao(avaliacaoModel));

    }

    @GetMapping
    public ResponseEntity< List<AvaliacaoModel>> buscarTodasAvaliacoes(){

        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoServices.buscarTodasAvaliacoes());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarAvaliacaoPorId(@PathVariable(value = "id") UUID id){

        Optional <AvaliacaoModel> questoesModelOptional = avaliacaoServices.buscarAvaliacaoPorId(id);

        if (!questoesModelOptional.isPresent()) {
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avalicação não encontrada!");

        }

        return ResponseEntity.status(HttpStatus.OK).body(questoesModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAvaliacao(@PathVariable(value = "id") UUID id){

        Optional <AvaliacaoModel> questoesModelOptional = avaliacaoServices.buscarAvaliacaoPorId(id);

        if (!questoesModelOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avalicação não encontrada!");
            
        }

        avaliacaoServices.deletarAvaliacao(questoesModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Avalicação deletada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAvaliacao(@PathVariable( value = "id") UUID id, @RequestBody @Valid AvaliacoesDTO avaliacoesDTO){

        Optional <AvaliacaoModel> avaliacaoModelOptional = avaliacaoServices.buscarAvaliacaoPorId(id);

        if (!avaliacaoModelOptional.isPresent()) {
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avalicação não encontrada!");
        }

        var avaliacaoModel = new AvaliacaoModel();

        avaliacaoModel.setId_avaliacao(avaliacaoModelOptional.get().getId_avaliacao());
        BeanUtils.copyProperties(avaliacoesDTO, avaliacaoModel);

        return ResponseEntity.status(HttpStatus.OK).body(avaliacaoServices.cadastrarAvaliacao(avaliacaoModel));
    }
    
}
