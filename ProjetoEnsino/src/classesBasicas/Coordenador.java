/**
 * 
 */
package classesBasicas;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Audry Martins
 *
 */
@Entity
public class Coordenador extends Pessoa
{
	//Atributos
	
	/*@OneToOne
	private Projeto projeto;*/
	
	@OneToMany
	private List<Professor> avaliadores;
	
	//Métodos
	
	//Gets e Sets
	/**
	 * @return the avaliadores
	 */
	public List<Professor> getAvaliadores()
	{
		return avaliadores;
	}

	/**
	 * @param avaliadores the avaliadores to set
	 */
	public void setAvaliadores(List<Professor> avaliadores)
	{
		this.avaliadores = avaliadores;
	}
	
	/**
	 * @return the projeto
	 *//*
	public Projeto getProjeto()
	{
		return projeto;
	}

	*//**
	 * @param projeto the projeto to set
	 *//*
	public void setProjeto(Projeto projeto)
	{
		this.projeto = projeto;
	}*/
}