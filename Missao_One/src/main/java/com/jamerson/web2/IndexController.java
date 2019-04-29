package com.jamerson.web2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/missao")
	public String index() {
		return "index";
	}
	@GetMapping("GeraSenha")
	public String Index() {
		return "gerarsenha";
	}
	@GetMapping("VSenha")
	public String INDEX() {
		return "VSenha";
	}
	@GetMapping("UpSenha")
	public String IndeX() {
		return "UpSenha";
	}
	@GetMapping("DelSenha")
	public String IndEx() {
		return "DelSenha";
	}
	@GetMapping("PSenha")
	public String INdEx() {
		return "PSenha";
	}
}
