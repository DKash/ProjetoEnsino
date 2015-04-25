/**
 * 
 */
package dao;

import javax.persistence.EntityManager;

import interfaces.IAlunoDAO;
import classesBasicas.Aluno;
import dao.generics.DAOGeneric;

/**
 * @author Audry Martins
 *
 */
public class AlunoDAO extends DAOGeneric<Aluno> implements IAlunoDAO
{
	
	//Atributos

	//Construtores
	
	/**
	 * @param em
	 */
	public AlunoDAO(EntityManager em)
	{
		super(em);
	}	
	
	//Métodos
	
	//Gets e Sets
}