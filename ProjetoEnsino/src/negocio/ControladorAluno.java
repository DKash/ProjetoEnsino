/**
 * 
 */
package negocio;

import java.util.List;

import classesBasicas.Aluno;
import interfaces.dao.IAlunoDAO;
import interfaces.negocio.IControladorAluno;
import dao.AlunoDAO;

/**
 * @author Audry Martins
 *
 */
public class ControladorAluno implements IControladorAluno
{
	//Atributos
	
	private IAlunoDAO alunoDAO;

	//Construtores
	
	public ControladorAluno()
	{
		super();
		
		this.alunoDAO = new AlunoDAO(null);
	}
	
	/**
	 * @param alunoDAO
	 */
	public ControladorAluno(IAlunoDAO alunoDAO)
	{
		super();
		
		this.alunoDAO = alunoDAO;
	}

	//Métodos
	
	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Aluno entidade)
	{
		alunoDAO.inserir(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Aluno entidade)
	{
		alunoDAO.alterar(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Aluno entidade)
	{
		alunoDAO.remover(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Aluno consultarPorId(Integer id)
	{
		return alunoDAO.consultarPorId(id);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Aluno> consultarTodos()
	{
		return alunoDAO.consultarTodos();
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodos(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Aluno> consultarTodos(Integer indiceInicial, Integer quantidade)
	{
		return alunoDAO.consultarTodos(indiceInicial, quantidade);
	}
	
	//Gets e Sets	
	/**
	 * @return the alunoDAO
	 */
	public IAlunoDAO getAlunoDAO()
	{
		return alunoDAO;
	}

	/**
	 * @param alunoDAO the alunoDAO to set
	 */
	public void setAlunoDAO(IAlunoDAO alunoDAO)
	{
		this.alunoDAO = alunoDAO;
	}
}