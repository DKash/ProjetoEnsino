/**
 * 
 */
package dao;

import interfaces.dao.ICoordenadorDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classesBasicas.Coordenador;
import classesBasicas.Situacao;
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
	
	//Métodos
	
	public Coordenador consultarCoordenadorPorNome(String nome)
	{
		TypedQuery<Coordenador> query = this.entityManager.createNamedQuery(
			"Coordenador.findByName", this.classePersistente);
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
	
	public Coordenador consultarCoordenadorPorCPF(String cpf)
	{
		TypedQuery<Coordenador> query = this.entityManager.createNamedQuery(
			"Coordenador.findByCPF", this.classePersistente);
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
	
	public Boolean verificarCoordenadorExistentePorId(int id)
	{
		Coordenador coordenador = consultarPorId(id);
		
		if(coordenador != null)
		{
			return true;
		}
		return false;
	}
	
	public List<Coordenador> consultarTodosAtivos()
	{
		TypedQuery<Coordenador> query = this.entityManager.createNamedQuery(
			"Coordenador.findAllActives", this.classePersistente);
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
	
	public Boolean verificarCoordenadorExistente(Coordenador coordenador)
	{
		if(consultarCoordenadorPorCPF(coordenador.getCpf()) != null)
		{
			return true;
		}
		return false;
	}
	//Gets e Sets
}