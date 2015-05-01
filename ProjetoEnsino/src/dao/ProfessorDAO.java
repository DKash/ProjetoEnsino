/**
 * 
 */
package dao;

import javax.persistence.EntityManager;

import interfaces.dao.IProfessorDAO;
import classesBasicas.Professor;
import dao.generics.DAOGeneric;

/**
 * @author Audry Martins
 *
 */
public class ProfessorDAO extends DAOGeneric<Professor> implements IProfessorDAO
{

	//Atributos
	
	//Construtores
	
	/**
	 * @param em
	 */
	public ProfessorDAO(EntityManager em)
	{
		super(em);
	}
	
	//Métodos
	//Gets e Sets
}