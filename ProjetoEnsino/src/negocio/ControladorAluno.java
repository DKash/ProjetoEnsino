/**
 * 
 */
package negocio;

import interfaces.dao.IAlunoDAO;
import interfaces.negocio.IControladorAluno;

import java.util.List;

import classesBasicas.Aluno;
import classesBasicas.Situacao;
import dao.AlunoDAO;
import dao.generics.DAOFactory;
import dao.generics.DAOGeneric;
import exceptions.NotaInexistenteException;
import exceptions.PessoaExistenteException;
import exceptions.PessoaInexistenteException;
import exceptions.ProjetoExistenteException;
import exceptions.ProjetoInexistenteException;


/**
 * @author Audry Martins
 *
 */
public class ControladorAluno implements IControladorAluno
{
	// Atributos
	private IAlunoDAO alunoDAO;
	
	// Construtores
	public ControladorAluno()
	{
		super();
		alunoDAO = DAOFactory.getAlunoDAO();
	}
	
	/**
	 * @param alunoDAO
	 */
	public ControladorAluno(IAlunoDAO alunoDAO)
	{
		super();
		this.alunoDAO = alunoDAO;
	}
	
	// Métodos
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Aluno entidade) throws PessoaExistenteException,
		ProjetoExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((AlunoDAO) alunoDAO)
			.verificarAlunoExistente(entidade);
		if(resultado == true)
			throw new PessoaExistenteException();
		entidade.setSituacao(Situacao.ATIVO);
		alunoDAO.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Aluno entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		Boolean resultado = ((AlunoDAO) alunoDAO)
			.verificarAlunoExistente(entidade);
		if(resultado == false)
			throw new PessoaInexistenteException();
		alunoDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Aluno entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		Aluno alunoConsultado = alunoDAO
			.consultarAlunoPorCPF(entidade.getCpf());
		if(alunoConsultado == null)
			throw new PessoaInexistenteException();
		entidade.setCodigo(alunoConsultado.getCodigo());
		entidade.setSituacao(Situacao.INATIVO);
		alunoDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Aluno consultarPorId(Integer id) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		Aluno alunoConsultado = (Aluno) alunoDAO.consultarPorId(id);
		if(alunoConsultado == null
			|| alunoConsultado.getSituacao() != Situacao.ATIVO)
			throw new PessoaInexistenteException();
		return alunoConsultado;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Aluno> consultarTodos() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		List<Aluno> alunos = alunoDAO.consultarTodos();
		if(alunos == null || alunos.isEmpty())
			throw new PessoaInexistenteException();
		return alunos;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Aluno> consultarTodos(Integer indiceInicial, Integer quantidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		List<Aluno> alunos = alunoDAO.consultarTodos(indiceInicial, quantidade);
		if(alunos == null || alunos.isEmpty())
			throw new PessoaInexistenteException();
		return alunos;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@SuppressWarnings("unchecked")
	public List<Aluno> consultarTodosAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		List<Aluno> alunos = ((DAOGeneric<Aluno>) alunoDAO)
			.consultarTodosAtivos();
		if(alunos == null || alunos.isEmpty())
			throw new PessoaInexistenteException();
		return alunos;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.dao.IAlunoDAO#consultarAlunoPorNome(java.lang.String)
	 */
	@Override
	public Aluno consultarAlunoPorNome(String nome)
		throws PessoaInexistenteException
	{
		Aluno aluno = alunoDAO.consultarAlunoPorNome(nome);
		if(aluno == null || aluno.getSituacao() != Situacao.ATIVO)
			throw new PessoaInexistenteException();
		return aluno;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.dao.IAlunoDAO#consultarAlunoPorCPF(java.lang.String)
	 */
	@Override
	public Aluno consultarAlunoPorCPF(String cpf)
		throws PessoaInexistenteException
	{
		Aluno alunoConsultado = alunoDAO.consultarAlunoPorCPF(cpf);
		if(alunoConsultado == null
			|| alunoConsultado.getSituacao() != Situacao.ATIVO)
			throw new PessoaInexistenteException();
		return alunoConsultado;
	}
	
	// Gets e Sets
	/**
	 * @return the alunoDAO
	 */
	public IAlunoDAO getAlunoDAO()
	{
		return alunoDAO;
	}
	
	/**
	 * @param alunoDAO
	 *            the alunoDAO to set
	 */
	public void setAlunoDAO(IAlunoDAO alunoDAO)
	{
		this.alunoDAO = alunoDAO;
	}
}