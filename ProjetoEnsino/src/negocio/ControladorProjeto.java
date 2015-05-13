package negocio;

import interfaces.dao.IProjetoDAO;
import interfaces.negocio.IControladorProjeto;

import java.util.List;

import classesBasicas.Projeto;
import classesBasicas.Situacao;
import dao.ProjetoDAO;
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
public class ControladorProjeto implements IControladorProjeto
{
	// Atributos
	private IProjetoDAO projetoDAO;
	
	// Construtores
	public ControladorProjeto()
	{
		super();
		projetoDAO = DAOFactory.getProjetoDAO();
	}
	
	/**
	 * @param projetoDAO
	 */
	public ControladorProjeto(IProjetoDAO projetoDAO)
	{
		super();
		this.projetoDAO = projetoDAO;
	}
	
	// Métodos
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Projeto entidade) throws AlunoExistenteException,
		ProjetoExistenteException, ProfessorExistenteException,
		CoordenadorExistenteException, UsuarioExistenteException,
		NotaExistenteException
	{
		Boolean resultado = ((ProjetoDAO) projetoDAO)
			.verificarProjetoExistentePorId(entidade.getCodigo());
		if(resultado == true)
			throw new ProjetoExistenteException();
		entidade.setSituacao(Situacao.ATIVO);
		projetoDAO.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Projeto entidade) throws AlunoInexistenteException,
		ProjetoInexistenteException, CoordenadorInexistenteException,
		UsuarioInexistenteException, ProfessorInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((ProjetoDAO) projetoDAO)
			.verificarProjetoExistentePorId(entidade.getCodigo());
		if(resultado == false)
			throw new ProjetoInexistenteException();
		projetoDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Projeto entidade) throws AlunoInexistenteException,
		ProjetoInexistenteException, CoordenadorInexistenteException,
		UsuarioInexistenteException, ProfessorInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((ProjetoDAO) projetoDAO)
			.verificarProjetoExistentePorId(entidade.getCodigo());
		if(resultado == false)
			throw new ProjetoInexistenteException();
		if(entidade.getProfessoresAvaliadores() == null
			|| entidade.getProfessoresAvaliadores().isEmpty())
			throw new ProjetoInexistenteException();
		entidade.setSituacao(Situacao.INATIVO);
		projetoDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Projeto consultarPorId(Integer id) throws AlunoInexistenteException,
		ProjetoInexistenteException
	{
		Projeto projetoConsultado = consultarPorId(id);
		if(projetoConsultado == null || projetoConsultado.getSituacao() != Situacao.ATIVO)
			throw new ProjetoInexistenteException();
		
		return projetoConsultado;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Projeto> consultarTodos() throws AlunoInexistenteException,
		ProjetoInexistenteException, ProfessorInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException,
		NotaInexistenteException
	{
		List<Projeto> projetos = projetoDAO.consultarTodos();
		if(projetos == null || projetos.isEmpty())
			throw new ProjetoInexistenteException();
		
		return projetos;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Projeto> consultarTodos(Integer indiceInicial,
		Integer quantidade) throws AlunoInexistenteException,
		ProjetoInexistenteException, ProfessorInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException,
		NotaInexistenteException
	{
		List<Projeto> projetos = projetoDAO.consultarTodos(indiceInicial,
			quantidade);
		if(projetos == null || projetos.isEmpty())
			throw new ProjetoInexistenteException();
		
		return projetos;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.dao.IProjetoDAO#consultarProjetoPorNome(java.lang.String)
	 */
	@Override
	public Projeto consultarProjetoPorNome(String nome)
		throws AlunoInexistenteException, ProjetoInexistenteException
	{
		Projeto projetoConsultado = projetoDAO.consultarProjetoPorNome(nome);
		if(projetoConsultado == null)
			throw new ProjetoInexistenteException();
		
		return projetoConsultado;
	}
	
	// Gets e Sets
	/**
	 * @return the projetoDAO
	 */
	public IProjetoDAO getProjetoDAO()
	{
		return projetoDAO;
	}
	
	/**
	 * @param projetoDAO
	 *            the projetoDAO to set
	 */
	public void setProjetoDAO(IProjetoDAO projetoDAO)
	{
		this.projetoDAO = projetoDAO;
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodosAtivos()
	 */
	@Override
	public List<Projeto> consultarTodosAtivos()
		throws AlunoInexistenteException
	{
		return projetoDAO.consultarTodosAtivos();
	}
}