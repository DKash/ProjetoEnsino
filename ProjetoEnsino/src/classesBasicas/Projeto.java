/**
 * 
 */
package classesBasicas;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * @author Audry Martins
 *
 */
@Entity
public class Projeto
{
	// Atributos
	
	@Id @GeneratedValue
	@Column(length = 5, nullable = false)
	private Integer codigo;
	
	@Column(length = 30, nullable = false)
	private String nome;
	
	@Column(length = 255, nullable = true)
	private String descricao;
	
	@Column(length = 2, nullable = false)
	private Integer qtdAlunosProjeto;
	
	@OneToMany
	@JoinColumn(nullable = false)
	private List<Aluno> alunos;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Professor professorOrientador;
	
	//Talvez verificar se está certo, esse ou de baixo
	@OneToOne
	private Coordenador avaliadores;
	
	//Ou esse
	/*@ManyToMany
	private List<Professor> professoresAvaliadores;*/
	
	// Métodos
	
	// Gets e Sets
	/**
	 * @return the codigo
	 */
	public Integer getCodigo()
	{
		return codigo;
	}
	
	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	/**
	 * @return the descrcao
	 */
	public String getDescrcao()
	{
		return descricao;
	}
	
	/**
	 * @param descrcao
	 *            the descrcao to set
	 */
	public void setDescrcao(String descrcao)
	{
		this.descricao = descrcao;
	}
	
	/**
	 * @return the qtdAlunosProjeto
	 */
	public Integer getQtdAlunosProjeto()
	{
		return qtdAlunosProjeto;
	}
	
	/**
	 * @param qtdAlunosProjeto
	 *            the qtdAlunosProjeto to set
	 */
	public void setQtdAlunosProjeto(Integer qtdAlunosProjeto)
	{
		this.qtdAlunosProjeto = qtdAlunosProjeto;
	}
	
	/**
	 * @return the alunos
	 */
	public List<Aluno> getAlunos()
	{
		return alunos;
	}
	
	/**
	 * @param alunos
	 *            the alunos to set
	 */
	public void setAlunos(List<Aluno> alunos)
	{
		this.alunos = alunos;
	}
	
	/**
	 * @return the professorOrientador
	 */
	public Professor getProfessorOrientador()
	{
		return professorOrientador;
	}
	
	/**
	 * @param professorOrientador
	 *            the professorOrientador to set
	 */
	public void setProfessorOrientador(Professor professorOrientador)
	{
		this.professorOrientador = professorOrientador;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao()
	{
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	/**
	 * @return the avaliadores
	 */
	public Coordenador getAvaliadores()
	{
		return avaliadores;
	}

	/**
	 * @param avaliadores the avaliadores to set
	 */
	public void setAvaliadores(Coordenador avaliadores)
	{
		this.avaliadores = avaliadores;
	}
	
	/**
	 * @return the professoresAvaliadores
	 *//*
	public List<Professor> getProfessoresAvaliadores()
	{
		return professoresAvaliadores;
	}
	
	*//**
	 * @param professoresAvaliadores
	 *            the professoresAvaliadores to set
	 *//*
	public void setProfessoresAvaliadores(List<Professor> professoresAvaliadores)
	{
		this.professoresAvaliadores = professoresAvaliadores;
	}*/
}