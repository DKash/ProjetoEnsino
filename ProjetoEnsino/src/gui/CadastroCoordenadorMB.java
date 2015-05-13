/**
 * 
 */
package gui;

import interfaces.negocio.IFachada;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import negocio.Fachada;
import classesBasicas.Coordenador;
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
public class CadastroCoordenadorMB extends CadastroPessoaMB
{
	//Atributos
	
	private Coordenador entidade = new Coordenador();
	private List<Coordenador> coordenadores;
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
			fachada.inserirCoordenador(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Coordenador salvo com sucesso"));
		}catch(AlunoExistenteException e)
		{
			e.printStackTrace();
		}catch(ProfessorExistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorExistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Coordenador Inexistente"));
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
	
	/* (non-Javadoc)
	 * @see manangedBeans.CadastroPessoaMB#alterar()
	 */
	@Override
	public String alterar()
	{
		try
		{
			fachada.alterarCoordenador(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Coordenador salvo com sucesso"));
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Coordenador Inexistente"));
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
	
	/* (non-Javadoc)
	 * @see manangedBeans.CadastroPessoaMB#remover()
	 */
	@Override
	public String remover()
	{
		try
		{
			fachada.removerCoordenador(entidade);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Coordenador excluído com sucesso"));
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Coordenador Inexistente"));
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
	
	/* (non-Javadoc)
	 * @see manangedBeans.CadastroPessoaMB#consultarPorId()
	 */
	@Override
	public String consultarPorId()
	{
		try
		{
			fachada.consultarCoordenadorPorId(entidade.getCodigo());
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Coordenador Inexistente"));
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
	
	/* (non-Javadoc)
	 * @see manangedBeans.CadastroPessoaMB#consultarTodos()
	 */
	@Override
	public String consultarTodos()
	{
		try
		{
			fachada.consultarTodosCoordenadores();
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Coordenador Inexistente"));
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
	
	/* (non-Javadoc)
	 * @see manangedBeans.CadastroPessoaMB#consultarTodosComParametros()
	 */
	@Override
	public String consultarTodosComParametros()
	{
		try
		{
			fachada.consultarTodosCoordenadores(0, 1);
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Coordenador Inexistente"));
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
	
	//Gets e Sets
	/**
	 * @return the entidade
	 */
	public Coordenador getEntidade()
	{
		return entidade;
	}

	/**
	 * @param entidade the entidade to set
	 */
	public void setEntidade(Coordenador entidade)
	{
		this.entidade = entidade;
	}

	/**
	 * @return the coordenadores
	 */
	public List<Coordenador> getCoordenadores()
	{
		try
		{
			return fachada.consultarTodosCoordenadores();
		}catch(AlunoInexistenteException e)
		{
			e.printStackTrace();
		}catch(CoordenadorInexistenteException e)
		{
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Coordenador Inexistente"));
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
		return coordenadores;
	}

	/**
	 * @param coordenadores the coordenadores to set
	 */
	public void setCoordenadores(List<Coordenador> coordenadores)
	{
		this.coordenadores = coordenadores;
	}
}