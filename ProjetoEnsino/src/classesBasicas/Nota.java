/**
 * 
 */
package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 * @author Audry Martins
 *
 */
@Entity
public class Nota
{
	// Atributos
	
	@Id @GeneratedValue
	@Column(length = 5, nullable = false)
	private Integer codigo;
	
	@Column(length = 40, nullable = false)
	private String criterio;
	
	@Column(length = 5, nullable = false)
	private Double nota;
	
	@JoinColumn(nullable = false)
	private Professor professorAvaliador;
	
	//Construtores
	
	public Nota()
	{
		super();
		
		this.criterio = "";
		this.professorAvaliador = new Professor();
	}
	
	/**
	 * @param codigo
	 * @param criterio
	 * @param nota
	 * @param professorAvaliador
	 */
	public Nota(Integer codigo, String criterio, Double nota,
		Professor professorAvaliador)
	{
		super();
		
		this.codigo = codigo;
		this.criterio = criterio;
		this.nota = nota;
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
	 * @param codigo the codigo to set
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