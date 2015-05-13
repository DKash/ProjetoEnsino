/**
 * 
 */
package dao;

import java.util.List;

import interfaces.dao.INotaDAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classesBasicas.Nota;
import classesBasicas.Projeto;
import dao.generics.DAOGeneric;


/**
 * @author Audry Martins
 *
 */
public class NotaDAO extends DAOGeneric<Nota> implements INotaDAO
{
	// Atributos
	
	// Construtores
	/**
	 * @param em
	 */
	public NotaDAO(EntityManager em)
	{
		super(em);
	}
	
	// Métodos
	
	@Override
	public List<Nota> consultarNotasPorProjeto(Projeto projeto)
	{
		TypedQuery<Nota> query = this.entityManager.createNamedQuery(
			"Nota.findNotesByProject", this.classePersistente);
		query.setParameter("projeto", projeto);
		try
		{
			return query.getResultList();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean verificarNotaExistentePorId(int id)
	{
		Nota nota = consultarPorId(id);
		
		if(nota != null)
		{
			return true;
		}
		return false;
	}
	
	// Gets e Sets
}