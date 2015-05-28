/**
 * 
 */
package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Audry Martins
 *
 */
@NamedQueries({
		@NamedQuery(name = "Usuario.findAllActives", query = "SELECT u FROM Usuario u WHERE u.situacao =:situacao"),
		@NamedQuery(name = "Usuario.findByNome", query = "SELECT user FROM Usuario user WHERE user.nomeUsuario LIKE :nome") })
@Entity
public class Usuario
{
	// Atributos
	@Id
	@GeneratedValue
	private Integer codigo;
	
	@Column(length = 40, unique = true, nullable = false)
	private String nomeUsuario;
	
	@Column(length = 30, nullable = false)
	private String senha;
	
	@Column(length = 30, nullable = true)
	private String dica;
	
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	// Construtores
	public Usuario()
	{
		super();
		this.nomeUsuario = "";
		this.senha = "";
		this.dica = "";
		this.tipoUsuario = null;
		this.situacao = null;
	}
	
	/**
	 * @param codigo
	 * @param nomeUsuario
	 * @param senha
	 * @param dica
	 */
	public Usuario(Integer codigo, String nomeUsuario, String senha,
		String dica, TipoUsuario tipoUsuario, Situacao situacao)
	{
		super();
		this.codigo = codigo;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.dica = dica;
		this.tipoUsuario = tipoUsuario;
		this.situacao = situacao;
	}
	
	// Métodos
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
			+ ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if(nomeUsuario == null)
		{
			if(other.nomeUsuario != null)
				return false;
		}
		else
			if(!nomeUsuario.equals(other.nomeUsuario))
				return false;
		return true;
	}
	
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
	 * @return the tipoUsuario
	 */
	public TipoUsuario getTipoUsuario()
	{
		return tipoUsuario;
	}
	
	/**
	 * @param tipoUsuario
	 *            the tipoUsuario to set
	 */
	public void setTipoUsuario(TipoUsuario tipoUsuario)
	{
		this.tipoUsuario = tipoUsuario;
	}
	
	/**
	 * @return the situacao
	 */
	public Situacao getSituacao()
	{
		return situacao;
	}
	
	/**
	 * @param situacao
	 *            the situacao to set
	 */
	public void setSituacao(Situacao situacao)
	{
		this.situacao = situacao;
	}
}