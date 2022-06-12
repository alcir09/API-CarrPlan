package com.carrplan.CarrPlanAplication.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AVALIACAO")
public class AvaliacaoModel {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "ID_AVALIACAO")
    private UUID id_avaliacao;

    @Column(name = "ID_DISCIPLINA")
    private Integer idDisciplina;

    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Column(name = "NOTA")
    private double nota;

    public UUID getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(UUID id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

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
