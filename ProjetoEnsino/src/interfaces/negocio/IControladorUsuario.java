/**
 * 
 */
package interfaces.negocio;

import interfaces.dao.IUsuarioDAO;
import classesBasicas.Usuario;
import exceptions.UsuarioInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IControladorUsuario extends IUsuarioDAO
{
	//Métodos
	
	void efetuarLogin(Usuario usuario) throws UsuarioInexistenteException;
}