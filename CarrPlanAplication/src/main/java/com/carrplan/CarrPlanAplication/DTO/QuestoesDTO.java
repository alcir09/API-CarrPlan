package com.carrplan.CarrPlanAplication.DTO;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
public class QuestoesDTO{
    
    @NotNull
    private UUID idAvaliacao;

    @NotBlank
    private String texto;

    public UUID getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(UUID idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
