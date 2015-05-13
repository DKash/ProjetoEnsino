/**
 * 
 */
package negocio;

import interfaces.dao.IProfessorDAO;
import interfaces.negocio.IControladorProfessor;

import java.util.List;

import classesBasicas.Professor;
import classesBasicas.Situacao;
import dao.ProfessorDAO;
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
	public void inserir(Professor entidade) throws ProfessorExistenteException,
		AlunoExistenteException, CoordenadorExistenteException,
		ProjetoExistenteException, UsuarioExistenteException,
		NotaExistenteException
	{
		Boolean resultado = ((ProfessorDAO) professorDAO)
			.verificarProfessorExistente(entidade);
		if(resultado == true)
			throw new ProfessorExistenteException();
		
		entidade.setSituacao(Situacao.ATIVO);
		professorDAO.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Professor entidade)
		throws ProfessorInexistenteException, AlunoInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException
	{
		Boolean resultado = ((ProfessorDAO) professorDAO)
			.verificarProfessorExistente(entidade);
		if(resultado == false)
			throw new ProfessorInexistenteException();
		
		professorDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Professor entidade)
		throws ProfessorInexistenteException, AlunoInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException
	{
		Professor professorConsultado = professorDAO
			.consultarProfessorPorCPF(entidade.getCpf());
		if(professorConsultado == null)
			throw new ProfessorInexistenteException();
		
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
		throws ProfessorInexistenteException, AlunoInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		CoordenadorInexistenteException, NotaInexistenteException
	{
		Professor professorConsultado = (Professor) professorDAO
			.consultarPorId(id);
		if(professorConsultado == null
			|| professorConsultado.getSituacao() != Situacao.ATIVO)
			throw new ProfessorInexistenteException();
		
		return professorConsultado;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Professor> consultarTodos()
		throws ProfessorInexistenteException, AlunoInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		CoordenadorInexistenteException, NotaInexistenteException
	{
		List<Professor> professores = professorDAO.consultarTodos();
		for(Professor p : professores)
		{
			if(p.getSituacao() != Situacao.ATIVO)
				throw new ProfessorInexistenteException();
		}
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
		Integer quantidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException,
		NotaInexistenteException
	{
		List<Professor> professores = professorDAO.consultarTodos(
			indiceInicial, quantidade);
		for(Professor p : professores)
		{
			if(p.getSituacao() != Situacao.ATIVO)
				throw new ProfessorInexistenteException();
		}
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
		throws ProfessorInexistenteException
	{
		Professor professor = professorDAO.consultarProfessorPorNome(nome);
		if(professor == null || professor.getSituacao() != Situacao.ATIVO)
			throw new ProfessorInexistenteException();
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
		throws ProfessorInexistenteException
	{
		Professor professor = professorDAO.consultarProfessorPorCPF(cpf);
		if(professor == null || professor.getSituacao() != Situacao.ATIVO)
			throw new ProfessorInexistenteException();
		
		return professor;
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

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodosAtivos()
	 */
	@Override
	public List<Professor> consultarTodosAtivos()
		throws AlunoInexistenteException
	{
		return professorDAO.consultarTodosAtivos();
	}
}