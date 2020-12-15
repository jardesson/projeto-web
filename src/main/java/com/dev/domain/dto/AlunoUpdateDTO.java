package com.dev.domain.dto;

import java.io.Serializable;

import com.dev.domain.Projeto;

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
public class AlunoUpdateDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String matricula;
    private String nome;
    private String email;
	private String password;
	private String curso;
    private String papel;
    private Projeto projeto;
}