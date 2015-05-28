/**
 * 
 */
package interfaces.dao;

import classesBasicas.Usuario;
import dao.generics.IDAOGeneric;
import exceptions.LoginInvalidoException;
import exceptions.PessoaInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IUsuarioDAO extends IDAOGeneric<Usuario>
{
	// Métodos
	Usuario efetuarLogin(Usuario usuario) throws PessoaInexistenteException,
		LoginInvalidoException;
	
	Usuario consultarUsuarioPorNome(String nome)
		throws PessoaInexistenteException;
}