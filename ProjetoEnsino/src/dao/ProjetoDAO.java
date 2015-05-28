/**
 * 
 */
package dao;

import interfaces.dao.IProjetoDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classesBasicas.Professor;
import classesBasicas.Projeto;
import classesBasicas.Situacao;
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
	
	public List<Projeto> consultarNotasPorProjetoAvaliador(Projeto projeto,
		Professor avaliador)
	{
		TypedQuery<Projeto> query = this.entityManager.createNamedQuery(
			"Projeto.findNotesByProjetoAvaliador", this.classePersistente);
		query.setParameter("projeto", projeto);
		query.setParameter("avaliador", avaliador);
		try
		{
			return query.getResultList();
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
	
	public List<Projeto> consultarTodosAtivos()
	{
		TypedQuery<Projeto> query = this.entityManager.createNamedQuery(
			"Projeto.findAllActives", this.classePersistente);
		query.setParameter("situacao", Situacao.ATIVO);
		
		try
		{
			return query.getResultList();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	//Gets e Sets
}