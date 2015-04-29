/**
 * 
 */
package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Audry Martins
 *
 */
@Entity
public class Telefone
{
	// Atributos
	
	@Id @GeneratedValue
	private Integer codigo;

	@Column(length = 10, nullable = false, unique = true)
	private String codigoPais;
	
	@Column(length = 10, nullable = false)
	private String ddd;
	
	@Column(length = 15, nullable = false)
	private String numero;
	
	@Enumerated
	private Operadora operadora;
	
	// Construtores
	
	public Telefone()
	{
		super();
		
		this.codigoPais = "";
		this.ddd = "";
		this.numero = "";
		this.operadora = null;
	}
	
	/**
	 * @param codigo
	 * @param codigoPais
	 * @param ddd
	 * @param numero
	 * @param operadora
	 */
	public Telefone(Integer codigo, String codigoPais, String ddd, String numero,
		Operadora operadora)
	{
		super();
		
		this.codigo = codigo;
		this.codigoPais = codigoPais;
		this.ddd = ddd;
		this.numero = numero;
		this.operadora = operadora;
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
	 * @return the codigoPais
	 */
	public String getCodigoPais()
	{
		return codigoPais;
	}
	
	/**
	 * @param codigoPais
	 *            the codigoPais to set
	 */
	public void setCodigoPais(String codigoPais)
	{
		this.codigoPais = codigoPais;
	}
	
	/**
	 * @return the ddd
	 */
	public String getDdd()
	{
		return ddd;
	}
	
	/**
	 * @param ddd
	 *            the ddd to set
	 */
	public void setDdd(String ddd)
	{
		this.ddd = ddd;
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
	 * @return the operadora
	 */
	public Operadora getOperadora()
	{
		return operadora;
	}
	
	/**
	 * @param operadora
	 *            the operadora to set
	 */
	public void setOperadora(Operadora operadora)
	{
		this.operadora = operadora;
	}
}