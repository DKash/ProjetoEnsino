/**
 * 
 */
package interfaces.dao;

import java.util.List;

import classesBasicas.TipoUsuario;
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
	
	List<Usuario> consultarUsuarioPorTipo(TipoUsuario tipoUsuario)
		throws PessoaInexistenteException;
	
	List<Usuario> consultarUsuarioPorTipos() throws PessoaInexistenteException;
}