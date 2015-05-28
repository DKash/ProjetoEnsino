/**
 * 
 */
package gui;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import classesBasicas.Aluno;
import classesBasicas.Professor;
import classesBasicas.Projeto;
import classesBasicas.Resultado;
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
@ViewScoped
public class CadastroProjetoMB extends CadastroPessoaMB
{
	// Atributos
	
	private Projeto entidade = new Projeto();
	private List<Projeto> projetos;
	private List<Professor> orientadores;
	private List<Professor> avaliadores;
	private List<Aluno> alunos;
	
	@PostConstruct
	public void init()
	{
		/*try
		{
			projetos = fachada.consultarTodosProjetos();	
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Inexistente"));
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Pessoa Inexistente"));
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
			fachada.inserirProjeto(entidade);
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto salvo com sucesso"));
		}catch(ProjetoExistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Existente"));
		}catch(PessoaExistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaExistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Inexistente"));
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
			fachada.alterarProjeto(entidade);
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto alterado com sucesso"));
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Inexistente"));
		}catch(PessoaInexistenteException e)
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
			fachada.removerProjeto(entidade);
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto excluído com sucesso"));
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Inexistente"));
		}catch(PessoaInexistenteException e)
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
			fachada.consultarProjetoPorId(entidade.getCodigo());
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Inexistente"));
		}catch(PessoaInexistenteException e)
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
			fachada.consultarTodosProjetos();
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Inexistente"));
		}catch(PessoaInexistenteException e)
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
			fachada.consultarTodosProjetos(0, 1);
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Inexistente"));
		}catch(PessoaInexistenteException e)
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
	 * @see gui.ObjetoMB#consultarTodosAtivos()
	 */
	@Override
	public String consultarTodosAtivos()
	{
		try
		{
			fachada.consultarTodosProjetosAtivos();
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Inexistente"));
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Pessoa Inexistente"));
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
			fachada.consultarProjetoPorNome(entidade.getNome());
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Inexistente"));
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
		entidade = new Projeto();
		return "/projeto/CadastroProjeto.xhtml?faces-redirect=true";
		/*return "#{msgs.urlCadastroProjeto}";*/
	}
	
	// Métodos
	public void onRowEdit(RowEditEvent event)
	{
		try
		{
			fachada.alterarProjeto((Projeto) event.getObject());
			FacesMessage msg = new FacesMessage("Projeto Editado",
				((Projeto) event.getObject()).getCodigo().toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Pessoa Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesMessage msg = new FacesMessage("Não foi possível alterar ",
				((Projeto) event.getObject()).getNome());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
	}
	
	public void onRowRemove(RowEditEvent event)
	{
		try
		{
			fachada.removerProjeto((Projeto) event.getObject());
			FacesMessage msg = new FacesMessage("Projeto Removido",
				((Projeto) event.getObject()).getNome());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Pessoa Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesMessage msg = new FacesMessage("Não foi possível remover ",
				((Projeto) event.getObject()).getNome());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
	}
	
	public void onRowCancel(RowEditEvent event)
	{
		FacesMessage msg = new FacesMessage("Edição Cancelada",
			((Projeto) event.getObject()).getCodigo().toString());
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
		try
		{
			avaliadores = fachada
				.consultarProfessorPorTipoProfessor(TipoProfessor.AVALIADOR);
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Avaliador Inexistente"));
		}
		return avaliadores;
	}
	
	/**
	 * @param avaliadores
	 *            the avaliadores to set
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
		try
		{
			projetos = fachada.consultarTodosProjetos();
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Inexistente"));
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Pessoa Inexistente"));
		}catch(NotaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}
		return projetos;
	}
	
	/**
	 * @param projetos
	 *            the projetos to set
	 */
	public void setProjetos(List<Projeto> projetos)
	{
		this.projetos = projetos;
	}
	
	public Resultado[] getResultados()
	{
		return Resultado.values();
	}
	
	/**
	 * @return the alunos
	 */
	public List<Aluno> getAlunos()
	{
		try
		{
			return fachada.consultarTodosAlunos();
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
		return alunos;
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
	 * @return the orientadores
	 */
	public List<Professor> getOrientadores()
	{
		try
		{
			orientadores = fachada
				.consultarProfessorPorTipoProfessor(TipoProfessor.ORIENTADOR);
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Orientador Inexistente"));
		}
		return orientadores;
	}
	
	/**
	 * @param orientadores
	 *            the orientadores to set
	 */
	public void setOrientadores(List<Professor> orientadores)
	{
		this.orientadores = orientadores;
	}
}