package negocio;

import interfaces.dao.IProjetoDAO;
import interfaces.negocio.IControladorProjeto;

import java.util.List;

import classesBasicas.Professor;
import classesBasicas.Projeto;
import classesBasicas.Situacao;
import dao.ProjetoDAO;
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
	public void inserir(Projeto entidade) throws PessoaExistenteException,
		ProjetoExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		Projeto resultado = ((ProjetoDAO) projetoDAO).consultarPorId(entidade.getCodigo());
			
		if(resultado != null)
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
	public void alterar(Projeto entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
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
	public void remover(Projeto entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
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
	public Projeto consultarPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		Projeto projetoConsultado = projetoDAO.consultarPorId(id);
		if(projetoConsultado == null
			|| projetoConsultado.getSituacao() != Situacao.ATIVO)
			throw new ProjetoInexistenteException();
		return projetoConsultado;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Projeto> consultarTodos() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
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
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
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
		throws ProjetoInexistenteException
	{
		Projeto projetoConsultado = projetoDAO.consultarProjetoPorNome(nome);
		if(projetoConsultado == null)
			throw new ProjetoInexistenteException();
		return projetoConsultado;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.dao.IProjetoDAO#consultarNotasPorProjetoAvaliador(classesBasicas
	 * .Projeto, classesBasicas.Professor)
	 */
	@Override
	public List<Projeto> consultarNotasPorProjetoAvaliador(Projeto projeto,
		Professor avaliador) throws ProjetoInexistenteException
	{
		List<Projeto> projetos = projetoDAO.consultarNotasPorProjetoAvaliador(
			projeto, avaliador);
		if(projetos == null || projetos.isEmpty())
			throw new ProjetoInexistenteException();
		return projetos;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodosAtivos()
	 */
	@Override
	public List<Projeto> consultarTodosAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		List<Projeto> projetos = projetoDAO.consultarTodosAtivos();
		if(projetos == null || projetos.isEmpty())
			throw new ProjetoInexistenteException();
		return projetos;
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
}