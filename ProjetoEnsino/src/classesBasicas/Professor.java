/**
 * 
 */
package classesBasicas;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;

/**
 * @author Audry Martins
 *
 */
@Entity
public class Professor extends Pessoa
{
	//Atributos
	
	@Enumerated
	@JoinColumn(nullable = false)
	private TipoProfessor tipoProfessor;

	//Métodos
	
	//Gets e Sets
	
	/**
	 * @return the tipoProfessor
	 */
	public TipoProfessor getTipoProfessor()
	{
		return tipoProfessor;
	}

	/**
	 * @param tipoProfessor the tipoProfessor to set
	 */
	public void setTipoProfessor(TipoProfessor tipoProfessor)
	{
		this.tipoProfessor = tipoProfessor;
	}	
}