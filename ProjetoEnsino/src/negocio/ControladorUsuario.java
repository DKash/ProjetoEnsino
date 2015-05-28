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
import exceptions.LoginInvalidoException;
import exceptions.NotaInexistenteException;
import exceptions.PessoaExistenteException;
import exceptions.PessoaInexistenteException;
import exceptions.ProjetoExistenteException;
import exceptions.ProjetoInexistenteException;


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
	public void inserir(Usuario entidade) throws PessoaExistenteException,
		ProjetoExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((UsuarioDAO) usuarioDAO)
			.verificarUsuarioExistente(entidade);
		if(resultado == true)
			throw new PessoaExistenteException();
		entidade.setSituacao(Situacao.ATIVO);
		usuarioDAO.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Usuario entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		Boolean resultado = ((UsuarioDAO) usuarioDAO)
			.verificarUsuarioExistentePorId(entidade.getCodigo());
		if(resultado == false)
			throw new PessoaInexistenteException();
		usuarioDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Usuario entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		Boolean resultado = ((UsuarioDAO) usuarioDAO)
			.verificarUsuarioExistentePorId(entidade.getCodigo());
		if(resultado == false)
			throw new PessoaInexistenteException();
		entidade.setSituacao(Situacao.INATIVO);
		usuarioDAO.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Usuario consultarPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		Boolean resultado = ((UsuarioDAO) usuarioDAO)
			.verificarUsuarioExistentePorId(id);
		if(resultado == false)
			throw new PessoaInexistenteException();
		return usuarioDAO.consultarPorId(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Usuario> consultarTodos() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		List<Usuario> usuarios = usuarioDAO.consultarTodos();
		if(usuarios == null || usuarios.isEmpty())
			throw new PessoaInexistenteException();
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
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		List<Usuario> usuarios = usuarioDAO.consultarTodos(indiceInicial,
			quantidade);
		if(usuarios == null || usuarios.isEmpty())
			throw new PessoaInexistenteException();
		return usuarios;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IControladorUsuario#efetuarLogin(classesBasicas.Usuario
	 * )
	 */
	@Override
	public Usuario efetuarLogin(Usuario usuario)
		throws PessoaInexistenteException, LoginInvalidoException
	{
		Usuario usuarioConsultado = usuarioDAO.consultarUsuarioPorNome(usuario
			.getNomeUsuario());
		if(usuarioConsultado == null)
			throw new PessoaInexistenteException();
		if(!usuarioConsultado.getSenha().equals(usuario.getSenha()))
			throw new LoginInvalidoException();
		return usuarioDAO.efetuarLogin(usuario);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.dao.IUsuarioDAO#consultarUsuarioPorNome(java.lang.String)
	 */
	@Override
	public Usuario consultarUsuarioPorNome(String nome)
		throws PessoaInexistenteException
	{
		Usuario usuario = usuarioDAO.consultarUsuarioPorNome(nome);
		if(usuario == null || usuario.getSituacao() != Situacao.ATIVO)
			throw new PessoaInexistenteException();
		return usuario;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.generics.IDAOGeneric#consultarTodosAtivos()
	 */
	@Override
	public List<Usuario> consultarTodosAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		List<Usuario> usuarios = usuarioDAO.consultarTodosAtivos();
		if(usuarios == null || usuarios.isEmpty())
			throw new PessoaInexistenteException();
		return usuarios;
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
}