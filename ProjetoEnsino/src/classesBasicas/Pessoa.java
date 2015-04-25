/**
 * 
 */
package classesBasicas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Audry Martins
 *
 */
@MappedSuperclass
public class Pessoa
{
	// Atributos
	
	@Id @GeneratedValue
	@Column(length = 10, nullable = false, updatable = false)
	private Integer codigo;
	
	@Column(length = 40, nullable = false)
	private String nome;
	
	@Column(length = 14, nullable = false, unique = true)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@Column(length = 10, nullable = false)
	private Date dataNascimento;
	
	@Column(length = 40, nullable = false, unique = true)
	private String emailprincipal;
	
	@OneToOne
	@JoinColumn(nullable = false, unique = true)
	private Usuario usuario;
	
	@OneToMany
	@JoinColumn(nullable = false)
	private List<Telefone> telefones;
	
	@Embedded
	@JoinColumn(nullable = false, unique = true)
	private Endereco endereco;
	
	@Column(length = 30, nullable = false)
	private String nacionalidade;
	
	// Construtores
	
	public Pessoa()
	{
		super();
		
		this.nome = "";
		this.cpf = "";
		this.dataNascimento = new Date();
		this.emailprincipal = "";
		this.usuario = new Usuario();
		this.telefones = new ArrayList<Telefone>();
		this.endereco = new Endereco();
		this.nacionalidade = "";
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
	 */
	public Pessoa(Integer codigo, String nome, String cpf, Date dataNascimento, 
		String emailprincipal, Usuario usuario, List<Telefone> telefones,
		Endereco endereco, String nacionalidade)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.emailprincipal = emailprincipal;
		this.usuario = usuario;
		this.telefones = telefones;
		this.endereco = endereco;
		this.nacionalidade = nacionalidade;
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
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(Integer codigo)
	{
		this.codigo = codigo;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	/**
	 * @return the cpf
	 */
	public String getCpf()
	{
		return cpf;
	}
	
	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}
	
	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento()
	{
		return dataNascimento;
	}
	
	/**
	 * @param dataNascimento
	 *            the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}
	
	/**
	 * @return the emailprincipal
	 */
	public String getEmailprincipal()
	{
		return emailprincipal;
	}
	
	/**
	 * @param emailprincipal
	 *            the emailprincipal to set
	 */
	public void setEmailprincipal(String emailprincipal)
	{
		this.emailprincipal = emailprincipal;
	}
	
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario()
	{
		return usuario;
	}
	
	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	
	/**
	 * @return the telefones
	 */
	public List<Telefone> getTelefones()
	{
		return telefones;
	}
	
	/**
	 * @param telefones
	 *            the telefones to set
	 */
	public void setTelefones(List<Telefone> telefones)
	{
		this.telefones = telefones;
	}
	
	/**
	 * @return the endereco
	 */
	public Endereco getEndereco()
	{
		return endereco;
	}
	
	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(Endereco endereco)
	{
		this.endereco = endereco;
	}
	
	/**
	 * @return the nacionalidade
	 */
	public String getNacionalidade()
	{
		return nacionalidade;
	}
	
	/**
	 * @param nacionalidade
	 *            the nacionalidade to set
	 */
	public void setNacionalidade(String nacionalidade)
	{
		this.nacionalidade = nacionalidade;
	}
}