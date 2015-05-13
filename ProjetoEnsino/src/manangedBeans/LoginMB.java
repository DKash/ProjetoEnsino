/**
 * 
 */
package manangedBeans;

import interfaces.negocio.IFachada;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import negocio.Fachada;
import classesBasicas.Usuario;
import exceptions.AlunoExistenteException;
import exceptions.CoordenadorExistenteException;
import exceptions.NotaExistenteException;
import exceptions.ProfessorExistenteException;
import exceptions.ProjetoExistenteException;
import exceptions.UsuarioExistenteException;
import exceptions.UsuarioInexistenteException;


/**
 * @author Audry Martins
 *
 */
@ManagedBean
public class LoginMB
{
	// Atributos
	
	private Usuario usuario = new Usuario();
	private String mensagem;
	private String senha2;
	private IFachada fachada = Fachada.getInstancia();
	
	// Métodos
	
	public String efetuarLogin()
	{
		if(usuario.getSenha().equals(senha2))
		{
			try
			{
				fachada.efetuarLogin(usuario);
				setMensagem("#{msgs.mensagemSucessoLogin}");
				FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("#{msgs.mensagemSucessoLogin}"));
				return "/menu.xhtml?faces-redirect=true";
			}catch(UsuarioInexistenteException e)
			{
				FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Usuario Inexistente, tente novamente"));
				return "";
			}
		}
		else
		{
			setMensagem("#{msgs.mensagemFalhaLogin}");
		}
		return mensagem;
	}
	
	public String cadastrarUsuario()
	{
		if(usuario.getSenha().equals(senha2))
		{
			try
			{
				fachada.inserirUsuario(usuario);
				FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("#{msgs.mensagemSucessoLogin}"));
				return "index.xhtml";
			}catch(AlunoExistenteException e)
			{
				e.printStackTrace();
			}catch(ProfessorExistenteException e)
			{
				e.printStackTrace();
			}catch(CoordenadorExistenteException e)
			{
				e.printStackTrace();
			}catch(ProjetoExistenteException e)
			{
				e.printStackTrace();
			}catch(UsuarioExistenteException e)
			{
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Usuario Existente, tente novamente"));
				return "index.xhtml";
			}catch(NotaExistenteException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			setMensagem("#{msgs.mensagemFalhaLogin}");
			return "index.xhtml";
		}
		return mensagem;
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
}