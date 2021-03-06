package spring.entidade;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "instituicoes")
public class Instituicao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30)
	private String nome;
	
	@Column(length = 100)
	private String endereco;

	// o Set<> não permite elementos duplicados
	// por isso, foi utilizado ao invés de lista
	@OneToMany(mappedBy = "instituicao")
	private Set<Aluno> alunos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
}
