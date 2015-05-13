/**
 * 
 */
package interfaces.negocio;

import java.util.List;

import classesBasicas.Aluno;
import classesBasicas.Coordenador;
import classesBasicas.Nota;
import classesBasicas.Professor;
import classesBasicas.Projeto;
import classesBasicas.Usuario;
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
public interface IFachada
{
	// Métodos
	// Aluno
	
	void inserirAluno(Aluno entidade) throws AlunoExistenteException,
		ProfessorExistenteException, CoordenadorExistenteException,
		ProjetoExistenteException, UsuarioExistenteException,
		NotaExistenteException;
	
	void alterarAluno(Aluno entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	void removerAluno(Aluno entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	Aluno consultarAlunoPorId(Integer id) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	List<Aluno> consultarTodosAlunos() throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	List<Aluno> consultarTodosAlunos(Integer indiceInicial, Integer quantidade)
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException, UsuarioInexistenteException;
	
	List<Aluno> consultarTodosAlunosAtivos() throws AlunoInexistenteException;
	
	// Coordenador
	
	void inserirCoordenador(Coordenador entidade)
		throws AlunoExistenteException, ProfessorExistenteException,
		CoordenadorExistenteException, ProjetoExistenteException,
		UsuarioExistenteException, NotaExistenteException;
	
	void alterarCoordenador(Coordenador entidade)
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException;
	
	void removerCoordenador(Coordenador entidade)
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException;
	
	Coordenador consultarCoordenadorPorId(Integer id)
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException;
	
	List<Coordenador> consultarTodosCoordenadores()
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException;
	
	List<Coordenador> consultarTodosCoordenadores(Integer indiceInicial,
		Integer quantidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	// Professor
	
	void inserirProfessor(Professor entidade) throws AlunoExistenteException,
		ProfessorExistenteException, CoordenadorExistenteException,
		ProjetoExistenteException, UsuarioExistenteException,
		NotaExistenteException;
	
	void alterarProfessor(Professor entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	void removerProfessor(Professor entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	Professor consultarProfessorPorId(Integer id)
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException;
	
	List<Professor> consultarTodosProfessores()
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException;
	
	List<Professor> consultarTodosProfessores(Integer indiceInicial,
		Integer quantidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	// Projeto
	
	void inserirProjeto(Projeto entidade) throws AlunoExistenteException,
		ProfessorExistenteException, CoordenadorExistenteException,
		ProjetoExistenteException, UsuarioExistenteException,
		NotaExistenteException;
	
	void alterarProjeto(Projeto entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	void removerProjeto(Projeto entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, ProfessorInexistenteException,
		NotaInexistenteException;
	
	Projeto consultarProjetoPorId(Integer id) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	List<Projeto> consultarTodosProjetos() throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	List<Projeto> consultarTodosProjetos(Integer indiceInicial,
		Integer quantidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	// Usuario
	
	void inserirUsuario(Usuario entidade) throws AlunoExistenteException,
		ProfessorExistenteException, CoordenadorExistenteException,
		ProjetoExistenteException, UsuarioExistenteException,
		NotaExistenteException;
	
	void alterarUsuario(Usuario entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	void removerUsuario(Usuario entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, ProfessorInexistenteException,
		NotaInexistenteException;
	
	Usuario consultarUsuarioPorId(Integer id) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	List<Usuario> consultarTodosUsuarios() throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	List<Usuario> consultarTodosUsuarios(Integer indiceInicial,
		Integer quantidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	void efetuarLogin(Usuario usuario) throws UsuarioInexistenteException;
	
	// Nota
	
	void inserirNota(Nota entidade) throws AlunoExistenteException,
		ProfessorExistenteException, CoordenadorExistenteException,
		ProjetoExistenteException, UsuarioExistenteException,
		NotaExistenteException;
	
	void alterarNota(Nota entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	void removerNota(Nota entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	Nota consultarNotaPorId(Integer id) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	List<Nota> consultarTodosNota() throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException,
		NotaInexistenteException;
	
	List<Nota> consultarTodosNota(Integer indiceInicial, Integer quantidade)
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException;
	
	List<Nota> consultarNotasPorProjeto(Projeto projeto) throws NotaInexistenteException;
}