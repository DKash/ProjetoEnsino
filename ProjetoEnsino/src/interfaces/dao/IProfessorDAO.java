/**
 * 
 */
package interfaces.dao;

import classesBasicas.Professor;
import dao.generics.IDAOGeneric;
import exceptions.ProfessorInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IProfessorDAO extends IDAOGeneric<Professor>
{
	//Métodos
	
	Professor consultarProfessorPorNome(String nome) throws ProfessorInexistenteException;
	
	Professor consultarProfessorPorCPF(String cpf) throws ProfessorInexistenteException;
}