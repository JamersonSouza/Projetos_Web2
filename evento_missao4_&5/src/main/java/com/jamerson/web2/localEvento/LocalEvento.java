package com.jamerson.web2.localEvento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class LocalEvento {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_local;
	@NotNull(message="Local do evento é obrigatório.")
	private String nome;
	private String endereco;
	private String linkMaps;
	private Integer capacidade;
	@Column(name = "tb_TipoLocal", nullable = false, insertable = true, updatable = true)
	private String TipoLocal;
	
	
	public Long getId_local() {
		return id_local;
	}
	public void setId_local(Long id_local) {
		this.id_local = id_local;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getLinkMaps() {
		return linkMaps;
	}
	public void setLinkMaps(String linkMaps) {
		this.linkMaps = linkMaps;
	}
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	
	
	
	public String getTipoLocal() {
		return TipoLocal;
	}
	public void setTipoLocal(String tipoLocal) {
		TipoLocal = tipoLocal;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}
	
}
