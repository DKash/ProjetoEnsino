/**
 * 
 */
package dao;

import interfaces.dao.IUsuarioDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classesBasicas.Situacao;
import classesBasicas.Usuario;
import dao.generics.DAOGeneric;
import exceptions.PessoaInexistenteException;

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
	
	public Usuario efetuarLogin(Usuario usuario) throws PessoaInexistenteException
	{
		return consultarUsuarioPorNome(usuario.getNomeUsuario());		
	}
	
	public Usuario consultarUsuarioPorNome(String nome)
	{
		TypedQuery<Usuario> query = this.entityManager.createNamedQuery(
			"Usuario.findByNome", this.classePersistente);
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
	
	public List<Usuario> consultarTodosAtivos()
	{
		TypedQuery<Usuario> query = this.entityManager.createNamedQuery(
			"Usuario.findAllActives", this.classePersistente);
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