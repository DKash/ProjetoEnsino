/**
 * 
 */
package classesBasicas;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * @author Audry Martins
 *
 */
@NamedQueries({
	@NamedQuery(name = "Coordenador.findByName", query = "SELECT c FROM Coordenador c WHERE c.nome LIKE :nome"),
	@NamedQuery(name = "Coordenador.findByCPF", query = "SELECT c FROM Coordenador c WHERE c.cpf = :cpf")
})
@Entity
public class Coordenador extends Pessoa
{
	//Atributos
		
	@OneToOne
	private Professor professor;
	
	//Construtores
		
	public Coordenador()
	{
		this.professor = new Professor();
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
	public Coordenador(Integer codigo, String nome, String cpf,
		Date dataNascimento, String emailprincipal, Sexo sexo, Usuario usuario,
		List<Telefone> telefones, Endereco endereco, String nacionalidade, Situacao situacao)
	{
		super(codigo, nome, cpf, dataNascimento, emailprincipal, sexo, usuario, telefones,
			endereco, nacionalidade, situacao);
	}

	/**
	 * @param professor
	 */
	public Coordenador(Professor professor)
	{
		super();
		this.professor = professor;
	}

	//Métodos
	
	//Gets e Sets
	/**
	 * @return the professor
	 */
	public Professor getProfessor()
	{
		return professor;
	}
	
	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(Professor professor)
	{
		this.professor = professor;
	}	
}