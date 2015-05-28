/**
 * 
 */
package interfaces.dao;

import java.util.List;

import classesBasicas.Professor;
import classesBasicas.TipoProfessor;
import dao.generics.IDAOGeneric;
import exceptions.PessoaInexistenteException;


/**
 * @author Audry Martins
 *
 */
public interface IProfessorDAO extends IDAOGeneric<Professor>
{
	// Métodos
	Professor consultarProfessorPorNome(String nome)
		throws PessoaInexistenteException;
	
	Professor consultarProfessorPorCPF(String cpf)
		throws PessoaInexistenteException;
	
	List<Professor> consultarProfessorPorTipoProfessor(
		TipoProfessor tipoProfessor) throws PessoaInexistenteException;
}