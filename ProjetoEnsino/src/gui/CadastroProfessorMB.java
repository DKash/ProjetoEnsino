/**
 * 
 */
package gui;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import classesBasicas.Professor;
import classesBasicas.TipoProfessor;
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
public class CadastroProfessorMB extends ObjetoMB<Professor>
{
	// Atributos
	
	private Professor entidade = new Professor();
	private List<Professor> professores;

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
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor salvo com sucesso"));
		}catch(PessoaExistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Inexistente"));
		}catch(ProjetoExistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaExistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
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
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor alterado com sucesso"));
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
		return null;
	}
	
	public String remover()
	{
		try
		{			
			fachada.removerProfessor(entidade);
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor excluído com sucesso"));
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Inexistente"));
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
			fachada.consultarProfessorPorId(entidade.getCodigo());
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Inexistente"));
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
	 * @see manangedBeans.CadastroPessoaMB#consultarTodos()
	 */
	@Override
	public String consultarTodos()
	{
		try
		{
			fachada.consultarTodosProfessores();
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Inexistente"));
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
	 * @see manangedBeans.CadastroPessoaMB#consultarTodosComParametros()
	 */
	@Override
	public String consultarTodosComParametros()
	{
		try
		{
			fachada.consultarTodosProfessores(0, 1);
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Inexistente"));
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
	 * @see gui.CadastroPessoaMB#consultarPorNome()
	 */
	@Override
	public String consultarPorNome()
	{
		try
		{
			fachada.consultarProfessorPorNome(entidade.getNome());
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Inexistente"));
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
		try
		{
			fachada.consultarProfessorPorCPF(entidade.getCpf());
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Inexistente"));
		}
		return null;
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
			fachada.consultarTodosProfessoresAtivos();
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Inexistente"));
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
	 * @see gui.ObjetoMB#novo()
	 */
	@Override
	public String novo()
	{
		entidade = new Professor();
		return "/professor/CadastroProfessor.xhtml?faces-redirect=true";
	}
	
	public String consultarPorTipoProfessor(TipoProfessor tipoProfessor)
	{
		try
		{
			fachada.consultarProfessorPorTipoProfessor(tipoProfessor);
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Inexistente"));
		}
		return "";
	}
	
	public String editar(Professor entidade)
	{
		this.entidade = entidade;
		
		return "/professor/CadastroProfessor.xhtml?faces-redirect=true";
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
	 * @param entidade
	 *            the entidade to set
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
			professores = fachada.consultarTodosProfessoresAtivos();
		}catch(PessoaInexistenteException e)
		{
			/*e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Inexistente"));*/
		}catch(ProjetoInexistenteException e)
		{
			/*e.printStackTrace();*/
		}catch(NotaInexistenteException e)
		{
			/*e.printStackTrace();*/
		}
		return professores;
	}
	
	/**
	 * @param professores
	 *            the professores to set
	 */
	public void setProfessores(List<Professor> professores)
	{
		this.professores = professores;
	}
}