package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.repositorio.AlunoRepositorio;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepositorio repositorio;
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView model = new ModelAndView("aluno/listar-alunos");
		model.addObject("alunosView", repositorio.findAll());
		return model;
	}
}
