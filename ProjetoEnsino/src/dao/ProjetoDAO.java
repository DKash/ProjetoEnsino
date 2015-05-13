/**
 * 
 */
package dao;

import interfaces.dao.IProjetoDAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	public Projeto consultarProjetoPorNome(String nome)
	{
		TypedQuery<Projeto> query = this.entityManager.createNamedQuery(
			"Projeto.findByName", this.classePersistente);
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
	
	public Boolean verificarProjetoExistentePorId(int id)
	{
		Projeto projeto = consultarPorId(id);
		
		if(projeto != null)
		{
			return true;
		}
		return false;
	}
	
	//Gets e Sets
}