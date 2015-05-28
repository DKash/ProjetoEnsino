/**
 * 
 */
package classesBasicas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Audry Martins
 *
 */
@NamedQueries({
		@NamedQuery(name = "Projeto.findAllActives" , query = "SELECT p FROM Projeto p WHERE p.situacao =:situacao"),
		@NamedQuery(name = "Projeto.findByName", query = "SELECT proj FROM Projeto proj WHERE proj.nome LIKE :nome"),
		@NamedQuery(name = "Projeto.findNotesByProjetoAvaliador", query = "SELECT p FROM Projeto p WHERE :avaliador "
			+ "member of p.professoresAvaliadores and p = :projeto")})
@Entity
public class Projeto
{
	// Atributos
	@Id
	@GeneratedValue
	@Column(length = 5, nullable = false)
	private Integer codigo;
	
	
	@Column(length = 30, nullable = false)
	private String nome;
	
	
	@Column(length = 255, nullable = true)
	private String descricao;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Aluno> alunos;
	
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Professor professorOrientador;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Professor> professoresAvaliadores;
	
	
	@Enumerated(EnumType.STRING)
	private Resultado resultado;
	
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	// Construtores
	public Projeto()
	{
		super();
		
		this.nome = "";
		this.descricao = "";
		this.alunos = new ArrayList<Aluno>();
		this.professorOrientador = new Professor();
		this.professoresAvaliadores = new ArrayList<Professor>();
		this.resultado = null;
		this.situacao = Situacao.ATIVO;
	}
	
	/**
	 * @param codigo
	 * @param nome
	 * @param descricao
	 * @param qtdAlunosProjeto
	 * @param alunos
	 * @param professorOrientador
	 * @param professoresAvaliadores
	 * @param resultado
	 */
	public Projeto(Integer codigo, String nome, String descricao,
		List<Aluno> alunos, Professor professorOrientador,
		List<Professor> professoresAvaliadores, Resultado resultado,
		Situacao situacao)
	{
		super();
		
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.alunos = alunos;
		this.professorOrientador = professorOrientador;
		this.professoresAvaliadores = professoresAvaliadores;
		this.resultado = resultado;
		this.situacao = situacao;
	}
	
	// Métodos
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if(nome == null)
		{
			if(other.nome != null)
				return false;
		}
		else
			if(!nome.equals(other.nome))
				return false;
		return true;
	}	
	
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
	 * @return the descricao
	 */
	public String getDescricao()
	{
		return descricao;
	}
	
	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
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
	 * @return the professoresAvaliadores
	 */
	public List<Professor> getProfessoresAvaliadores()
	{
		return professoresAvaliadores;
	}
	
	/**
	 * @param professoresAvaliadores
	 *            the professoresAvaliadores to set
	 */
	public void setProfessoresAvaliadores(List<Professor> professoresAvaliadores)
	{
		this.professoresAvaliadores = professoresAvaliadores;
	}
	
	/**
	 * @return the resultado
	 */
	public Resultado getResultado()
	{
		return resultado;
	}
	
	/**
	 * @param resultado
	 *            the resultado to set
	 */
	public void setResultado(Resultado resultado)
	{
		this.resultado = resultado;
	}
	
	/**
	 * @return the situacao
	 */
	public Situacao getSituacao()
	{
		return situacao;
	}
	
	/**
	 * @param situacao
	 *            the situacao to set
	 */
	public void setSituacao(Situacao situacao)
	{
		this.situacao = situacao;
	}
}