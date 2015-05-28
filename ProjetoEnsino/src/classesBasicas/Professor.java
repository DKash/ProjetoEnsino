/**
 * 
 */
package classesBasicas;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Audry Martins
 *
 */
@NamedQueries({
	@NamedQuery(name = "Professor.findAllActives" , query="SELECT p FROM Professor p WHERE p.situacao =:situacao"),
	@NamedQuery(name = "Professor.findByName", query = "SELECT p FROM Professor p WHERE p.nome LIKE :nome"),
	@NamedQuery(name = "Professor.findByCPF", query = "SELECT p FROM Professor p WHERE p.cpf = :cpf"),
	@NamedQuery(name = "Professor.findByTipoProfessor", query = "SELECT p FROM Professor p WHERE p.tipoProfessor = :tipoProfessor"),
})
@Entity
public class Professor extends Pessoa
{
	//Atributos
	
	@Enumerated(EnumType.STRING)
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
		Telefone telefone, Endereco endereco, String nacionalidade, Situacao situacao)
	{
		super(codigo, nome, cpf, dataNascimento, emailprincipal, sexo, usuario, telefone,
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