/**
 * 
 */
package interfaces.dao;

import classesBasicas.Aluno;
import dao.generics.IDAOGeneric;
import exceptions.PessoaInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IAlunoDAO extends IDAOGeneric<Aluno>
{
	// Métodos
	Aluno consultarAlunoPorNome(String nome) throws PessoaInexistenteException;
	
	Aluno consultarAlunoPorCPF(String cpf) throws PessoaInexistenteException;
}