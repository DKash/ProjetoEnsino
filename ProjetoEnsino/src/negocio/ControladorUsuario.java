/**
 * 
 */
package negocio;

import java.util.List;

import classesBasicas.Usuario;
import interfaces.dao.IUsuarioDAO;
import interfaces.negocio.IControladorUsuario;
import dao.UsuarioDAO;

/**
 * @author Audry Martins
 *
 */
public class ControladorUsuario implements IControladorUsuario
{
	//Atributos
	
	private IUsuarioDAO usuarioDAO;

	//Construtores
	
	public ControladorUsuario()
	{
		super();
		
		this.usuarioDAO = new UsuarioDAO(null);
	}
	
	/**
	 * @param usuaarioDAO
	 */
	public ControladorUsuario(IUsuarioDAO usuaarioDAO)
	{
		super();
		this.usuarioDAO = usuaarioDAO;
	}
	
	//Métodos
	
	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#inserir(java.lang.Object)
	 */
	@Override
	public void inserir(Usuario entidade)
	{
		usuarioDAO.inserir(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#alterar(java.lang.Object)
	 */
	@Override
	public void alterar(Usuario entidade)
	{
		usuarioDAO.alterar(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#remover(java.lang.Object)
	 */
	@Override
	public void remover(Usuario entidade)
	{
		usuarioDAO.remover(entidade);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Usuario consultarPorId(Integer id)
	{
		return usuarioDAO.consultarPorId(id);
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodos()
	 */
	@Override
	public List<Usuario> consultarTodos()
	{
		return usuarioDAO.consultarTodos();
	}

	/* (non-Javadoc)
	 * @see dao.generics.IDAOGeneric#consultarTodos(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Usuario> consultarTodos(Integer indiceInicial,
		Integer quantidade)
	{
		return usuarioDAO.consultarTodos(indiceInicial, quantidade);
	}
	
	//Gets e Sets
	/**
	 * @return the usuarioDAO
	 */
	public IUsuarioDAO getUsuarioDAO()
	{
		return usuarioDAO;
	}

	/**
	 * @param usuarioDAO the usuarioDAO to set
	 */
	public void setUsuarioDAO(IUsuarioDAO usuarioDAO)
	{
		this.usuarioDAO = usuarioDAO;
	}
}