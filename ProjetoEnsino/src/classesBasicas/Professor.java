/**
 * 
 */
package classesBasicas;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * @author Audry Martins
 *
 */
@Entity
public class Professor extends Pessoa
{
	//Atributos
	
	@Enumerated
	private TipoProfessor tipoProfessor;

	//Construtores
	
	public Professor()
	{
		this.tipoProfessor = null;
	}
	
	/**
	 * @param codigo
	 * @param nome
	 * @param cpf
	 * @param dataNascimento
	 * @param emailprincipal
	 * @param usuario
	 * @param telefones
	 * @param endereco
	 * @param nacionalidade
	 */
	public Professor(Integer codigo, String nome, String cpf,
		Date dataNascimento, String emailprincipal, Usuario usuario,
		List<Telefone> telefones, Endereco endereco, String nacionalidade)
	{
		super(codigo, nome, cpf, dataNascimento, emailprincipal, usuario, telefones,
			endereco, nacionalidade);
	}	
	
	/**
	 * @param tipoProfessor
	 */
	public Professor(TipoProfessor tipoProfessor)
	{
		super();
		
		this.tipoProfessor = tipoProfessor;
	}

	//Métodos
	
	//Gets e Sets	//Construtores
	


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