package com.carrplan.CarrPlanAplication.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.carrplan.CarrPlanAplication.Repository.AlternativasRepository;
import com.carrplan.CarrPlanAplication.models.AlternativasModel;

@Service
public class AlternativasServices {
    
    final AlternativasRepository alternativasRepository;

    public AlternativasServices (AlternativasRepository alternativasRepository){

        this.alternativasRepository = alternativasRepository;
    }

    @Transactional
    public Object cadastrarAlternativas(AlternativasModel alternativasModel){

        return alternativasRepository.save(alternativasModel);
    }

    public List<AlternativasModel> buscarTodasAlternativas(){
        return alternativasRepository.findAll();
    }

    public Optional<AlternativasModel> buscarAlternativasPorId(UUID id){
        return alternativasRepository.findById(id);
    }

    @Transactional
    public void deletarAlternativas(AlternativasModel alternativasModel){
       alternativasRepository.delete(alternativasModel);
    }
}
