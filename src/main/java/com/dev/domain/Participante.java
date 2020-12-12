package com.dev.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Entity(name = "participantes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Participante {

    private Aluno aluno;
    private String papel;

    //@ManyToOne
    //@JoinColumn(name = "projeto_id")
    private Projeto projeto;
}