/**
 * 
 */
package negocio;

import interfaces.dao.IProfessorDAO;
import interfaces.negocio.IControladorProfessor;

import java.util.List;

import classesBasicas.Professor;
import classesBasicas.Situacao;
import classesBasicas.TipoProfessor;
import dao.ProfessorDAO;
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
public class ControladorProfessor implements IControladorProfessor
{
	// Atributos
	private IProfessorDAO professorDAO;
	
	// Construtores
	public ControladorProfessor()
	{
		super();
		professorDAO = DAOFactory.getProfessorDAO();
	}
	
	/**
	 * @param professorDAO
	 */
	public ControladorProfessor(IProfessorDAO professorDAO)
	{
		super();
		this.professorDAO = professorDAO;
	}
	
	// Métodos
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Professor entidade) throws PessoaExistenteException,
		ProjetoExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((ProfessorDAO) professorDAO)
			.verificarProfessorExistente(entidade);
		if(resultado == true)
			throw new PessoaExistenteException();
		entidade.setSituacao(Situacao.ATIVO);
		professorDAO.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Professor entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		Boolean resultado = ((ProfessorDAO) professorDAO)
			.verificarProfessorExistente(entidade);
		if(resultado == false)
			throw new PessoaInexistenteException();
		professorDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Professor entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		Professor professorConsultado = professorDAO
			.consultarProfessorPorCPF(entidade.getCpf());
		if(professorConsultado == null)
			throw new PessoaInexistenteException();
		entidade.setCodigo(professorConsultado.getCodigo());
		entidade.setSituacao(Situacao.INATIVO);
		professorDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Professor consultarPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		Professor professorConsultado = (Professor) professorDAO
			.consultarPorId(id);
		if(professorConsultado == null
			|| professorConsultado.getSituacao() != Situacao.ATIVO)
			throw new PessoaInexistenteException();
		return professorConsultado;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Professor> consultarTodos() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		List<Professor> professores = professorDAO.consultarTodos();
		if(professores == null || professores.isEmpty())
			throw new PessoaInexistenteException();
		return professores;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Professor> consultarTodos(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		List<Professor> professores = professorDAO.consultarTodos(
			indiceInicial, quantidade);
		if(professores == null || professores.isEmpty())
			throw new PessoaInexistenteException();
		return professores;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.dao.IProfessorDAO#consultarProfessorPorNome(java.lang.String)
	 */
	@Override
	public Professor consultarProfessorPorNome(String nome)
		throws PessoaInexistenteException
	{
		Professor professor = professorDAO.consultarProfessorPorNome(nome);
		if(professor == null || professor.getSituacao() != Situacao.ATIVO)
			throw new PessoaInexistenteException();
		return professor;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.dao.IProfessorDAO#consultarProfessorPorCPF(java.lang.String)
	 */
	@Override
	public Professor consultarProfessorPorCPF(String cpf)
		throws PessoaInexistenteException
	{
		Professor professor = professorDAO.consultarProfessorPorCPF(cpf);
		if(professor == null || professor.getSituacao() != Situacao.ATIVO)
			throw new PessoaInexistenteException();
		return professor;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodosAtivos()
	 */
	@Override
	public List<Professor> consultarTodosAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		List<Professor> professores = professorDAO.consultarTodosAtivos();
		if(professores == null || professores.isEmpty())
			throw new PessoaInexistenteException();
		return professores;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.dao.IProfessorDAO#consultarProfessorPorTipoProfessor(
	 * classesBasicas.TipoProfessor)
	 */
	@Override
	public List<Professor> consultarProfessorPorTipoProfessor(
		TipoProfessor tipoProfessor) throws PessoaInexistenteException
	{
		List<Professor> professores = professorDAO
			.consultarProfessorPorTipoProfessor(tipoProfessor);
		if(professores == null || professores.isEmpty())
			throw new PessoaInexistenteException();
		return professores;
	}
	
	// Gets e Sets
	/**
	 * @return the professorDAO
	 */
	public IProfessorDAO getProfessorDAO()
	{
		return professorDAO;
	}
	
	/**
	 * @param professorDAO
	 *            the professorDAO to set
	 */
	public void setProfessorDAO(IProfessorDAO professorDAO)
	{
		this.professorDAO = professorDAO;
	}
}