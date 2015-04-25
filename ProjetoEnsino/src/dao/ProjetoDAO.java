/**
 * 
 */
package dao;

import javax.persistence.EntityManager;

import interfaces.IProjetoDAO;
import classesBasicas.Projeto;
import dao.generics.DAOGeneric;

/**
 * @author Audry Martins
 *
 */
public class ProjetoDAO extends DAOGeneric<Projeto> implements IProjetoDAO
{
	//Atributos
	
	//Construtores
	
	/**
	 * @param em
	 */
	public ProjetoDAO(EntityManager em)
	{
		super(em);
	}
	
	//Métodos
	//Gets e Sets
}