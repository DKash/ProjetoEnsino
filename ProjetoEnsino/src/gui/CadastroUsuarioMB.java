/**
 * 
 */
package gui;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import classesBasicas.TipoUsuario;
import classesBasicas.Usuario;
import exceptions.NotaExistenteException;
import exceptions.NotaInexistenteException;
import exceptions.PessoaExistenteException;
import exceptions.PessoaInexistenteException;
import exceptions.ProjetoExistenteException;
import exceptions.ProjetoInexistenteException;

/**
 * @author Audry Martins
 *
 */
@ManagedBean
@SessionScoped
public class CadastroUsuarioMB extends ObjetoMB<Usuario>
{
	// Atributos
	
	private Usuario entidade = new Usuario();
	private List<Usuario> usuarios;
	
	@PostConstruct
	public void init()
	{
		usuarios = getUsuarios();
	}
	
	// Métodos
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see manangedBeans.CadastroPessoaMB#inserir()
	 */
	@Override
	public String inserir()
	{
		try
		{
			fachada.inserirUsuario(entidade);
			entidade = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário salvo com sucesso"));
		}catch(ProjetoExistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(PessoaExistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário Existente"));
		}catch(NotaExistenteException e)
		{
			/*e.printStackTrace();*/
		}catch(ProjetoInexistenteException e)
		{
			/*e.printStackTrace();*/
		}catch(NotaInexistenteException e)
		{
			/*e.printStackTrace();*/
		}
		return "";
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see manangedBeans.CadastroPessoaMB#alterar()
	 */
	@Override
	public String alterar()
	{
		try
		{			
			fachada.alterarUsuario(entidade);
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário alterado com sucesso"));
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário Inexistente"));
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see manangedBeans.CadastroPessoaMB#remover()
	 */
	@Override
	public String remover()
	{
		try
		{		
			fachada.removerUsuario(entidade);
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário excluído com sucesso"));
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see manangedBeans.CadastroPessoaMB#consultarPorId()
	 */
	@Override
	public String consultarPorId(int codigo)
	{
		try
		{
			fachada.consultarUsuarioPorId(entidade.getCodigo());
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário Inexistente"));
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see manangedBeans.CadastroPessoaMB#consultarTodos()
	 */
	@Override
	public String consultarTodos()
	{
		try
		{
			fachada.consultarTodosUsuarios();
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário Inexistente"));
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see manangedBeans.CadastroPessoaMB#consultarTodosComParametros()
	 */
	@Override
	public String consultarTodosComParametros()
	{
		try
		{
			fachada.consultarTodosUsuarios(0, 1);
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário Inexistente"));
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.CadastroPessoaMB#consultarPorNome()
	 */
	@Override
	public String consultarPorNome(String nome)
	{
		try
		{
			fachada.consultarUsuarioPorNome(entidade.getNomeUsuario());
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário Inexistente"));
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.CadastroPessoaMB#consultarPorCPF()
	 */
	@Override
	public String consultarPorCPF(String cpf)
	{
		return "";
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#consultarTodosAtivos()
	 */
	@Override
	public String consultarTodosAtivos()
	{
		try
		{
			fachada.consultarTodosUsuariosAtivos();
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			/*e.printStackTrace();*/
		}catch(NotaInexistenteException e)
		{
			/*e.printStackTrace();*/
		}
		return "";
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#novo()
	 */
	@Override
	public String novo()
	{
		entidade = new Usuario();
		return "/usuario/CadastroUsuario.xhtml?faces-redirect=true";
		//return "#{msgs.urlCadastroUsuario}";
	}
	
	// Gets e Sets
	/**
	 * @return the entidade
	 */
	public Usuario getEntidade()
	{
		return entidade;
	}
	
	/**
	 * @param entidade
	 *            the entidade to set
	 */
	public void setEntidade(Usuario entidade)
	{
		this.entidade = entidade;
	}
	
	/**
	 * @return the usuarios
	 */
	public List<Usuario> getUsuarios()
	{
		try
		{
			return fachada.consultarTodosUsuariosAtivos();
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuário Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			/*e.printStackTrace();*/
		}catch(NotaInexistenteException e)
		{
			/*e.printStackTrace();*/
		}
		return usuarios;
	}
	
	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios)
	{
		this.usuarios = usuarios;
	}
	
	/**
	 * @return the tipoUsuarios
	 */
	public TipoUsuario[] getTipoUsuarios()
	{
		return TipoUsuario.values();
	}

	/**
	 * @return the lista
	 *//*
	public DataModel<Usuario> getLista()
	{
		lista = new ListDataModel<Usuario>(getUsuarios());
		
		return lista;
	}

	*//**
	 * @param lista the lista to set
	 *//*
	public void setLista(DataModel<Usuario> lista)
	{
		this.lista = lista;
	}*/
}