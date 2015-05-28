/**
 * 
 */
package negocio;

import interfaces.dao.INotaDAO;
import interfaces.dao.IProjetoDAO;
import interfaces.negocio.IControladorNota;

import java.util.List;

import classesBasicas.Criterio;
import classesBasicas.Nota;
import classesBasicas.Professor;
import classesBasicas.Projeto;
import dao.NotaDAO;
import dao.generics.DAOFactory;
import exceptions.NotaInexistenteException;
import exceptions.PessoaExistenteException;
import exceptions.PessoaInexistenteException;
import exceptions.ProjetoExistenteException;
import exceptions.ProjetoInexistenteException;


/**
 * @author Audry Martins
 *
 */
public class ControladorNota implements IControladorNota
{
	// Atributos
	private INotaDAO notaDAO;
	
	
	private IProjetoDAO projetoDAO;
	
	// Construtores
	public ControladorNota()
	{
		super();
		notaDAO = DAOFactory.getNotaDAO();
		projetoDAO = DAOFactory.getProjetoDAO();
	}
	
	/**
	 * @param notaDAO
	 */
	public ControladorNota(INotaDAO notaDAO, IProjetoDAO projetoDAO)
	{
		super();
		this.notaDAO = notaDAO;
		this.projetoDAO = projetoDAO;
	}
	
	// Métodos
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Nota entidade) throws PessoaExistenteException,
		ProjetoExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		List<Projeto> projetoProfessores = projetoDAO
			.consultarNotasPorProjetoAvaliador(entidade.getProjeto(),
				entidade.getProfessorAvaliador());
		if(projetoProfessores == null || projetoProfessores.isEmpty())
			throw new ProjetoInexistenteException();
		List<Nota> notasProjetoCriterioProfessores = notaDAO
			.consultarNotasPorProjetoCriterioAvaliador(entidade.getProjeto(),
				entidade.getCriterio(), entidade.getProfessorAvaliador());
		if(notasProjetoCriterioProfessores == null
			|| notasProjetoCriterioProfessores.isEmpty())
			throw new NotaInexistenteException();
		notaDAO.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Nota entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
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
	public void remover(Nota entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
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
	public Nota consultarPorId(Integer id) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
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
	public List<Nota> consultarTodos() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
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
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		List<Nota> notas = notaDAO.consultarTodos(indiceInicial, quantidade);
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		return notas;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.dao.INotaDAO#consultarNotasPorProfessorOrientador(classesBasicas
	 * .Professor)
	 */
	@Override
	public List<Nota> consultarNotasPorProfessorOrientador(Professor orientador)
		throws NotaInexistenteException
	{
		List<Nota> notas = notaDAO
			.consultarNotasPorProfessorOrientador(orientador);
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		return notas;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.dao.INotaDAO#consultarNotasPorProfessorAvaliador(classesBasicas
	 * .Professor)
	 */
	@Override
	public List<Nota> consultarNotasPorProfessorAvaliador(Professor avaliador)
		throws NotaInexistenteException
	{
		List<Nota> notas = notaDAO
			.consultarNotasPorProfessorAvaliador(avaliador);
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		return notas;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.dao.INotaDAO#consultarNotasPorProfessorOrientadorAvaliador
	 * (classesBasicas.Professor, classesBasicas.Professor)
	 */
	@Override
	public List<Nota> consultarNotasPorProfessorOrientadorAvaliador(
		Professor orientador, Professor avaliador)
		throws NotaInexistenteException
	{
		List<Nota> notas = notaDAO.consultarNotasPorProfessorOrientadorAvaliador(
			orientador, avaliador);
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		return notas;
	}
	
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
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.dao.INotaDAO#consultarNotasPorProjetoCriterioOrientadorAvaliador
	 * (classesBasicas.Projeto, java.lang.String, classesBasicas.Professor,
	 * classesBasicas.Professor)
	 */
	@Override
	public List<Nota> consultarNotasPorProjetoCriterioOrientadorAvaliador(
		Projeto projeto, Criterio criterio, Professor orientador,
		Professor avaliador) throws NotaInexistenteException
	{
		List<Nota> notas = notaDAO.consultarNotasPorProjetoCriterioOrientadorAvaliador(
			projeto, criterio, orientador, avaliador);
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		return notas;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.dao.INotaDAO#consultarNotasPorCriterio(java.lang.String)
	 */
	@Override
	public List<Nota> consultarNotasPorCriterio(Criterio criterio)
		throws NotaInexistenteException
	{
		List<Nota> notas = notaDAO.consultarNotasPorCriterio(criterio);
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		return notas;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.dao.INotaDAO#consultarNotasPorProjetoCriterio(classesBasicas
	 * .Projeto, java.lang.String)
	 */
	@Override
	public List<Nota> consultarNotasPorProjetoCriterio(Projeto projeto,
		Criterio criterio) throws NotaInexistenteException
	{
		List<Nota> notas = notaDAO.consultarNotasPorProjetoCriterio(projeto, criterio);
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		return notas;
	}
	
	public List<Projeto> consultarNotasPorProjetoAvaliador(Projeto projeto,
		Professor avaliador) throws NotaInexistenteException,
		ProjetoInexistenteException
	{
		List<Projeto> projetos = projetoDAO.consultarNotasPorProjetoAvaliador(projeto,
			avaliador);
		if(projetos == null || projetos.isEmpty())
			throw new NotaInexistenteException();
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.dao.INotaDAO#consultarNotasPorProjetoCriterioAvaliador(
	 * classesBasicas.Projeto, classesBasicas.Criterio,
	 * classesBasicas.Professor)
	 */
	@Override
	public List<Nota> consultarNotasPorProjetoCriterioAvaliador(
		Projeto projeto, Criterio criterio, Professor avaliador)
		throws NotaInexistenteException
	{
		List<Nota> notas = notaDAO.consultarNotasPorProjetoCriterioAvaliador(projeto,
			criterio, avaliador);
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodosAtivos()
	 */
	@Override
	public List<Nota> consultarTodosAtivos() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		List<Nota> notas = notaDAO.consultarTodosAtivos();
		if(notas == null || notas.isEmpty())
			throw new NotaInexistenteException();
		return notas;
	}
	
	// Gets e Sets
	/**
	 * @return the notaDAO
	 */
	public INotaDAO getNotaDAO()
	{
		return notaDAO;
	}
	
	/**
	 * @param notaDAO
	 *            the notaDAO to set
	 */
	public void setNotaDAO(INotaDAO notaDAO)
	{
		this.notaDAO = notaDAO;
	}

	/**
	 * @return the projetoDAO
	 */
	public IProjetoDAO getProjetoDAO()
	{
		return projetoDAO;
	}

	/**
	 * @param projetoDAO the projetoDAO to set
	 */
	public void setProjetoDAO(IProjetoDAO projetoDAO)
	{
		this.projetoDAO = projetoDAO;
	}
}