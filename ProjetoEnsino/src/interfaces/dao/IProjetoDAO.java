/**
 * 
 */
package interfaces.dao;

import classesBasicas.Projeto;
import dao.generics.IDAOGeneric;
import exceptions.AlunoInexistenteException;
import exceptions.ProjetoInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IProjetoDAO extends IDAOGeneric<Projeto>
{
	//M�todos
	
	Projeto consultarProjetoPorNome(String nome) throws AlunoInexistenteException, ProjetoInexistenteException;
}