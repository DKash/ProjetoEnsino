/**
 * 
 */
package gui;

import interfaces.negocio.IFachada;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import negocio.Fachada;
import classesBasicas.Aluno;
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
public class CadastroAlunoMB extends CadastroPessoaMB
{
	// Atributos
	
	private Aluno entidade = new Aluno();
	private List<Aluno> alunos;
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
			fachada.inserirAluno(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno salvo com sucesso"));
		}catch(AlunoExistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno Inexistente"));
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
			fachada.alterarAluno(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno salvo com sucesso"));
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno Inexistente"));
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
			fachada.removerAluno(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno excluído com sucesso"));
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno Inexistente"));
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
			fachada.consultarAlunoPorId(entidade.getCodigo());
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno Inexistente"));
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
			fachada.consultarTodosAlunos();
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno Inexistente"));
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
			fachada.consultarTodosAlunos(0, 1);
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno Inexistente"));
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorInexistenteException e)
		{
			e.printStackTrace();
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
		}catch(UsuarioInexistenteException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	// Gets e Sets
	/**
	 * @return the entidade
	 */
	public Aluno getEntidade()
	{
		return entidade;
	}
	
	/**
	 * @param entidade
	 *            the entidade to set
	 */
	public void setEntidade(Aluno entidade)
	{
		this.entidade = entidade;
	}

	/**
	 * @return the alunos
	 */
	public List<Aluno> getAlunos()
	{
		try
		{
			alunos = fachada.consultarTodosAlunosAtivos();
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno Inexistente"));
		}
		return alunos;
	}
}