/**
 * 
 */
package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author Audry Martins
 *
 */
@NamedQuery(name = "Usuario.findByName", query = "SELECT user FROM Usuario user WHERE user.nome LIKE :nome")
@Entity
public class Usuario
{
	// Atributos
	
	@Id @GeneratedValue
	private Integer codigo;

	@Column(length = 40, unique = true, nullable = false)
	private String nomeUsuario;
	
	@Column(length = 30, nullable = false)
	private String senha;
	
	@Column(length = 30, nullable = false)
	private String dica;
	
	@Enumerated
	private Situacao situacao;
	
	// Construtores
	
	public Usuario()
	{
		super();
		
		this.nomeUsuario = "";
		this.senha = "";
		this.dica = "";
		this.situacao = null;
	}
	
	/**
	 * @param codigo
	 * @param nomeUsuario
	 * @param senha
	 * @param dica
	 */
	public Usuario(Integer codigo, String nomeUsuario, String senha,
		String dica, Situacao situacao)
	{
		super();
		
		this.codigo = codigo;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.dica = dica;
		this.situacao = situacao;
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

	/**
	 * @return the situacao
	 */
	public Situacao getSituacao()
	{
		return situacao;
	}

	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao(Situacao situacao)
	{
		this.situacao = situacao;
	}
}