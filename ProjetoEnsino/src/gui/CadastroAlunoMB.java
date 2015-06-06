/**
 * 
 */
package gui;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import classesBasicas.Aluno;
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
public class CadastroAlunoMB extends ObjetoMB<Aluno>
{
	// Atributos
	
	private Aluno entidade = new Aluno();
	private List<Aluno> alunos;
	
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
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno salvo com sucesso"));
		}catch(PessoaExistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno Inexistente"));
		}catch(ProjetoExistenteException e)
		{
			/* e.printStackTrace(); */
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
	 * @see manangedBeans.CadastroPessoaMB#alterar()
	 */
	@Override
	public String alterar()
	{
		try
		{
			fachada.alterarAluno(entidade);
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno salvo com sucesso"));
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno Inexistente"));
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
	 * @see manangedBeans.CadastroPessoaMB#remover()
	 */
	@Override
	public String remover()
	{
		try
		{
			fachada.removerAluno(entidade);
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno excluído com sucesso"));
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno Inexistente"));
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
			fachada.consultarAlunoPorId(entidade.getCodigo());
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno Inexistente"));
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
			fachada.consultarTodosAlunos();
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno Inexistente"));
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
			fachada.consultarTodosAlunos(0, 1);
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno Inexistente"));
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
	 * public String consultarAlunosPorNome() { try {
	 * fachada.consultarAlunoPorNome(entidade.getNome());
	 * }catch(PessoaInexistenteException e) { e.printStackTrace();
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage("Aluno Inexistente")); } return null; }
	 */
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
			fachada.consultarAlunoPorNome(entidade.getNome());
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno Inexistente"));
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
			fachada.consultarAlunoPorCPF(entidade.getCpf());
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno Inexistente"));
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
			fachada.consultarTodosAlunosAtivos();
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
		return "";
	}
	
	public String novo()
	{
		entidade = new Aluno();
		return "/aluno/CadastroAluno.xhtml?faces-redirect=true";
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
	 * @param alunos
	 *            the alunos to set
	 */
	public void setAlunos(List<Aluno> alunos)
	{
		this.alunos = alunos;
	}
	
	/**
	 * @return the alunos
	 */
	public List<Aluno> getAlunos()
	{
		try
		{
			alunos = fachada.consultarTodosAlunosAtivos();
		}catch(PessoaInexistenteException e)
		{
			/*e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Aluno Inexistente"));*/
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
		return alunos;
	}
}