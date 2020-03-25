package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TesteController {

	@RequestMapping("/teste")
	public String hello(Model model) {
		model.addAttribute("mensagem", "Testando aplicação com SpringBoot!");
		return "teste";
	}
}
