package com.jamerson.web2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class eventoController {
	
	@Autowired
	private EventoDAO eventoRap;
	
//	metodo de listar ja sendo implementado direto na view
	@GetMapping("/web2")
	public ModelAndView exibirEvento() {
		ModelAndView mv = new ModelAndView("events");
		mv.addObject("lista", eventoRap.findAll());
		mv.addObject("evento", new Evento());
		return mv;
	}
	
	//view CadastrodoEvento
	@GetMapping("formCadastro")
	public ModelAndView telaCadastro() {
		ModelAndView mv = new ModelAndView("formCadastro");
		mv.addObject("evento", new Evento());
		return mv;
	}
	//capturando os dados e enviando pro bdEventoWeb2
	@PostMapping("/addEvento")
	public ModelAndView addEvento(@ModelAttribute Evento evento) {
		System.out.println(evento);
		eventoRap.save(evento);
		ModelAndView mv = new ModelAndView("formCadastro");
		mv.addObject("mensagem", "Evento Inserido Com Sucesso!");
		return mv;
		
	}

	@GetMapping("/editarEvento")
	public ModelAndView editarEvento(@RequestParam Long id_evento) {
		ModelAndView mv = new ModelAndView("formCadastro");
		mv.addObject("evento", eventoRap.findById(id_evento));
		eventoRap.deleteById(id_evento); // Ao editar o id é gerado o editavel e o antigo continua
											// usando o deleteById ele remove o antigo e adiciona um novo
		return mv;
	}
	
	@GetMapping("/removerEvento")
	public ModelAndView removerEvento(@RequestParam Long id_evento) {
		eventoRap.deleteById(id_evento);
		return listarEvento();
	}
	public ModelAndView listarEvento() {
		ModelAndView mv = new ModelAndView("events");
		mv.addObject("lista", eventoRap.findAll());
		return mv;
	}
}
