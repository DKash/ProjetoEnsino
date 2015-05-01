package negocio;

import java.util.List;

import classesBasicas.Projeto;
import interfaces.dao.IProjetoDAO;
import interfaces.negocio.IControladorProjeto;
import dao.ProjetoDAO;

/**
 * @author Audry Martins
 *
 */
public class ControladorProjeto implements IControladorProjeto
{
	//Atributos
	
	private IProjetoDAO projetoDAO;

	//Construtores
	
	public ControladorProjeto()
	{
		super();
		
		this.projetoDAO = new ProjetoDAO(null);
	}
	
	/**
	 * @param projetoDAO
	 */
	public ControladorProjeto(IProjetoDAO projetoDAO)
	{
		super();
		
		this.projetoDAO = projetoDAO;
	}

	//Métodos
	
	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Projeto entidade)
	{
		projetoDAO.inserir(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Projeto entidade)
	{
		projetoDAO.alterar(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Projeto entidade)
	{
		projetoDAO.remover(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Projeto consultarPorId(Integer id)
	{
		return consultarPorId(id);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Projeto> consultarTodos()
	{
		return projetoDAO.consultarTodos();
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodos(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Projeto> consultarTodos(Integer indiceInicial,
		Integer quantidade)
	{
		return projetoDAO.consultarTodos(indiceInicial, quantidade);
	}
	
	//Gets e Sets
	/**
	 * @return the projetoDAO
	 */
	public IProjetoDAO getProjetoDAO()
	{
		return projetoDAO;
	}

	/**
	 * @param projetoDAO the projetoDAO to set
	 */
	public void setProjetoDAO(IProjetoDAO projetoDAO)
	{
		this.projetoDAO = projetoDAO;
	}
}