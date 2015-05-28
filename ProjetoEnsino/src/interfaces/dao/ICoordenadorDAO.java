/**
 * 
 */
package interfaces.dao;

import classesBasicas.Coordenador;
import dao.generics.IDAOGeneric;
import exceptions.PessoaInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface ICoordenadorDAO extends IDAOGeneric<Coordenador>
{
	// Métodos
	Coordenador consultarCoordenadorPorNome(String nome)
		throws PessoaInexistenteException;
	
	Coordenador consultarCoordenadorPorCPF(String cpf)
		throws PessoaInexistenteException;
}