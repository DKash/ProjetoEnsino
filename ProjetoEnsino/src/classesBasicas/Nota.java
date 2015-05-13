/**
 * 
 */
package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * @author Audry Martins
 *
 */
@NamedQuery(name="Nota.findNotesByProject", query = "SELECT n FROM Nota n WHERE n.projeto = :projeto")
@Entity
public class Nota
{
	// Atributos
	
	@Id
	@GeneratedValue
	@Column(length = 5, nullable = false)
	private Integer codigo;
	
	@Column(length = 40, nullable = false)
	private String criterio;
	
	@Column(length = 5, nullable = false)
	private Double nota;
	
	@ManyToOne
	private Projeto projeto;
	
	@JoinColumn(nullable = false)
	private Professor professorAvaliador;
	
	// Construtores
	public Nota()
	{
		super();
		
		this.criterio = "";
		this.projeto = new Projeto();
		this.professorAvaliador = new Professor();
	}
	
	/**
	 * @param codigo
	 * @param criterio
	 * @param nota
	 * @param professorAvaliador
	 */
	public Nota(Integer codigo, String criterio, Double nota, Projeto projeto,
		Professor professorAvaliador)
	{
		super();
		
		this.codigo = codigo;
		this.criterio = criterio;
		this.nota = nota;
		this.projeto = projeto;
		this.professorAvaliador = professorAvaliador;
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
	public String getCriterio()
	{
		return criterio;
	}
	
	/**
	 * @param criterio
	 *            the criterio to set
	 */
	public void setCriterio(String criterio)
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
	 * @param projeto the projeto to set
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