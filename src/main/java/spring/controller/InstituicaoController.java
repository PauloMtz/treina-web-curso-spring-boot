package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.entidade.Instituicao;
import spring.repositorio.InstituicaoRepositorio;

@Controller
@RequestMapping("/instituicoes")
public class InstituicaoController {

	@Autowired
	private InstituicaoRepositorio repositorio;
	
	@GetMapping("/lista")
	public ModelAndView index() { // instituicao/lista é pasta/arquivo.html
		ModelAndView model = new ModelAndView("instituicao/lista");
		List<Instituicao> instituicoes = repositorio.findAll();
		model.addObject("instituicoes", instituicoes);
		return model;
	}
}
