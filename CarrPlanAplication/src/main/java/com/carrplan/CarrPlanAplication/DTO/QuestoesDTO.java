package com.carrplan.CarrPlanAplication.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class QuestoesDTO{
    
    @NotNull
    private Integer idAvaliacao;

    @NotBlank
    private String texto;

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
