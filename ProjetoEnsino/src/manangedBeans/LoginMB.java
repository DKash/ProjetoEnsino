/**
 * 
 */
package manangedBeans;

import javax.faces.bean.ManagedBean;

import util.Mensagens;
import classesBasicas.Usuario;
//import exceptions.LoginInvalido;


/**
 * @author Audry Martins
 *
 */
@ManagedBean
public class LoginMB
{
	// Atributos
	
	private Usuario usuario;
	private String mensagem;
	private String senha2;
	
	// Construtores
	
	public LoginMB()
	{
		super();
		
		this.usuario = new Usuario();
		this.mensagem = "";
		this.senha2 = "";
	}
	
	/**
	 * @param usuario
	 * @param mensagem
	 */
	public LoginMB(Usuario usuario, String mensagem, String senha2)
	{
		super();
	
		this.usuario = usuario;
		this.mensagem = mensagem;
		this.senha2 = senha2;
	}
	
	// Métodos
	
	public String efetuarLogin()
	{
		if(usuario.getSenha().equals(senha2))
		{
			setMensagem(Mensagens.MENSAGEM_SUCESSO_LOGIN);
		}
		else
		{
			setMensagem(Mensagens.MENSAGEM_FALHA_LOGIN);
		}
			
		/*try
		{
			fachada.efetuarLogin(usuario);
			setMensagem(Mensagens.MENSAGEM_SUCESSO_LOGIN);
			return "menu.xhtml";
		} catch (LoginInvalidoException e)
		{
			setMensagem(Mensagens.MENSAGEM_FALHA_LOGIN);
			return "index.xhtml";
		}*/
		return null;
	}
	
	// Gets e Sets
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
	 * @return the mensagem
	 */
	public String getMensagem()
	{
		return mensagem;
	}
	
	/**
	 * @param mensagem
	 *            the mensagem to set
	 */
	public void setMensagem(String mensagem)
	{
		this.mensagem = mensagem;
	}

	/**
	 * @return the senha2
	 */
	public String getSenha2()
	{
		return senha2;
	}

	/**
	 * @param senha2 the senha2 to set
	 */
	public void setSenha2(String senha2)
	{
		this.senha2 = senha2;
	}
}