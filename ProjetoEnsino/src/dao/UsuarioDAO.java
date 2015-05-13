/**
 * 
 */
package dao;

import interfaces.dao.IUsuarioDAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classesBasicas.Usuario;
import dao.generics.DAOGeneric;
import exceptions.UsuarioInexistenteException;

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
	
	public void efetuarLogin(Usuario usuario) throws UsuarioInexistenteException
	{
		consultarUsuarioPorNome(usuario.getNomeUsuario());		
	}
	
	public Usuario consultarUsuarioPorNome(String nome)
	{
		TypedQuery<Usuario> query = this.entityManager.createNamedQuery(
			"Usuario.findByName", this.classePersistente);
		query.setParameter("nome", nome);
		
		try
		{
			return query.setMaxResults(1).getSingleResult();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean verificarUsuarioExistentePorId(int id)
	{
		Usuario usuario = consultarPorId(id);
		
		if(usuario != null)
		{
			return true;
		}
		return false;
	}
	
	public Boolean verificarUsuarioExistente(Usuario usuario)
	{
		if(consultarUsuarioPorNome(usuario.getNomeUsuario()) != null)
		{
			return true;
		}
		return false;
	}

	//Gets e Sets
}