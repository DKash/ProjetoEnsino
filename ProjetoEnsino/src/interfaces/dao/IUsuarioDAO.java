/**
 * 
 */
package interfaces.dao;

import classesBasicas.Usuario;
import dao.generics.IDAOGeneric;
import exceptions.UsuarioInexistenteException;


/**
 * @author Audry Martins
 *
 */
public interface IUsuarioDAO extends IDAOGeneric<Usuario>
{
	// Métodos
	
	void efetuarLogin(Usuario usuario) throws UsuarioInexistenteException;
	
	Usuario consultarUsuarioPorNome(String nome)
		throws UsuarioInexistenteException;
}