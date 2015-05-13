/**
 * 
 */
package gui;

import interfaces.negocio.IFachada;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import negocio.Fachada;
import classesBasicas.Nota;
import classesBasicas.Professor;
import classesBasicas.Projeto;
import classesBasicas.Resultado;
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
public class CadastroProjetoMB extends CadastroPessoaMB
{
	// Atributos
	
	private Projeto entidade = new Projeto();
	private List<Projeto> projetos;
	private List<Professor> avaliadores;
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
			fachada.inserirProjeto(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto salvo com sucesso"));
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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto Inexistente"));
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
			fachada.alterarProjeto(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto salvo com sucesso"));
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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto Inexistente"));
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
			fachada.removerProjeto(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto excluído com sucesso"));
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto Inexistente"));
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
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
			fachada.consultarProjetoPorId(entidade.getCodigo());
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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto Inexistente"));
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
			fachada.consultarTodosProjetos();
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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto Inexistente"));
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
			fachada.consultarTodosProjetos(0, 1);
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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto Inexistente"));
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
	public Projeto getEntidade()
	{
		return entidade;
	}
	
	/**
	 * @param entidade
	 *            the entidade to set
	 */
	public void setEntidade(Projeto entidade)
	{
		this.entidade = entidade;
	}

	/**
	 * @return the avaliadores
	 */
	public List<Professor> getAvaliadores()
	{
		return avaliadores;
	}

	/**
	 * @param avaliadores the avaliadores to set
	 */
	public void setAvaliadores(List<Professor> avaliadores)
	{
		this.avaliadores = avaliadores;
	}

	/**
	 * @return the projetos
	 */
	public List<Projeto> getProjetos()
	{
		return projetos;
	}

	/**
	 * @param projetos the projetos to set
	 */
	public void setProjetos(List<Projeto> projetos)
	{
		this.projetos = projetos;
	}

	/**
	 * @return the notas
	 */
	public List<Nota> getNotas()
	{
		try
		{
			return fachada.consultarNotasPorProjeto(entidade);
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nota Inexistente"));
		}
		return null;
	}
	
	public Resultado[] getResultados()
	{
		return Resultado.values();
	}
}