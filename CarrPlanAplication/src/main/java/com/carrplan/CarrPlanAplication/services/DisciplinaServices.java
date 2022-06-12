package com.carrplan.CarrPlanAplication.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.carrplan.CarrPlanAplication.Repository.DisciplinaRepository;
import com.carrplan.CarrPlanAplication.models.DisciplinaModel;

@Service
public class DisciplinaServices {

    final DisciplinaRepository disciplinaRepository;

    public DisciplinaServices (DisciplinaRepository disciplinaRepository){

        this.disciplinaRepository = disciplinaRepository;
    }

    @Transactional
    public Object cadastrarDisciplna(DisciplinaModel disciplinaModel){

        return disciplinaRepository.save(disciplinaModel);
    }

    public List<DisciplinaModel> buscarTodasDisciplinas(){
        return disciplinaRepository.findAll();
    }

    public Optional<DisciplinaModel> buscarDisciplinaPorId(UUID id){
        return disciplinaRepository.findById(id);
    }

    @Transactional
    public void deletarDisciplina(DisciplinaModel disciplinaModel){
        disciplinaRepository.delete(disciplinaModel);
    }

}
