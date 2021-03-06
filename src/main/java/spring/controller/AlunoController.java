package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.entidade.Aluno;
import spring.entidade.Instituicao;
import spring.repositorio.AlunoRepositorio;
import spring.repositorio.InstituicaoRepositorio;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepositorio repositorio;
	
	@Autowired
	private InstituicaoRepositorio instRepositorio;
	
	// -----------------------------------------------------------------------------
	// 						** LISTAR
	// -----------------------------------------------------------------------------
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView model = new ModelAndView("aluno/listar-alunos");
		model.addObject("alunosView", repositorio.findAll());
		return model;
	}
	
	// -----------------------------------------------------------------------------
	// 						** INSERIR
	// -----------------------------------------------------------------------------
	
	// carrega a página de inserção
	@GetMapping("/inserir")
	public ModelAndView inserir() {
		ModelAndView model = new ModelAndView("aluno/inserir-aluno");
		Aluno aluno = new Aluno();
		aluno.setInstituicao(new Instituicao());
		model.addObject("inserirAluno", aluno);
		model.addObject("instituicoesView", instRepositorio.findAll());
		return model; // envia objeto instituicao para a view
	}
	
	// salva os dados quando o formulário for submetido
	@PostMapping("/inserir")
	public String inserir(Aluno aluno) {
		repositorio.save(aluno);
		// alunos/listar => controller/action
		return "redirect:/alunos/listar";
	}
	
	// -----------------------------------------------------------------------------
	// 						** EDITAR
	// -----------------------------------------------------------------------------
	
	// carrega página para edição
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		Aluno aluno = repositorio.findById(id).orElse(null);
		ModelAndView model = new ModelAndView("aluno/editar-aluno");
		model.addObject("editarAluno", aluno);
		model.addObject("instituicoesAdd", instRepositorio.findAll());
		return model;
	}
	
	// salva os dados quando o formulário for submetido
	@PostMapping("/editar")
	public String editar(Aluno aluno) {
		repositorio.save(aluno);
		// alunos/listar => controller/action
		return "redirect:/alunos/listar";
	}
	
	// -----------------------------------------------------------------------------
	// 						** EXCLUIR
	// -----------------------------------------------------------------------------
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		repositorio.deleteById(id);
		// alunos/listar => controller/action
		return "redirect:/alunos/listar";
	}
}
