/**
 * 
 */
package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Audry Martins
 *
 */
@NamedQueries({
		@NamedQuery(name = "Nota.findNotesByProject", query = "SELECT n FROM Nota n WHERE n.projeto = :projeto"),
		@NamedQuery(name = "Nota.findNotesByCriterio", query = "SELECT n FROM Nota n WHERE n.criterio = :criterio"),
		@NamedQuery(name = "Nota.findNotesByProjectCriterio", query = "SELECT n FROM Nota n WHERE n.projeto = :projeto and n.criterio = :criterio"),
		@NamedQuery(name = "Nota.findNotesByProfessorOrientador", query = "SELECT n FROM Nota n WHERE n.projeto.professorOrientador = :orientador"),
		@NamedQuery(name = "Nota.findNotesByProfessorAvaliador", query = "SELECT n FROM Nota n WHERE n.professorAvaliador = :avaliador"),
		@NamedQuery(name = "Nota.findNotesByProjetoCriterioAvaliador", query = "SELECT n FROM Nota n WHERE n.projeto = :projeto and "
			+ " n.criterio = :criterio and n.professorAvaliador = :avaliador"),
		@NamedQuery(name = "Nota.findNotesByProfessorOrientadorAvaliador", query = "SELECT n FROM Nota n WHERE "
			+ "n.projeto.professorOrientador = :orientador and n.professorAvaliador = :avaliador"),
		@NamedQuery(name = "Nota.findNotesByProjetoCriterioOrientadorAvaliador", query = "SELECT n FROM Nota n WHERE n.projeto = :projeto and "
			+ " n.criterio = :criterio and n.projeto.professorOrientador = :orientador and n.professorAvaliador = :avaliador") })
@Entity
public class Nota
{
	// Atributos
	
	@Id
	@GeneratedValue
	@Column(length = 5, nullable = false)
	private Integer codigo;
	
	@Enumerated(EnumType.STRING)
	private Criterio criterio;
	
	@Column(length = 5, nullable = false)
	private Double nota;
	
	@ManyToOne
	private Projeto projeto;
	
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Professor professorAvaliador;
	
	// Construtores
	public Nota()
	{
		super();
		
		this.criterio = null;
		this.projeto = new Projeto();
		this.professorAvaliador = new Professor();
	}
	
	/**
	 * @param codigo
	 * @param criterio
	 * @param nota
	 * @param professorAvaliador
	 */
	public Nota(Integer codigo, Criterio criterio, Double nota,
		Projeto projeto, Professor professorAvaliador)
	{
		super();
		
		this.codigo = codigo;
		this.criterio = criterio;
		this.nota = nota;
		this.projeto = projeto;
		this.professorAvaliador = professorAvaliador;
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Nota other = (Nota) obj;
		if(codigo == null)
		{
			if(other.codigo != null)
				return false;
		}
		else
			if(!codigo.equals(other.codigo))
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
	 * @return the criterio
	 */
	public Criterio getCriterio()
	{
		return criterio;
	}
	
	/**
	 * @param criterio
	 *            the criterio to set
	 */
	public void setCriterio(Criterio criterio)
	{
		this.criterio = criterio;
	}
	
	/**
	 * @return the nota
	 */
	public Double getNota()
	{
		return nota;
	}
	
	/**
	 * @param nota
	 *            the nota to set
	 */
	public void setNota(Double nota)
	{
		this.nota = nota;
	}
	
	/**
	 * @return the projeto
	 */
	public Projeto getProjeto()
	{
		return projeto;
	}
	
	/**
	 * @param projeto
	 *            the projeto to set
	 */
	public void setProjeto(Projeto projeto)
	{
		this.projeto = projeto;
	}
	
	/**
	 * @return the professorAvaliador
	 */
	public Professor getProfessorAvaliador()
	{
		return professorAvaliador;
	}
	
	/**
	 * @param professorAvaliador
	 *            the professorAvaliador to set
	 */
	public void setProfessorAvaliador(Professor professorAvaliador)
	{
		this.professorAvaliador = professorAvaliador;
	}
}