/**
 * 
 */
package gui;

import interfaces.negocio.IFachada;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import negocio.Fachada;
import classesBasicas.Usuario;
import exceptions.AlunoExistenteException;
import exceptions.AlunoInexistenteException;
import exceptions.CoordenadorExistenteException;
import exceptions.CoordenadorInexistenteException;
import exceptions.NotaExistenteException;
import exceptions.NotaInexistenteException;
import exceptions.ProfessorExistenteException;
import exceptions.ProfessorInexistenteException;
import exceptions.ProjetoExistenteException;
import exceptions.ProjetoInexistenteException;
import exceptions.UsuarioExistenteException;
import exceptions.UsuarioInexistenteException;

/**
 * @author Audry Martins
 *
 */
public class CadastroUsuarioMB extends CadastroPessoaMB
{
	//Atributos
	
	private Usuario entidade = new Usuario();
	private List<Usuario> usuarios;
	private IFachada fachada = Fachada.getInstancia();
	
	//Métodos
	
	/* (non-Javadoc)
	 * @see manangedBeans.CadastroPessoaMB#inserir()
	 */
	@Override
	public String inserir()
	{
		try
		{
			fachada.inserirUsuario(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário salvo com sucesso"));
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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Existente"));
		}catch(NotaExistenteException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see manangedBeans.CadastroPessoaMB#alterar()
	 */
	@Override
	public String alterar()
	{
		try
		{
			fachada.alterarUsuario(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário salvo com sucesso"));
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Inexistente"));
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see manangedBeans.CadastroPessoaMB#remover()
	 */
	@Override
	public String remover()
	{
		try
		{
			fachada.removerUsuario(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário excluído com sucesso"));
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Inexistente"));
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see manangedBeans.CadastroPessoaMB#consultarPorId()
	 */
	@Override
	public String consultarPorId()
	{
		try
		{
			fachada.consultarUsuarioPorId(entidade.getCodigo());
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Inexistente"));
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see manangedBeans.CadastroPessoaMB#consultarTodos()
	 */
	@Override
	public String consultarTodos()
	{
		try
		{
			fachada.consultarTodosUsuarios();
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Inexistente"));
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see manangedBeans.CadastroPessoaMB#consultarTodosComParametros()
	 */
	@Override
	public String consultarTodosComParametros()
	{
		try
		{
			fachada.consultarTodosUsuarios(0, 1);
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Inexistente"));
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	//Gets e Sets
	/**
	 * @return the entidade
	 */
	public Usuario getEntidade()
	{
		return entidade;
	}

	/**
	 * @param entidade the entidade to set
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
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Inexistente"));
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
		}
		return usuarios;
	}

	/**
	 * @param usuarios the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios)
	{
		this.usuarios = usuarios;
	}
}