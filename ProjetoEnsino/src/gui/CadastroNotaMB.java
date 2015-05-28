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
import classesBasicas.Projeto;
import classesBasicas.Resultado;
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
public class CadastroNotaMB extends CadastroPessoaMB
{
	// Atributos
	private Nota entidade = new Nota();
	
	
	private List<Nota> notas;
	
	
	private List<Projeto> projetos;
	
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
	public String consultarPorId()
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
	public String consultarPorNome()
	{
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
		entidade = new Nota();
		return "/projeto/CadastroNota.xhtml";
		//return "#{msgs.urlCadastroNota}";
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
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Nota Inexistente"));
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
			projetos = fachada.consultarTodosProjetos();
		}catch(PessoaInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Pessoa Inexistente"));
		}catch(ProjetoInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Projeto Inexistente"));
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
}