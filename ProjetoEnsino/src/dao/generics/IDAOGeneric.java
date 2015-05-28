package dao.generics;

import java.util.List;

import exceptions.NotaInexistenteException;
import exceptions.PessoaExistenteException;
import exceptions.PessoaInexistenteException;
import exceptions.ProjetoExistenteException;
import exceptions.ProjetoInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface IDAOGeneric<Entidade>
{
	void inserir(Entidade entidade) throws PessoaExistenteException,
		ProjetoExistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	void alterar(Entidade entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	void remover(Entidade entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	Entidade consultarPorId(Integer id) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	List<Entidade> consultarTodos() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	List<Entidade> consultarTodos(Integer indiceInicial, Integer quantidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	List<Entidade> consultarTodosAtivos() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
}