package spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.entidade.Instituicao;

public interface InstituicaoRepositorio extends JpaRepository<Instituicao, Long> {

}
