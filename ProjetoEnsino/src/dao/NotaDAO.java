/**
 * 
 */
package dao;

import interfaces.dao.INotaDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classesBasicas.Criterio;
import classesBasicas.Nota;
import classesBasicas.Professor;
import classesBasicas.Projeto;
import classesBasicas.Situacao;
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
	
	public List<Nota> consultarNotasPorCriterio(Criterio criterio)
	{
		TypedQuery<Nota> query = this.entityManager.createNamedQuery(
			"Nota.findNotesByCriterio", this.classePersistente);
		query.setParameter("criterio", criterio);
		try
		{
			return query.getResultList();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Nota> consultarNotasPorProjetoCriterio(Projeto projeto,
		Criterio criterio)
	{
		TypedQuery<Nota> query = this.entityManager.createNamedQuery(
			"Nota.findNotesByProjectCriterio", this.classePersistente);
		query.setParameter("projeto", projeto);
		query.setParameter("criterio", criterio);
		try
		{
			return query.getResultList();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Nota> consultarNotasPorProfessorOrientador(Professor orientador)
	{
		TypedQuery<Nota> query = this.entityManager.createNamedQuery(
			"Nota.findNotesByProfessorOrientador", this.classePersistente);
		query.setParameter("orientador", orientador);
		try
		{
			return query.getResultList();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Nota> consultarNotasPorProfessorAvaliador(Professor avaliador)
	{
		TypedQuery<Nota> query = this.entityManager.createNamedQuery(
			"Nota.findNotesByProfessorAvaliador", this.classePersistente);
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
	
	public List<Nota> consultarNotasPorProjetoCriterioAvaliador(
		Projeto projeto, Criterio criterio, Professor avaliador)
	{
		TypedQuery<Nota> query = this.entityManager.createNamedQuery(
			"Nota.findNotesByProjetoCriterioAvaliador", this.classePersistente);
		query.setParameter("projeto", projeto);
		query.setParameter("criterio", criterio);
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
	
	public List<Nota> consultarNotasPorProfessorOrientadorAvaliador(
		Professor orientador, Professor avaliador)
	{
		TypedQuery<Nota> query = this.entityManager.createNamedQuery(
			"Nota.findNotesByProfessorOrientadorAvaliador",
			this.classePersistente);
		query.setParameter("orientador", orientador);
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
	
	public List<Nota> consultarNotasPorProjetoCriterioOrientadorAvaliador(
		Projeto projeto, Criterio criterio, Professor orientador,
		Professor avaliador)
	{
		TypedQuery<Nota> query = this.entityManager.createNamedQuery(
			"Nota.findNotesByProjetoCriterioOrientadorAvaliador",
			this.classePersistente);
		query.setParameter("projeto", projeto);
		query.setParameter("criterio", criterio);
		query.setParameter("orientador", orientador);
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
	
	public List<Nota> consultarTodosAtivos()
	{
		TypedQuery<Nota> query = this.entityManager.createNamedQuery(
			"Nota.findAllActives", this.classePersistente);
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