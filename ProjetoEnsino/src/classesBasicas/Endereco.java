/**
 * 
 */
package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Audry Martins
 *
 */
@Embeddable
public class Endereco
{
	// Atributos
	
	@Enumerated(EnumType.STRING)
	private TipoLogradouro tipoLogradouro;
	
	@Column(length = 40, nullable = false)
	private String logradouro;
	
	@Column(length = 10, nullable = false)
	private String numero;
	
	@Column(length = 15, nullable = true)
	private String complemento;
	
	@Column(length = 20, nullable = false)
	private String bairro;
	
	@Column(length = 20, nullable = false)
	private String cidade;
	
	@Enumerated(EnumType.STRING)
	private UF estado;
	
	@Column(length = 20, nullable = false)
	private String pais;
	
	// Construtores
	
	public Endereco()
	{
		super();
	
		this.tipoLogradouro = null;
		this.logradouro = "";
		this.numero = "";
		this.complemento = "";
		this.bairro = "";
		this.cidade = "";
		this.estado = null;
		this.pais = "";
	}
	
	/**
	 * @param tipoLogradouro
	 * @param logradouro
	 * @param numero
	 * @param complemento
	 * @param bairro
	 * @param cidade
	 * @param estado
	 * @param pais
	 */
	public Endereco(TipoLogradouro tipoLogradouro, String logradouro,
		String numero, String complemento, String bairro, String cidade,
		UF estado, String pais)
	{
		super();
		
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}
	
	// Métodos
	
	// Gets e Sets
	/**
	 * @return the tipoLogradouro
	 */
	public TipoLogradouro getTipoLogradouro()
	{
		return tipoLogradouro;
	}
	
	/**
	 * @param tipoLogradouro
	 *            the tipoLogradouro to set
	 */
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro)
	{
		this.tipoLogradouro = tipoLogradouro;
	}
	
	/**
	 * @return the logradouro
	 */
	public String getLogradouro()
	{
		return logradouro;
	}
	
	/**
	 * @param logradouro
	 *            the logradouro to set
	 */
	public void setLogradouro(String logradouro)
	{
		this.logradouro = logradouro;
	}
	
	/**
	 * @return the numero
	 */
	public String getNumero()
	{
		return numero;
	}
	
	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero)
	{
		this.numero = numero;
	}
	
	/**
	 * @return the complemento
	 */
	public String getComplemento()
	{
		return complemento;
	}
	
	/**
	 * @param complemento
	 *            the complemento to set
	 */
	public void setComplemento(String complemento)
	{
		this.complemento = complemento;
	}
	
	/**
	 * @return the bairro
	 */
	public String getBairro()
	{
		return bairro;
	}
	
	/**
	 * @param bairro
	 *            the bairro to set
	 */
	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}
	
	/**
	 * @return the cidade
	 */
	public String getCidade()
	{
		return cidade;
	}
	
	/**
	 * @param cidade
	 *            the cidade to set
	 */
	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}
	
	/**
	 * @return the estado
	 */
	public UF getEstado()
	{
		return estado;
	}
	
	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(UF estado)
	{
		this.estado = estado;
	}
	
	/**
	 * @return the pais
	 */
	public String getPais()
	{
		return pais;
	}
	
	/**
	 * @param pais
	 *            the pais to set
	 */
	public void setPais(String pais)
	{
		this.pais = pais;
	}
}