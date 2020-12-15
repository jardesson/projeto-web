package com.dev.domain.dto;

import java.io.Serializable;
import java.util.List;

import com.dev.domain.Professor;
import com.dev.domain.Aluno;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProjetoUpdateDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;
	private String nome;
    private String descricao;
    private Professor coordenador;
    private List<Aluno> alunos;
}