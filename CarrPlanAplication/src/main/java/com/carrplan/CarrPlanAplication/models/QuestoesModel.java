package com.carrplan.CarrPlanAplication.models;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTOES")
public class QuestoesModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "ID_QUESTAO")
    private UUID idQuestao;

    @Column(name = "ID_AVALIACAO", unique = true)
    private Integer idAvaliacao;

    @Column(name = "TEXTO", length = 200)
    private String texto;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public UUID getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(UUID idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

   

    
    
}
