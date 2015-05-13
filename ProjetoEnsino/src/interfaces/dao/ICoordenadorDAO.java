/**
 * 
 */
package interfaces.dao;

import classesBasicas.Coordenador;
import dao.generics.IDAOGeneric;
import exceptions.CoordenadorInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface ICoordenadorDAO extends IDAOGeneric<Coordenador>
{
	//Métodos
	
	Coordenador consultarCoordenadorPorNome(String nome) throws CoordenadorInexistenteException;
	
	Coordenador consultarCoordenadorPorCPF(String cpf) throws CoordenadorInexistenteException;
}