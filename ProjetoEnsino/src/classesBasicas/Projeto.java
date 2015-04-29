/**
 * 
 */
package classesBasicas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


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
	
	@ManyToMany
	@JoinColumn(nullable = false)
	private List<Aluno> alunos;
	
	@ManyToMany
	@JoinColumn(nullable = false)
	private Professor professorOrientador;
	
	@ManyToMany
	@JoinColumn(nullable = false)
	private List<Coordenador> professoresAvaliadores;
	
	@ManyToMany
	@JoinColumn(nullable = false)
	private List<Nota> notas;
	
	@Enumerated
	private Resultado resultado;
	
	//Construtores
	
	public Projeto()
	{
		super();
		
		this.nome = "";
		this.descricao ="";
		this.alunos = new ArrayList<Aluno>();
		this.professorOrientador = new Professor();
		this.professoresAvaliadores = new ArrayList<Coordenador>();
		this.notas = new ArrayList<Nota>();
		this.resultado = null;
	}
	
	/**
	 * @param codigo
	 * @param nome
	 * @param descricao
	 * @param qtdAlunosProjeto
	 * @param alunos
	 * @param professorOrientador
	 * @param professoresAvaliadores
	 * @param notas
	 * @param resultado
	 */
	public Projeto(Integer codigo, String nome, String descricao,
		Integer qtdAlunosProjeto, List<Aluno> alunos,
		Professor professorOrientador, List<Coordenador> professoresAvaliadores,
		List<Nota> notas, Resultado resultado)
	{
		super();
		
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdAlunosProjeto = qtdAlunosProjeto;
		this.alunos = alunos;
		this.professorOrientador = professorOrientador;
		this.professoresAvaliadores = professoresAvaliadores;
		this.notas = notas;
		this.resultado = resultado;
	}

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
	 * @param codigo the codigo to set
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
	 * @param nome the nome to set
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
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
	 * @return the qtdAlunosProjeto
	 */
	public Integer getQtdAlunosProjeto()
	{
		return qtdAlunosProjeto;
	}

	/**
	 * @param qtdAlunosProjeto the qtdAlunosProjeto to set
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
	 * @param alunos the alunos to set
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
	 * @param professorOrientador the professorOrientador to set
	 */
	public void setProfessorOrientador(Professor professorOrientador)
	{
		this.professorOrientador = professorOrientador;
	}

	/**
	 * @return the professoresAvaliadores
	 */
	public List<Coordenador> getProfessoresAvaliadores()
	{
		return professoresAvaliadores;
	}

	/**
	 * @param professoresAvaliadores the professoresAvaliadores to set
	 */
	public void setProfessoresAvaliadores(List<Coordenador> professoresAvaliadores)
	{
		this.professoresAvaliadores = professoresAvaliadores;
	}

	/**
	 * @return the notas
	 */
	public List<Nota> getNotas()
	{
		return notas;
	}

	/**
	 * @param notas the notas to set
	 */
	public void setNotas(List<Nota> notas)
	{
		this.notas = notas;
	}

	/**
	 * @return the resultado
	 */
	public Resultado getResultado()
	{
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Resultado resultado)
	{
		this.resultado = resultado;
	}
}