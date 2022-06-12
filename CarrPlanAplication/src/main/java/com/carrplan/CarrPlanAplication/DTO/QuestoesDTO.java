package com.carrplan.CarrPlanAplication.DTO;

import javax.validation.constraints.NotBlank;

import com.carrplan.CarrPlanAplication.models.AvaliacaoModal;

public class QuestoesDTO{
    
    @NotBlank
    private AvaliacaoModal avaliacaoModal;

    @NotBlank
    private String texto;

    public AvaliacaoModal getAvaliacaoModal() {
        return avaliacaoModal;
    }

    public void setAvaliacaoModal(AvaliacaoModal avaliacaoModal) {
        this.avaliacaoModal = avaliacaoModal;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
