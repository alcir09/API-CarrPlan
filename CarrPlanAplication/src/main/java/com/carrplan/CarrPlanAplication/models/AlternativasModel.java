package com.carrplan.CarrPlanAplication.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALTERNATIVAS")
public class AlternativasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ALTERNATIVAS")
    private UUID id;

    @Column(name = "ID_QUESTAO", unique = true)
    private Integer idQuestao;

    @Column(name = "OPCAO", length = 1)
    private String opcao;

    @Column(name = "RESPOSTA")
    private String resposta;

    @Column(name = "QUESTAO_CORRETA")
    private Boolean questao_correta;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
