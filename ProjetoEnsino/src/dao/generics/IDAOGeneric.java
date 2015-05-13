package dao.generics;

import java.util.List;

import exceptions.AlunoExistenteException;
import exceptions.AlunoInexistenteException;
import exceptions.CoordenadorExistenteException;
import exceptions.CoordenadorInexistenteException;
import exceptions.NotaExistenteException;
import exceptions.NotaInexistenteException;
import exceptions.ProfessorExistenteException;
import exceptions.ProfessorInexistenteException;
import exceptions.ProjetoExistenteException;
import exceptions.ProjetoInexistenteException;
import exceptions.UsuarioExistenteException;
import exceptions.UsuarioInexistenteException;


/**
 * @author Audry Martins
 *
 */
public interface IDAOGeneric<Entidade>
{
	void inserir(Entidade entidade) throws AlunoExistenteException,
		ProfessorExistenteException, CoordenadorExistenteException,
		ProjetoExistenteException, UsuarioExistenteException,
		NotaExistenteException;
	
	void alterar(Entidade entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, ProfessorInexistenteException,
		NotaInexistenteException;
	
	void remover(Entidade entidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, CoordenadorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	Entidade consultarPorId(Integer id) throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException,
		NotaInexistenteException;
	
	List<Entidade> consultarTodos() throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException,
		NotaInexistenteException;
	
	List<Entidade> consultarTodos(Integer indiceInicial, Integer quantidade)
		throws AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		CoordenadorInexistenteException, NotaInexistenteException;
	
	List<Entidade> consultarTodosAtivos() throws AlunoInexistenteException;
}