/**
 * 
 */
package dao;

import interfaces.dao.IProfessorDAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	public Professor consultarProfessorPorNome(String nome)
	{
		TypedQuery<Professor> query = this.entityManager.createNamedQuery(
			"Professor.findByName", this.classePersistente);
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
	
	public Professor consultarProfessorPorCPF(String cpf)
	{
		TypedQuery<Professor> query = this.entityManager.createNamedQuery(
			"Professor.findByCPF", this.classePersistente);
		query.setParameter("cpf", cpf);
		
		try
		{
			return query.setMaxResults(1).getSingleResult();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean verificarProfessorExistentePorId(int id)
	{
		Professor professor = consultarPorId(id);
		
		if(professor != null)
		{
			return true;
		}
		return false;
	}
	
	public Boolean verificarProfessorExistente(Professor professor)
	{
		if(consultarProfessorPorCPF(professor.getCpf()) != null)
		{
			return true;
		}
		return false;
	}

	//Gets e Sets
}