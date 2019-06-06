package com.jamerson.web2.localEvento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LocalEventoController {

	@Autowired
	private LocalEventoDAO localeventoRep;
	
	
	//view para a page de cadastro localEvento
	@GetMapping("/cadastrarEvento")
	public ModelAndView telaLocalEvento() {
		ModelAndView mv = new ModelAndView("cadastrarEvento");
		mv.addObject("lista", localeventoRep.findAll());
		return mv;		
	}
	
	@GetMapping("CadastroEventoLocalForm")
	public ModelAndView CadastroLocalForm() {
		ModelAndView mv = new ModelAndView("CadastroEventoLocalForm");
		mv.addObject("localEvento", new LocalEvento());
		return mv;
	}
	
	@PostMapping("/addLocal")
	public ModelAndView InserirLocal(@ModelAttribute LocalEvento local) {
		System.out.println(local);
		localeventoRep.save(local);
		ModelAndView mv = new ModelAndView("CadastroEventoLocalForm");
		mv.addObject("msg", "Local Inserido Com Sucesso!");
		return mv;
	}
	
//	Listando os eventos
	public ModelAndView listarEventosLocais() {
		ModelAndView mv = new ModelAndView("cadastrarEvento");
		mv.addObject("lista", localeventoRep.findAll());
		return mv;
	}
	
	//remover Evento
	@GetMapping("/removerLocal")
	public ModelAndView removerLocal(@RequestParam Long id_local) {
		localeventoRep.deleteById(id_local);
		return listarEventosLocais();
	}
	
//	Editar Local
	@GetMapping("/editarLocal")
	public ModelAndView editarLocal(@RequestParam Long id_local) {
		ModelAndView mv = new ModelAndView("CadastroEventoLocalForm");
		mv.addObject("localEvento", localeventoRep.findById(id_local));
		localeventoRep.deleteById(id_local); 
		// Ao editar o id é gerado o editavel e o antigo continua
		// usando o deleteById ele remove o antigo e adiciona um novo
		return mv;
	}
	
}
