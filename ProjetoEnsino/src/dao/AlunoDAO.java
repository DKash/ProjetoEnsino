/**
 * 
 */
package dao;

import interfaces.dao.IAlunoDAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classesBasicas.Aluno;
import dao.generics.DAOGeneric;


/**
 * @author Audry Martins
 *
 */
public class AlunoDAO extends DAOGeneric<Aluno> implements IAlunoDAO
{
	// Atributos
	
	// Construtores
	
	/**
	 * @param em
	 */
	public AlunoDAO(EntityManager em)
	{
		super(em);
	}
	
	// Métodos
	
	public Aluno consultarAlunoPorNome(String nome)
	{
		TypedQuery<Aluno> query = this.entityManager.createNamedQuery(
			"Aluno.findByName", this.classePersistente);
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
	
	public Aluno consultarAlunoPorCPF(String cpf)
	{
		TypedQuery<Aluno> query = this.entityManager.createNamedQuery(
			"Aluno.findByCPF", this.classePersistente);
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
	
	public Boolean verificarAlunoExistentePorId(int id)
	{
		Aluno aluno = consultarPorId(id);
		
		if(aluno != null)
		{
			return true;
		}
		return false;
	}
	
	public Boolean verificarAlunoExistente(Aluno aluno)
	{	
		if(consultarAlunoPorCPF(aluno.getCpf()) != null)
		{
			return true;
		}
		return false;
	}
	
	// Gets e Sets
}