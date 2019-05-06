package com.jamerson.web2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_evento;
	@NotBlank
	private String nome_evento;
	@NotBlank
	private String descricao_evento;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date data_realizacao;
	private Integer qtdMaxPessoas;
	@NotBlank
	private String nome_responsavel;
	@NotBlank
	private String telefone_responsavel;
	@DateTimeFormat(pattern = "HH:mm")
	@NotNull
	private Date duracao_horas;
	
	
	public Date getData_realizacao() {
		return data_realizacao;
	}
	public void setData_realizacao(Date data_realizacao) {
		this.data_realizacao = data_realizacao;
	}
	public Integer getQtdMaxPessoas() {
		return qtdMaxPessoas;
	}
	public void setQtdMaxPessoas(Integer qtdMaxPessoas) {
		this.qtdMaxPessoas = qtdMaxPessoas;
	}
	
	public Long getId_evento() {
		return id_evento;
	}
	public void setId_evento(Long id_evento) {
		this.id_evento = id_evento;
	}
	public String getNome_evento() {
		return nome_evento;
	}
	public void setNome_evento(String nome_evento) {
		this.nome_evento = nome_evento;
	}
	public String getDescricao_evento() {
		return descricao_evento;
	}
	public void setDescricao_evento(String descricao_evento) {
		this.descricao_evento = descricao_evento;
	}
	public String getNome_responsavel() {
		return nome_responsavel;
	}
	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}
	public String getTelefone_responsavel() {
		return telefone_responsavel;
	}
	public void setTelefone_responsavel(String telefone_responsavel) {
		this.telefone_responsavel = telefone_responsavel;
	}
	public Date getDuracao_horas() {
		return duracao_horas;
	}
	public void setDuracao_horas(Date duracao_horas) {
		this.duracao_horas = duracao_horas;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome_evento + id_evento;
	}

}
