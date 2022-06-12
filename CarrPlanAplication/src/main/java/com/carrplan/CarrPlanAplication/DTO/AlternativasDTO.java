package com.carrplan.CarrPlanAplication.DTO;

import javax.validation.constraints.NotBlank;

public class AlternativasDTO {


    @NotBlank
    private Integer idQuestao;
    
    @NotBlank
    private String opcao;

    @NotBlank
    private String resposta;

    @NotBlank
    private Boolean questao_correta;

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Boolean getQuestao_correta() {
        return questao_correta;
    }

    public void setQuestao_correta(Boolean questao_correta) {
        this.questao_correta = questao_correta;
    }


    
    
}
