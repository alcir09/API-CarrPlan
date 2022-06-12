package com.carrplan.CarrPlanAplication.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.carrplan.CarrPlanAplication.Repository.AvaliacaoRepository;
import com.carrplan.CarrPlanAplication.models.AvaliacaoModel;

@Service
public class AvalicaoServices {

    final AvaliacaoRepository avaliacaoRepository;

    public AvalicaoServices(AvaliacaoRepository avaliacaoRepository){
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @Transactional
    public Object cadastrarAvaliacao(AvaliacaoModel avaliacaoModel){
        return avaliacaoRepository.save(avaliacaoModel);
    }

    public List<AvaliacaoModel> buscarTodasAvaliacoes(){
        return avaliacaoRepository.findAll();
    }

    public Optional<AvaliacaoModel> buscarAvaliacaoPorId(UUID id){
        return avaliacaoRepository.findById(id);
    }

    public void deletarAvaliacao(AvaliacaoModel avaliacaoModel){
        avaliacaoRepository.delete(avaliacaoModel);
    }
    
}
