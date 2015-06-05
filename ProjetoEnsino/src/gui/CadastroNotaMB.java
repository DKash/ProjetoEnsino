/**
 * 
 */
package gui;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import classesBasicas.Criterio;
import classesBasicas.Nota;
import classesBasicas.Professor;
import classesBasicas.Projeto;
import classesBasicas.Resultado;
import classesBasicas.TipoProfessor;
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
public class CadastroNotaMB extends ObjetoMB<Nota>
{
	// Atributos
	
	private Nota entidade = new Nota();	
	private List<Nota> notas;
	private List<Projeto> projetos;
	private List<Professor> avaliadores;
	private List<Professor> orientadores;
	
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
			fachada.inserirNota(entidade);
			entidade = new Nota();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota salva com sucesso"));
		}catch(ProjetoExistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(PessoaExistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Professor Avaliador Não pode atribuir nota"));
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Criterio Existente"));
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
			fachada.alterarNota(entidade);
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota alterada com sucesso"));
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(PessoaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
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
			fachada.removerNota(entidade);
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota excluída com sucesso"));
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(PessoaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
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
			fachada.consultarNotaPorId(entidade.getCodigo());
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(PessoaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
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
			fachada.consultarTodosNota();
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(PessoaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
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
			fachada.consultarTodosNota(0, 1);
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(PessoaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
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
			fachada.consultarTodosNotasAtivas();
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
		}catch(PessoaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(ProjetoInexistenteException e)
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
		entidade = new Nota();
		return "/projeto/CadastroNota.xhtml";
		// return "#{msgs.urlCadastroNota}";
	}
	
	public String consultarPorProjeto(Projeto projeto)
	{
		try
		{
			fachada.consultarNotasPorProjeto(projeto);
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
		}
		return "";
	}
	
	public String consultarPorCriterio(String criterio)
	{
		try
		{
			fachada.consultarNotasPorCriterio(entidade.getCriterio());
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
		}
		return "";
	}
	
	public String consultarPorAvaliador(Professor avaliador)
	{
		try
		{
			fachada.consultarNotasPorProfessorAvaliador(avaliador);
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
		}
		return "";
	}
	
	public String consultarPorOrientador(Professor orientador)
	{
		try
		{
			fachada.consultarNotasPorProfessorOrientador(orientador);
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
		}
		return "";
	}
	
	public String consultarPorOrientadorAvaliador(Professor orientador,
		Professor avaliador)
	{
		try
		{
			fachada.consultarNotasPorProfessorOrientadorAvaliador(orientador,
				avaliador);
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
		}
		return "";
	}
	
	public String consultarPorProjetoAvaliador(Projeto projeto,
		Professor avaliador)
	{
		try
		{
			fachada.consultarNotasPorProjetoAvaliador(projeto, avaliador);
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
		}
		return "";
	}
	
	public String consultarPorProjetoCriterio(Projeto projeto, Criterio criterio)
	{
		try
		{
			fachada.consultarNotasPorProjetoCriterio(projeto, criterio);
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
		}
		return "";
	}
	
	public String consultarPorProjetoCriterioOrientadorAvaliador(
		Projeto projeto, Criterio criterio, Professor orientador,
		Professor avaliador)
	{
		try
		{
			fachada.consultarNotasPorProjetoCriterioOrientadorAvaliador(
				projeto, criterio, orientador, avaliador);
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
		}
		return "";
	}
	
	// Gets e Sets
	/**
	 * @return the entidade
	 */
	public Nota getEntidade()
	{
		return entidade;
	}
	
	/**
	 * @param entidade
	 *            the entidade to set
	 */
	public void setEntidade(Nota entidade)
	{
		this.entidade = entidade;
	}
	
	/**
	 * @return the notas
	 */
	public List<Nota> getNotas()
	{
		try
		{
			notas = fachada.consultarTodosNota();
		}catch(PessoaInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(ProjetoInexistenteException e)
		{
			/* e.printStackTrace(); */
		}catch(NotaInexistenteException e)
		{
			/*
			 * e.printStackTrace();
			 * FacesContext.getCurrentInstance().addMessage(null, new
			 * FacesMessage("Nota Inexistente"));
			 */
		}
		return notas;
	}
	
	public Resultado[] getResultados()
	{
		return Resultado.values();
	}
	
	/**
	 * @param notas
	 *            the notas to set
	 */
	public void setNotas(List<Nota> notas)
	{
		this.notas = notas;
	}
	
	/**
	 * @return the projetos
	 */
	public List<Projeto> getProjetos()
	{
		try
		{
			projetos = fachada.consultarTodosProjetosAtivos();
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Pessoa Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			/*
			 * e.printStackTrace();
			 * FacesContext.getCurrentInstance().addMessage(null, new
			 * FacesMessage("Projeto Inexistente"));
			 */
		}catch(NotaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
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
	
	public Criterio[] getCriterios()
	{
		return Criterio.values();
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
				new FacesMessage("Professor Inexistente"));
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
				new FacesMessage("Professor Inexistente"));
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