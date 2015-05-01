/**
 * 
 */
package negocio;

import java.util.List;

import classesBasicas.Professor;
import interfaces.dao.IProfessorDAO;
import interfaces.negocio.IControladorProfessor;
import dao.ProfessorDAO;

/**
 * @author Audry Martins
 *
 */
public class ControladorProfessor implements IControladorProfessor
{
	//Atributos
	
	private IProfessorDAO professorDAO;

	//Construtores
	
	public ControladorProfessor()
	{
		super();
		
		this.professorDAO = new ProfessorDAO(null);
	}
	
	/**
	 * @param professorDAO
	 */
	public ControladorProfessor(IProfessorDAO professorDAO)
	{
		super();
		
		this.professorDAO = professorDAO;
	}
	
	//Métodos
	
	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Professor entidade)
	{
		professorDAO.inserir(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Professor entidade)
	{
		professorDAO.alterar(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Professor entidade)
	{
		professorDAO.remover(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Professor consultarPorId(Integer id)
	{
		return consultarPorId(id);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Professor> consultarTodos()
	{
		return consultarTodos();
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodos(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Professor> consultarTodos(Integer indiceInicial,
		Integer quantidade)
	{
		return professorDAO.consultarTodos(indiceInicial, quantidade);
	}
	
	//Gets e Sets
	/**
	 * @return the professorDAO
	 */
	public IProfessorDAO getProfessorDAO()
	{
		return professorDAO;
	}

	/**
	 * @param professorDAO the professorDAO to set
	 */
	public void setProfessorDAO(IProfessorDAO professorDAO)
	{
		this.professorDAO = professorDAO;
	}
}