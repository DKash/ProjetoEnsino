/**
 * 
 */
package interfaces.dao;

import java.util.List;

import classesBasicas.Professor;
import classesBasicas.Projeto;
import dao.generics.IDAOGeneric;
import exceptions.ProjetoInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IProjetoDAO extends IDAOGeneric<Projeto>
{
	// Métodos
	Projeto consultarProjetoPorNome(String nome)
		throws ProjetoInexistenteException;
	
	List<Projeto> consultarNotasPorProjetoAvaliador(Projeto projeto,
		Professor avaliador) throws ProjetoInexistenteException;
}