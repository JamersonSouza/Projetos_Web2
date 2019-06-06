package com.jamerson.web2;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationFormat;
import org.springframework.format.annotation.DateTimeFormat;

import com.jamerson.web2.localEvento.LocalEvento;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_evento;
	@NotBlank(message = "Campo não pode estar em Branco.")
	private String nome_evento;
	private String descricao_evento;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Future(message="Data anterior à data atual não é permitida")
	private Date data_realizacao;
	@Range(min = 11, message = "Quantidade deve ser Maior que 10!")
	private Integer qtdMaxPessoas;
	private String nome_responsavel;
	private String telefone_responsavel;
	@NotNull
	@DateTimeFormat(pattern = "HH:mm")
	//NÃO CONSEGUI ENCONTRAR ANOTAÇÃO PARA FAZER A VALIDAÇÃO
	// TENTEI ALGUMAS MAIS DAVA ERRO DEVIDO O TIPO DO ATRIBUTO SER DATE.
	private Date duracao_horas;
	
	@OneToOne
	
	private LocalEvento localevento;
	
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
	
	
	public LocalEvento getLocalevento() {
		return localevento;
	}
	public void setLocalevento(LocalEvento localevento) {
		this.localevento = localevento;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome_evento + id_evento;
	}

}
