package com.carrplan.CarrPlanAplication.DTO;

import javax.validation.constraints.NotNull;

public class AvaliacoesDTO {

    @NotNull
    private Integer idDisciplina;

    @NotNull
    private Integer idUsuario;

    @NotNull
    private double nota;

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }


    
}
