/**
 * 
 */
package interfaces.negocio;

import classesBasicas.Projeto;
import exceptions.ProjetoInexistenteException;
import interfaces.dao.IProjetoDAO;

/**
 * @author Audry Martins
 *
 */
public interface IControladorProjeto extends IProjetoDAO
{
	// Métodos
	Projeto consultarProjetoPorNome(String nome)
		throws ProjetoInexistenteException;
}