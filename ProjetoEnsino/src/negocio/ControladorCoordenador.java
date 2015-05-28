/**
 * 
 */
package negocio;

import interfaces.dao.ICoordenadorDAO;
import interfaces.negocio.IControladorCoordenador;

import java.util.List;

import classesBasicas.Coordenador;
import classesBasicas.Situacao;
import dao.CoordenadorDAO;
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
public class ControladorCoordenador implements IControladorCoordenador
{
	// Atributos
	private ICoordenadorDAO coordenadorDAO;
	
	// Construtores
	public ControladorCoordenador()
	{
		super();
		coordenadorDAO = DAOFactory.getCoordenadorDAO();
	}
	
	/**
	 * @param coordenadorDAO
	 */
	public ControladorCoordenador(ICoordenadorDAO coordenadorDAO)
	{
		super();
		this.coordenadorDAO = coordenadorDAO;
	}
	
	// Métodos
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Coordenador entidade) throws PessoaExistenteException,
		ProjetoExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((CoordenadorDAO) coordenadorDAO)
			.verificarCoordenadorExistente(entidade);
		if(resultado == true)
			throw new PessoaExistenteException();
		entidade.setSituacao(Situacao.ATIVO);
		coordenadorDAO.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Coordenador entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((CoordenadorDAO) coordenadorDAO)
			.verificarCoordenadorExistente(entidade);
		if(resultado == false)
			throw new PessoaInexistenteException();
		coordenadorDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Coordenador entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((CoordenadorDAO) coordenadorDAO)
			.verificarCoordenadorExistente(entidade);
		if(resultado == false)
			throw new PessoaInexistenteException();
		entidade.setSituacao(Situacao.INATIVO);
		coordenadorDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Coordenador consultarPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		Coordenador coordenadorConsultado = (Coordenador) coordenadorDAO
			.consultarPorId(id);
		if(coordenadorConsultado == null
			|| coordenadorConsultado.getSituacao() != Situacao.ATIVO)
			throw new PessoaInexistenteException();
		return coordenadorConsultado;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Coordenador> consultarTodos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		List<Coordenador> coordenadores = coordenadorDAO.consultarTodos();
		if(coordenadores == null || coordenadores.isEmpty())
			throw new PessoaInexistenteException();
		return coordenadores;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Coordenador> consultarTodos(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		List<Coordenador> coordenadores = coordenadorDAO.consultarTodos(
			indiceInicial, quantidade);
		if(coordenadores == null || coordenadores.isEmpty())
			throw new PessoaInexistenteException();
		return coordenadores;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.dao.ICoordenadorDAO#consultarCoordenadorPorNome(java.lang.
	 * String)
	 */
	@Override
	public Coordenador consultarCoordenadorPorNome(String nome)
		throws PessoaInexistenteException
	{
		Coordenador coordenador = coordenadorDAO
			.consultarCoordenadorPorNome(nome);
		if(coordenador == null || coordenador.getSituacao() != Situacao.ATIVO)
			throw new PessoaInexistenteException();
		return coordenador;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.dao.ICoordenadorDAO#consultarCoordenadorPorCPF(java.lang.String
	 * )
	 */
	@Override
	public Coordenador consultarCoordenadorPorCPF(String cpf)
		throws PessoaInexistenteException
	{
		Coordenador coordenador = coordenadorDAO
			.consultarCoordenadorPorCPF(cpf);
		if(coordenador == null || coordenador.getSituacao() != Situacao.ATIVO)
			throw new PessoaInexistenteException();
		return coordenador;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodosAtivos()
	 */
	@Override
	public List<Coordenador> consultarTodosAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		List<Coordenador> coordenadores = coordenadorDAO.consultarTodosAtivos();
		if(coordenadores == null || coordenadores.isEmpty())
			throw new PessoaInexistenteException();
		return coordenadores;
	}
	
	// Gets e Sets
	/**
	 * @return the coordenadorDAO
	 */
	public ICoordenadorDAO getCoordenadorDAO()
	{
		return coordenadorDAO;
	}
	
	/**
	 * @param coordenadorDAO
	 *            the coordenadorDAO to set
	 */
	public void setCoordenadorDAO(ICoordenadorDAO coordenadorDAO)
	{
		this.coordenadorDAO = coordenadorDAO;
	}
}