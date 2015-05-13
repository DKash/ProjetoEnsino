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
	public void inserir(Coordenador entidade)
		throws CoordenadorExistenteException, AlunoExistenteException,
		ProfessorExistenteException, ProjetoExistenteException,
		UsuarioExistenteException, NotaExistenteException
	{
		Boolean resultado = ((CoordenadorDAO) coordenadorDAO)
			.verificarCoordenadorExistente(entidade);
		if(resultado == true)
			throw new CoordenadorExistenteException();
		
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
		throws CoordenadorInexistenteException, AlunoInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		ProfessorInexistenteException, NotaInexistenteException
	{
		Boolean resultado = ((CoordenadorDAO) coordenadorDAO)
			.verificarCoordenadorExistente(entidade);
		if(resultado == false)
			throw new CoordenadorInexistenteException();
		
		coordenadorDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Coordenador entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, ProfessorInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((CoordenadorDAO) coordenadorDAO)
			.verificarCoordenadorExistente(entidade);
		if(resultado == false)
			throw new CoordenadorInexistenteException();
		
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
		throws CoordenadorInexistenteException, AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException
	{
		Coordenador coordenadorConsultado = (Coordenador) coordenadorDAO
			.consultarPorId(id);
		if(coordenadorConsultado == null
			|| coordenadorConsultado.getSituacao() != Situacao.ATIVO)
			throw new CoordenadorInexistenteException();
		
		return coordenadorConsultado;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Coordenador> consultarTodos()
		throws CoordenadorInexistenteException, ProfessorInexistenteException,
		AlunoInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException
	{
		List<Coordenador> coordenadores = coordenadorDAO.consultarTodos();
		for(Coordenador c : coordenadores)
		{
			if(c.getSituacao() != Situacao.ATIVO)
				throw new CoordenadorInexistenteException();
		}
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
		Integer quantidade) throws CoordenadorInexistenteException,
		AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException
	{
		List<Coordenador> coordenadores = coordenadorDAO.consultarTodos(
			indiceInicial, quantidade);
		for(Coordenador c : coordenadores)
		{
			if(c.getSituacao() != Situacao.ATIVO)
				throw new CoordenadorInexistenteException();
		}
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
		throws CoordenadorInexistenteException
	{
		Coordenador coordenador = coordenadorDAO
			.consultarCoordenadorPorNome(nome);
		if(coordenador == null || coordenador.getSituacao() != Situacao.ATIVO)
			throw new CoordenadorInexistenteException();
		
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
		throws CoordenadorInexistenteException
	{
		Coordenador coordenador = coordenadorDAO
			.consultarCoordenadorPorCPF(cpf);
		if(coordenador == null || coordenador.getSituacao() != Situacao.ATIVO)
			throw new CoordenadorInexistenteException();
		
		return coordenador;
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

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodosAtivos()
	 */
	@Override
	public List<Coordenador> consultarTodosAtivos()
		throws AlunoInexistenteException
	{
		return coordenadorDAO.consultarTodosAtivos();
	}
}