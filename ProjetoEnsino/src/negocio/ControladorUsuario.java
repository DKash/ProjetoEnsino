/**
 * 
 */
package negocio;

import interfaces.dao.IUsuarioDAO;
import interfaces.negocio.IControladorUsuario;

import java.util.List;

import classesBasicas.Situacao;
import classesBasicas.Usuario;
import dao.UsuarioDAO;
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
public class ControladorUsuario implements IControladorUsuario
{
	// Atributos
	
	private IUsuarioDAO usuarioDAO;
	
	// Construtores
	
	public ControladorUsuario()
	{
		super();
	
		usuarioDAO = DAOFactory.getUsuarioDAO();
	}
	
	/**
	 * @param usuaarioDAO
	 */
	public ControladorUsuario(IUsuarioDAO usuarioDAO)
	{
		super();
		
		this.usuarioDAO = usuarioDAO;
	}
	
	// Métodos
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Usuario entidade) throws AlunoExistenteException,
		ProfessorExistenteException, CoordenadorExistenteException,
		ProjetoExistenteException, UsuarioExistenteException,
		NotaExistenteException
	{
		Boolean resultado = ((UsuarioDAO) usuarioDAO)
			.verificarUsuarioExistentePorId(entidade.getCodigo());
		if(resultado == true)
			throw new UsuarioExistenteException();
		
		usuarioDAO.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Usuario entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, ProfessorInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((UsuarioDAO) usuarioDAO)
			.verificarUsuarioExistentePorId(entidade.getCodigo());
		if(resultado == false)
			throw new UsuarioInexistenteException();
		
		usuarioDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Usuario entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, ProfessorInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((UsuarioDAO) usuarioDAO)
			.verificarUsuarioExistentePorId(entidade.getCodigo());
		if(resultado == false)
			throw new UsuarioInexistenteException();
		
		entidade.setSituacao(Situacao.INATIVO);
		usuarioDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Usuario consultarPorId(Integer id) throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((UsuarioDAO) usuarioDAO)
			.verificarUsuarioExistentePorId(id);
		if(resultado == false)
			throw new UsuarioInexistenteException();
		
		return usuarioDAO.consultarPorId(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Usuario> consultarTodos() throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException,
		NotaInexistenteException
	{
		List<Usuario> usuarios = usuarioDAO.consultarTodos();
		if(usuarios == null || usuarios.isEmpty())
			throw new UsuarioInexistenteException();
		
		return usuarios;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Usuario> consultarTodos(Integer indiceInicial,
		Integer quantidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException,
		NotaInexistenteException
	{
		List<Usuario> usuarios = usuarioDAO.consultarTodos(indiceInicial,
			quantidade);
		if(usuarios == null || usuarios.isEmpty())
			throw new UsuarioInexistenteException();
		
		return usuarios;
	}
	

	/* (non-Javadoc)
	 * @see interfaces.negocio.IControladorUsuario#efetuarLogin(classesBasicas.Usuario)
	 */
	@Override
	public void efetuarLogin(Usuario usuario) throws UsuarioInexistenteException
	{
		Usuario usuarioConsultado = usuarioDAO.consultarUsuarioPorNome(usuario.getNomeUsuario());
		
		if(usuarioConsultado == null)
			throw new UsuarioInexistenteException();
		
		usuarioDAO.efetuarLogin(usuario);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.dao.IUsuarioDAO#consultarUsuarioPorNome(java.lang.String)
	 */
	@Override
	public Usuario consultarUsuarioPorNome(String nome)
		throws UsuarioInexistenteException
	{
		Usuario usuario = usuarioDAO.consultarUsuarioPorNome(nome);
		if(usuario == null || usuario.getSituacao() != Situacao.ATIVO)
			throw new UsuarioInexistenteException();
		
		return usuario;
	}
	
	// Gets e Sets
	/**
	 * @return the usuarioDAO
	 */
	public IUsuarioDAO getUsuarioDAO()
	{
		return usuarioDAO;
	}
	
	/**
	 * @param usuarioDAO
	 *            the usuarioDAO to set
	 */
	public void setUsuarioDAO(IUsuarioDAO usuarioDAO)
	{
		this.usuarioDAO = usuarioDAO;
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodosAtivos()
	 */
	@Override
	public List<Usuario> consultarTodosAtivos()
		throws AlunoInexistenteException
	{ 
		return usuarioDAO.consultarTodosAtivos();
	}
}