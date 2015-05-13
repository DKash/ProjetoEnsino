/**
 * 
 */
package interfaces.dao;

import classesBasicas.Aluno;
import dao.generics.IDAOGeneric;
import exceptions.AlunoInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IAlunoDAO extends IDAOGeneric<Aluno>
{
	//M�todos
	
	Aluno consultarAlunoPorNome(String nome) throws AlunoInexistenteException;
	
	Aluno consultarAlunoPorCPF(String cpf) throws AlunoInexistenteException;
}