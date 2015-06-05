/**
 * 
 */
package manangedBeans;

import interfaces.negocio.IFachada;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import negocio.Fachada;
import classesBasicas.TipoUsuario;
import classesBasicas.Usuario;
import exceptions.LoginInvalidoException;
import exceptions.PessoaInexistenteException;


/**
 * @author Audry Martins
 *
 */
@ManagedBean
@SessionScoped
public class LoginMB
{
	// Atributos
	private Usuario usuario = new Usuario();
	
	
	private String mensagem;
	
	
	private String senha2;
	
	
	private Usuario usuarioLogado;
	
	
	private Integer numero = 20;
	
	
	private IFachada fachada = Fachada.getInstancia();
	
	// Métodos
	public String efetuarLogin()
	{
		try
		{
			usuarioLogado = fachada.efetuarLogin(usuario);
			setMensagem("#{msgs.mensagemSucessoLogin}");
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("#{msgs.mensagemSucessoLogin}"));
			return "/menu.xhtml?faces-redirect=true";
		}catch(PessoaInexistenteException e)
		{
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuario Inexistente, tente novamente"));
			return "";
		}catch(LoginInvalidoException e)
		{
			setMensagem("#{msgs.mensagemFalhaLogin}");
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("#{msgs.mensagemFalhaLogin}"));
		}
		return mensagem;
	}
	
	public String logOut()
	{
		usuarioLogado = null;
		return "/index.xhtml";
	}
	
	public void decrement()
	{		if(this.numero != 0)
		{
			numero--;
		}
		else
		{
			logOut();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Sessão Expirada, Faça login Novamente"));
		}
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
	 * @param senha2
	 *            the senha2 to set
	 */
	public void setSenha2(String senha2)
	{
		this.senha2 = senha2;
	}
	
	/**
	 * @return the fachada
	 */
	public IFachada getFachada()
	{
		if(fachada == null)
			fachada = new Fachada();
		return fachada;
	}
	
	/**
	 * @param fachada
	 *            the fachada to set
	 */
	public void setFachada(IFachada fachada)
	{
		this.fachada = fachada;
	}
	
	/**
	 * @return the usuarioLogado
	 */
	public Usuario getUsuarioLogado()
	{
		return usuarioLogado;
	}
	
	/**
	 * @param usuarioLogado
	 *            the usuarioLogado to set
	 */
	public void setUsuarioLogado(Usuario usuarioLogado)
	{
		this.usuarioLogado = usuarioLogado;
	}
	
	public boolean isMostrarTelasAdmin()
	{
		if(usuario.getTipoUsuario() != null
			&& usuario.getTipoUsuario() == TipoUsuario.Admin)
		{
			return true;
		}
		return false;
	}
	
	public boolean isMostrarTelasAluno()
	{
		if(usuario.getTipoUsuario() != null
			&& usuario.getTipoUsuario() == TipoUsuario.Aluno)
		{
			return true;
		}
		return false;
	}
	
	public boolean isMostrarTelasOrientador()
	{
		if(usuario.getTipoUsuario() != null
			&& usuario.getTipoUsuario() == TipoUsuario.Orientador)
		{
			return true;
		}
		return false;
	}
	
	public boolean isMostrarTelasAvaliador()
	{
		if(usuario.getTipoUsuario() != null
			&& usuario.getTipoUsuario() == TipoUsuario.Avaliador)
		{
			return true;
		}
		return false;
	}
	
	public boolean isMostrarTelasCoordenador()
	{
		if(usuario.getTipoUsuario() != null
			&& usuario.getTipoUsuario() == TipoUsuario.Coordenador)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * @return the numero
	 */
	public Integer getNumero()
	{
		return numero;
	}
	
	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(Integer numero)
	{
		this.numero = numero;
	}
}