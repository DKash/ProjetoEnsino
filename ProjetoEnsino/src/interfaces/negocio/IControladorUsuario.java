/**
 * 
 */
package interfaces.negocio;

import interfaces.dao.IUsuarioDAO;
import classesBasicas.Usuario;
import exceptions.LoginInvalidoException;
import exceptions.PessoaInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IControladorUsuario extends IUsuarioDAO
{
	// M�todos
	Usuario efetuarLogin(Usuario usuario) throws PessoaInexistenteException,
		LoginInvalidoException;
}