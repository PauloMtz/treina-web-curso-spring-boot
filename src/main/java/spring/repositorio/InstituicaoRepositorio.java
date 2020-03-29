package spring.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.entidade.Instituicao;

public interface InstituicaoRepositorio extends JpaRepository<Instituicao, Long> {

	// pesquisa utilizando 'like' --> findByAtributoContaining(tipo atributo)
	// o Spring Data fará a implementação do método de pesquisa
	List<Instituicao> findByNomeContaining(String nome);
}
