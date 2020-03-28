package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.entidade.Instituicao;
import spring.repositorio.InstituicaoRepositorio;

@Controller
@RequestMapping("/instituicoes")
public class InstituicaoController {

	@Autowired
	private InstituicaoRepositorio repositorio;
	
	// -----------------------------------------------------------------------------
	// 						** LISTAR
	// -----------------------------------------------------------------------------
	
	@GetMapping("/listar")
	public ModelAndView index() { // instituicao/lista é pasta/arquivo.html
		ModelAndView model = new ModelAndView("instituicao/lista");
		List<Instituicao> instituicoes = repositorio.findAll();
		model.addObject("instituicoes", instituicoes);
		return model;
	}
	
	// -----------------------------------------------------------------------------
	// 						** INSERIR
	// -----------------------------------------------------------------------------
	
	// carrega a página de inserção
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView model = new ModelAndView("instituicao/inserir");
		model.addObject("inserirInstituicao", new Instituicao());
		return model; // envia objeto instituicao para a view
	}
	
	// salva os dados quando o formulário for submetido
	@PostMapping("/inserir")
	public String inserir(Instituicao instituicao) {
		repositorio.save(instituicao);
		// instituicoes/listar => controller/action
		return "redirect:/instituicoes/listar";
	}
	
	// -----------------------------------------------------------------------------
	// 						** EDITAR
	// -----------------------------------------------------------------------------
	
	// carrega página para edição
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Instituicao instituicao = repositorio.findById(id).orElse(null);
		ModelAndView model = new ModelAndView("instituicao/editar"); // pasta/arquivo
		model.addObject("editarInstituicao", instituicao);
		return model;
	}
	
	// salva os dados quando o formulário for submetido
	@PostMapping("/editar")
	public String editar(Instituicao instituicao) {
		repositorio.save(instituicao);
		// instituicoes/listar => controller/action
		return "redirect:/instituicoes/listar";
	}
	
	// -----------------------------------------------------------------------------
	// 						** EXCLUIR
	// -----------------------------------------------------------------------------
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		repositorio.deleteById(id);
		// instituicoes/listar => controller/action
		return "redirect:/instituicoes/listar";
	}
}
