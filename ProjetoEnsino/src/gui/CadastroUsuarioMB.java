/**
 * 
 */
package gui;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

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
public class CadastroUsuarioMB extends CadastroPessoaMB
{
	// Atributos
	
	private Usuario entidade = new Usuario();
	private List<Usuario> usuarios;
	
	@PostConstruct
	public void init()
	{
		usuarios = getUsuarios();
				
		/*try
		{
			usuarios = fachada.consultarTodosUsuarios();
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Usuario Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			 e.printStackTrace(); 
		}catch(NotaInexistenteException e)
		{
			 e.printStackTrace(); 
		}*/
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
	public String consultarPorId()
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
	public String consultarPorNome()
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
	public String consultarPorCPF()
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
		return "/usuario/Cadastrousuario.xhtml?faces-redirect=true";
		//return "#{msgs.urlCadastroUsuario}";
	}
	
	// Métodos
	public void onRowEdit(RowEditEvent event)
	{
		try
		{
			fachada.alterarUsuario((Usuario) event.getObject());
			FacesMessage msg = new FacesMessage("Usuario Editado",
				((Usuario) event.getObject()).getCodigo().toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesMessage msg = new FacesMessage("Não foi possível alterar ",
				((Usuario) event.getObject()).getNomeUsuario());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
	}
	
	public void onRowEditRemove(RowEditEvent event)
	{
		try
		{
			fachada.removerUsuario((Usuario) event.getObject());
			FacesMessage msg = new FacesMessage("Usuario Removido",
				((Usuario) event.getObject()).getNomeUsuario());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesMessage msg = new FacesMessage("Não foi possível remover ",
				((Usuario) event.getObject()).getNomeUsuario());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
	}
	
	public void onRowCancel(RowEditEvent event)
	{
		FacesMessage msg = new FacesMessage("Edição Cancelada",
			((Usuario) event.getObject()).getCodigo().toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onCellEdit(CellEditEvent event)
	{
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();
		if(newValue != null && !newValue.equals(oldValue))
		{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Cell Changed", "Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
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
			return fachada.consultarTodosUsuarios();
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
}