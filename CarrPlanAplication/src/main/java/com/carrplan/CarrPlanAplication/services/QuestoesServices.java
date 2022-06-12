package com.carrplan.CarrPlanAplication.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.carrplan.CarrPlanAplication.Repository.QuestoesRepository;
import com.carrplan.CarrPlanAplication.models.QuestoesModel;

@Service
public class QuestoesServices {

    final QuestoesRepository questoesRepository;

    public QuestoesServices(QuestoesRepository questoesRepository){
        this.questoesRepository = questoesRepository;
    }
    
    @Transactional
    public Object cadastrarQuestao(QuestoesModel questoesModel){
        return questoesRepository.save(questoesModel);
    }

    public List<QuestoesModel> buscarTodasQuestoes(){
        return questoesRepository.findAll();
    }

    public Optional<QuestoesModel> buscarQuestaoPorId(UUID id){
        return questoesRepository.findById(id);
    }

    public void deletarQuestao(QuestoesModel questoesModel){
        questoesRepository.delete(questoesModel);
    }
}
