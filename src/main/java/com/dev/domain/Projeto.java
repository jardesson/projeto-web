package com.dev.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "projetos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Projeto implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, max=50, message="O tamanho deve ser entre 5 e 50 caracteres.")
    private String nome;

    @NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, max=50, message="O tamanho deve ser entre 5 e 50 caracteres.")
    private String descricao;

    @ManyToOne
    @JoinColumn(name="coordenador_id")
    private Professor coordenador;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "projeto")
    private List<Aluno> alunos = new ArrayList<>();

    public void addAluno(Aluno a){

        alunos.add(a);

    }

    
}