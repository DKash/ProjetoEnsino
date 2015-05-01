/**
 * 
 */
package negocio;

import interfaces.dao.ICoordenadorDAO;
import interfaces.negocio.IControladorCoordenador;

import java.util.List;

import classesBasicas.Coordenador;
import dao.CoordenadorDAO;

/**
 * @author Audry Martins
 *
 */
public class ControladorCoordenador implements IControladorCoordenador
{
	//Atributos
	
	private ICoordenadorDAO coordenadorDAO;

	//Construtores
	
	public ControladorCoordenador()
	{
		super();
		
		this.coordenadorDAO = new CoordenadorDAO(null);
	}
	
	/**
	 * @param coordenadorDAO
	 */
	public ControladorCoordenador(ICoordenadorDAO coordenadorDAO)
	{
		super();
		this.coordenadorDAO = coordenadorDAO;
	}

	//Métodos
	
	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Coordenador entidade)
	{
		coordenadorDAO.inserir(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Coordenador entidade)
	{
		coordenadorDAO.alterar(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Coordenador entidade)
	{
		coordenadorDAO.remover(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Coordenador consultarPorId(Integer id)
	{
		return coordenadorDAO.consultarPorId(id);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Coordenador> consultarTodos()
	{
		return coordenadorDAO.consultarTodos();
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodos(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Coordenador> consultarTodos(Integer indiceInicial,
		Integer quantidade)
	{
		return coordenadorDAO.consultarTodos(indiceInicial, quantidade);
	}
	
	//Gets e Sets
	/**
	 * @return the coordenadorDAO
	 */
	public ICoordenadorDAO getCoordenadorDAO()
	{
		return coordenadorDAO;
	}

	/**
	 * @param coordenadorDAO the coordenadorDAO to set
	 */
	public void setCoordenadorDAO(ICoordenadorDAO coordenadorDAO)
	{
		this.coordenadorDAO = coordenadorDAO;
	}
}