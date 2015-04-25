/**
 * 
 */
package classesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;

/**
 * @author Audry Martins
 *
 */
@Entity
public class Telefone
{
	// Atributos
	
	@Column(length = 10, nullable = false, unique = true)
	private String codigoPais;
	
	@Column(length = 10, nullable = false)
	private String ddd;
	
	@Column(length = 15, nullable = false)
	private String numero;
	
	@Enumerated
	@JoinColumn(nullable = false)
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
	 * @param codigoPais
	 * @param ddd
	 * @param numero
	 * @param operadora
	 */
	public Telefone(String codigoPais, String ddd, String numero,
		Operadora operadora)
	{
		super();
		this.codigoPais = codigoPais;
		this.ddd = ddd;
		this.numero = numero;
		this.operadora = operadora;
	}
	
	// Métodos
	
	// Gets e Sets
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