package com.carrplan.CarrPlanAplication.DTO;

import javax.validation.constraints.NotBlank;

public class DisciplinaDTO {
    
    @NotBlank(message = "Preencher campo Obrigatório!")
    private String nome;

    @NotBlank(message = "Preencher campo Obrigatório!")
    private String categoria;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
}
