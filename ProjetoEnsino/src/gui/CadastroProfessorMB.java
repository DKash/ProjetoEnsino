/**
 * 
 */
package gui;

import interfaces.negocio.IFachada;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import negocio.Fachada;
import classesBasicas.Professor;
import classesBasicas.TipoProfessor;
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
public class CadastroProfessorMB extends CadastroPessoaMB
{
	// Atributos
	
	private Professor entidade;
	private List<Professor> professores;
	private IFachada fachada = Fachada.getInstancia();
	
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
			fachada.inserirProfessor(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor salvo com sucesso"));
		}catch(AlunoExistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorExistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor Inexistente"));
		}catch(CoordenadorExistenteException e)
		{
			e.printStackTrace();
		}catch(ProjetoExistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioExistenteException e)
		{
			e.printStackTrace();
		}catch(NotaExistenteException e)
		{
			e.printStackTrace();
		}
		return null;
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
			fachada.alterarProfessor(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor salvo com sucesso"));
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
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
			fachada.removerProfessor(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor excluído com sucesso"));
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
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
			fachada.consultarProfessorPorId(entidade.getCodigo());
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
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
			fachada.consultarTodosProfessores();
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
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
			fachada.consultarTodosProfessores(0, 1);
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	// Gets e Sets
	/**
	 * @return the entidade
	 */
	public Professor getEntidade()
	{
		return entidade;
	}

	/**
	 * @param entidade the entidade to set
	 */
	public void setEntidade(Professor entidade)
	{
		this.entidade = entidade;
	}
	
	public TipoProfessor[] getTipoProfessor()
	{
		return TipoProfessor.values();
	}

	/**
	 * @return the professores
	 */
	public List<Professor> getProfessores()
	{
		try
		{
			return fachada.consultarTodosProfessores();
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Professor Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
		}
		return professores;
	}

	/**
	 * @param professores the professores to set
	 */
	public void setProfessores(List<Professor> professores)
	{
		this.professores = professores;
	}
}