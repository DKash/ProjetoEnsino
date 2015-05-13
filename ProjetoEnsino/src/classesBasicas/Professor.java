/**
 * 
 */
package classesBasicas;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Audry Martins
 *
 */
@NamedQueries({
	@NamedQuery(name = "Professor.findByName", query = "SELECT p FROM Professor p WHERE p.nome LIKE :nome"),
	@NamedQuery(name = "Professor.findByCPF", query = "SELECT p FROM Professor p WHERE p.cpf = :cpf")
})
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
		Date dataNascimento, String emailprincipal, Sexo sexo, Usuario usuario,
		List<Telefone> telefones, Endereco endereco, String nacionalidade, Situacao situacao)
	{
		super(codigo, nome, cpf, dataNascimento, emailprincipal, sexo, usuario, telefones,
			endereco, nacionalidade, situacao);
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