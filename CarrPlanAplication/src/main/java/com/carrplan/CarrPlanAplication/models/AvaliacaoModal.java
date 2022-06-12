package com.carrplan.CarrPlanAplication.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "AVALIAÇÃO")
public class AvaliacaoModal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @JoinColumn(name = "id_disciplina")
    private DisciplinaModel disciplinaModel;

    @JoinColumn(name = "id_usuario")
    private UsuarioModal UsuarioModal;

    private double nota;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DisciplinaModel getDisciplinaModel() {
        return disciplinaModel;
    }

    public void setDisciplinaModel(DisciplinaModel disciplinaModel) {
        this.disciplinaModel = disciplinaModel;
    }

    public UsuarioModal getUsuarioModal() {
        return UsuarioModal;
    }

    public void setUsuarioModal(UsuarioModal usuarioModal) {
        UsuarioModal = usuarioModal;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }



}
