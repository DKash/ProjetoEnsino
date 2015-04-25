/**
 * 
 */
package dao;

import javax.persistence.EntityManager;

import interfaces.IUsuarioDAO;
import classesBasicas.Usuario;
import dao.generics.DAOGeneric;

/**
 * @author Audry Martins
 *
 */
public class UsuarioDAO extends DAOGeneric<Usuario> implements IUsuarioDAO
{

	//Atributos
	
	//Construtores
	
	/**
	 * @param em
	 */
	public UsuarioDAO(EntityManager em)
	{
		super(em);
	}
	
	//Métodos
	//Gets e Sets
}