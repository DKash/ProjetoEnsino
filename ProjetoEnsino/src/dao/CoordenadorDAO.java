/**
 * 
 */
package dao;

import javax.persistence.EntityManager;

import interfaces.dao.ICoordenadorDAO;
import classesBasicas.Coordenador;
import dao.generics.DAOGeneric;

/**
 * @author Audry Martins
 *
 */
public class CoordenadorDAO extends DAOGeneric<Coordenador> implements ICoordenadorDAO
{
	//Atributos
	
	//Construtores
	
	/**
	 * @param em
	 */
	public CoordenadorDAO(EntityManager em)
	{
		super(em);
	}
	
	//M�todos
	
	//Gets e Sets
}