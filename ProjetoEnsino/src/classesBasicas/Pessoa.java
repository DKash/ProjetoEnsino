/**
 * 
 */
package classesBasicas;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 * @author Audry Martins
 *
 */
@MappedSuperclass
public class Pessoa
{
	// Atributos
	@Id
	@GeneratedValue
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
	private String email;
	
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	
	@OneToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(nullable = false, unique = true)
	private Usuario usuario;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = true)
	private Telefone telefone;
	
	
	@Embedded
	private Endereco endereco;
	
	
	@Column(length = 30, nullable = false)
	private String nacionalidade;
	
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	// Construtores
	public Pessoa()
	{
		super();
		this.nome = "";
		this.cpf = "";
		this.dataNascimento = null;
		this.email = "";
		this.sexo = null;
		this.usuario = new Usuario();
		this.telefone = new Telefone();
		this.endereco = new Endereco();
		this.nacionalidade = "";
		this.situacao = null;
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
		String emailprincipal, Sexo sexo, Usuario usuario, Telefone telefone,
		Endereco endereco, String nacionalidade, Situacao situacao)
	{
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = emailprincipal;
		this.sexo = sexo;
		this.usuario = usuario;
		this.telefone = telefone;
		this.endereco = endereco;
		this.nacionalidade = nacionalidade;
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if(codigo == null)
		{
			if(other.codigo != null)
				return false;
		}
		else
			if(!codigo.equals(other.codigo))
				return false;
		return true;
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
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * @return the sexo
	 */
	public Sexo getSexo()
	{
		return sexo;
	}
	
	/**
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(Sexo sexo)
	{
		this.sexo = sexo;
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
	 * @return the telefone
	 */
	public Telefone getTelefone()
	{
		return telefone;
	}
	
	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefones(Telefone telefone)
	{
		this.telefone = telefone;
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