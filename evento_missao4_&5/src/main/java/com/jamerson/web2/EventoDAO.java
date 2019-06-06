package com.jamerson.web2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EventoDAO extends JpaRepository<Evento, Long> {
	

	// NAO FOI FEITO O METODO DE PESQUISA POIS O STS SEMPRE RECLAMAVA COM ESSE ERRO
	//	Invalid derived query! No property nome found for type Evento!
	public List<Evento> findByNomeContainingIgnoreCase(String nomePesquisa);
	
//	E CASO TENTASE USAR ATRAVES DO @QUERY
//	Multiple markers at this line
//	- Syntax error, insert "EnumBody" to complete 
//	 EnumDeclaration
//	- Syntax error, insert "enum Identifier" to complete 
//	 EnumHeader

//	POR ESSES ERROS NÃO CONSEGUI FINALIZAR A PESQUISA.
	 
	@Query
	("select p from evento p where UPPER(p.nome_evento) like UPPER(CONCAT('%',:nomePesquisa, '%')) order by p.nome_evento")
	
}
