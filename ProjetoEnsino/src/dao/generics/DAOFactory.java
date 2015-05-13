package dao.generics;

import interfaces.dao.IAlunoDAO;
import interfaces.dao.ICoordenadorDAO;
import interfaces.dao.INotaDAO;
import interfaces.dao.IProfessorDAO;
import interfaces.dao.IProjetoDAO;
import interfaces.dao.IUsuarioDAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.AlunoDAO;
import dao.CoordenadorDAO;
import dao.NotaDAO;
import dao.ProfessorDAO;
import dao.ProjetoDAO;
import dao.UsuarioDAO;

/**
 * @author Audry Martins
 *
 */
public abstract class DAOFactory
{
	//Atributos
	
	private static final EntityManagerFactory factory;
	private static IAlunoDAO alunoDAO;
	private static IProfessorDAO professorDAO;
	private static ICoordenadorDAO coordenadorDAO;
	private static IProjetoDAO projetoDAO;
	private static INotaDAO notaDAO;
	private static IUsuarioDAO usuarioDAO;
	
	static
	{
		factory = Persistence.createEntityManagerFactory("unitProjetoEnsino");
	}
	
	//Gets e Sets
	
	/**
	 * @return the alunoDAO
	 */
	public static IAlunoDAO getAlunoDAO()
	{
		alunoDAO = new AlunoDAO(factory.createEntityManager());
		return alunoDAO;
	}
	
	/**
	 * @return the professorDAO
	 */
	public static IProfessorDAO getProfessorDAO()
	{
		professorDAO = new ProfessorDAO(factory.createEntityManager());
		return professorDAO;
	}
	
	/**
	 * @return the coordenadorDAO
	 */
	public static ICoordenadorDAO getCoordenadorDAO()
	{
		coordenadorDAO = new CoordenadorDAO(factory.createEntityManager());
		return coordenadorDAO;
	}
	
	/**
	 * @return the projetoDAO
	 */
	public static IProjetoDAO getProjetoDAO()
	{
		projetoDAO = new ProjetoDAO(factory.createEntityManager());
		return projetoDAO;
	}
	
	/**
	 * @return the notaDAO
	 */
	public static INotaDAO getNotaDAO()
	{
		notaDAO = new NotaDAO(factory.createEntityManager());
		return notaDAO;
	}
	
	/**
	 * @return the usuarioDAO
	 */
	public static IUsuarioDAO getUsuarioDAO()
	{
		usuarioDAO = new UsuarioDAO(factory.createEntityManager());
		return usuarioDAO;
	}
	
	public static void close()
	{
		if(factory != null && factory.isOpen())
		{
			factory.close();
		}
	}
}