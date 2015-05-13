/**
 * 
 */
package negocio;

import interfaces.dao.INotaDAO;
import interfaces.negocio.IControladorNota;

import java.util.List;

import classesBasicas.Nota;
import classesBasicas.Projeto;
import dao.NotaDAO;
import dao.generics.DAOFactory;
import exceptions.AlunoExistenteException;
import exceptions.AlunoInexistenteException;
import exceptions.CoordenadorExistenteException;
import exceptions.CoordenadorInexistenteException;
import exceptions.NotaExistenteException;
import exceptions.NotaInexistenteException;
import exceptions.ProfessorExistenteException;
import exceptions.ProfessorInexistenteException;
import exceptions.ProjetoExistenteException;
import exceptions.ProjetoInexistenteException;
import exceptions.UsuarioExistenteException;
import exceptions.UsuarioInexistenteException;


/**
 * @author Audry Martins
 *
 */
public class ControladorNota implements IControladorNota
{
	// Atributos
	
	private INotaDAO notaDAO;
	
	// Construtores
	
	public ControladorNota()
	{
		super();
	
		notaDAO = DAOFactory.getNotaDAO();
	}
	
	/**
	 * @param notaDAO
	 */
	public ControladorNota(INotaDAO notaDAO)
	{
		super();
		
		this.notaDAO = notaDAO;
	}
	
	// Métodos
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Nota entidade) throws AlunoExistenteException,
		ProfessorExistenteException, CoordenadorExistenteException,
		ProjetoExistenteException, UsuarioExistenteException,
		NotaExistenteException
	{
		Boolean resultado = ((NotaDAO) notaDAO)
			.verificarNotaExistentePorId(entidade.getCodigo());
		if(resultado == true)
			throw new NotaExistenteException();
		
		notaDAO.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Nota entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, ProfessorInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((NotaDAO) notaDAO)
			.verificarNotaExistentePorId(entidade.getCodigo());
		if(resultado == false)
			throw new NotaInexistenteException();
		
		notaDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Nota entidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, CoordenadorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException
	{
		Nota notaConsultada = ((NotaDAO) notaDAO).consultarPorId(entidade
			.getCodigo());
		if(notaConsultada == null)
			throw new NotaInexistenteException();
		
		entidade.setCodigo(notaConsultada.getCodigo());
		notaDAO.remover(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Nota consultarPorId(Integer id) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException
	{
		Nota notaConsultada = (Nota) notaDAO.consultarPorId(id);
		if(notaConsultada == null)
			throw new NotaInexistenteException();
		
		return notaConsultada;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Nota> consultarTodos() throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException
	{
		List<Nota> notas = notaDAO.consultarTodos();
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		
		return notas;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Nota> consultarTodos(Integer indiceInicial, Integer quantidade)
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException
	{
		List<Nota> notas = notaDAO.consultarTodos(indiceInicial, quantidade);
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		
		return notas;
	}
	
	// Gets e Sets
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.dao.INotaDAO#consultarNotasPorProjeto(classesBasicas.Projeto)
	 */
	@Override
	public List<Nota> consultarNotasPorProjeto(Projeto projeto)
		throws NotaInexistenteException
	{
		List<Nota> notas = notaDAO.consultarNotasPorProjeto(projeto);
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		
		return notas;
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodosAtivos()
	 */
	@Override
	public List<Nota> consultarTodosAtivos() throws AlunoInexistenteException
	{
		return notaDAO.consultarTodosAtivos();
	}
}