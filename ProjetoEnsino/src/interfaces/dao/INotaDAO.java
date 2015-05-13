/**
 * 
 */
package interfaces.dao;

import java.util.List;

import classesBasicas.Nota;
import classesBasicas.Projeto;
import dao.generics.IDAOGeneric;
import exceptions.NotaInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface INotaDAO extends IDAOGeneric<Nota>
{
	//Métodos
	
	List<Nota> consultarNotasPorProjeto(Projeto projeto) throws NotaInexistenteException;
}