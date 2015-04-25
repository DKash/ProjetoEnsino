/**
 * 
 */
package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Audry Martins
 *
 */
@Entity
public class Usuario
{
	// Atributos
	
	@Column(length = 40, unique = true, nullable = false)
	private String nomeUsuario;
	
	@Column(length = 30, nullable = false)
	private String senha;
	
	@Column(length = 30, nullable = false)
	private String dica;
	
	// Construtores
	
	public Usuario()
	{
		super();
		
		this.nomeUsuario = "";
		this.senha = "";
		this.dica = "";
	}
	
	/**
	 * @param nomeUsuario
	 * @param senha
	 * @param dica
	 */
	public Usuario(String nomeUsuario, String senha, String dica)
	{
		super();
		
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.dica = dica;
	}
	
	// Métodos
	
	// Gets e Sets
	
	/**
	 * @return the nomeUsuario
	 */
	public String getNomeUsuario()
	{
		return nomeUsuario;
	}
	
	/**
	 * @param nomeUsuario
	 *            the nomeUsuario to set
	 */
	public void setNomeUsuario(String nomeUsuario)
	{
		this.nomeUsuario = nomeUsuario;
	}
	
	/**
	 * @return the senha
	 */
	public String getSenha()
	{
		return senha;
	}
	
	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	
	/**
	 * @return the dica
	 */
	public String getDica()
	{
		return dica;
	}
	
	/**
	 * @param dica
	 *            the dica to set
	 */
	public void setDica(String dica)
	{
		this.dica = dica;
	}
}