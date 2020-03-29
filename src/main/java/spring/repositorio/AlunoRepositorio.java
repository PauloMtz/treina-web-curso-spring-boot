package spring.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.entidade.Aluno;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {

}
