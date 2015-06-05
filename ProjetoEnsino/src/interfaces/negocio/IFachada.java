/**
 * 
 */
package interfaces.negocio;

import java.util.List;

import classesBasicas.Aluno;
import classesBasicas.Coordenador;
import classesBasicas.Criterio;
import classesBasicas.Nota;
import classesBasicas.Professor;
import classesBasicas.Projeto;
import classesBasicas.TipoProfessor;
import classesBasicas.Usuario;
import exceptions.LoginInvalidoException;
import exceptions.NotaExistenteException;
import exceptions.NotaInexistenteException;
import exceptions.PessoaExistenteException;
import exceptions.PessoaInexistenteException;
import exceptions.ProjetoExistenteException;
import exceptions.ProjetoInexistenteException;


/**
 * @author Audry Martins
 *
 */
public interface IFachada
{
	// Métodos
	// Aluno
	void inserirAluno(Aluno entidade) throws PessoaExistenteException,
		ProjetoExistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	void alterarAluno(Aluno entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	void removerAluno(Aluno entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	Aluno consultarAlunoPorId(Integer id) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	List<Aluno> consultarTodosAlunos() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	List<Aluno> consultarTodosAlunos(Integer indiceInicial, Integer quantidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	Aluno consultarAlunoPorNome(String nome) throws PessoaInexistenteException;
	
	Aluno consultarAlunoPorCPF(String cpf) throws PessoaInexistenteException;
	
	List<Aluno> consultarTodosAlunosAtivos() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	// Coordenador
	void inserirCoordenador(Coordenador entidade)
		throws PessoaExistenteException, ProjetoExistenteException,
		NotaExistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	void alterarCoordenador(Coordenador entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	void removerCoordenador(Coordenador entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	Coordenador consultarCoordenadorPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	List<Coordenador> consultarTodosCoordenadores()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	List<Coordenador> consultarTodosCoordenadores(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	Coordenador consultarCoordenadorPorNome(String nome)
		throws PessoaInexistenteException;
	
	Coordenador consultarCoordenadorPorCPF(String cpf)
		throws PessoaInexistenteException;
	
	List<Coordenador> consultarTodosCoordenadoresAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	// Professor
	void inserirProfessor(Professor entidade) throws PessoaExistenteException,
		ProjetoExistenteException, NotaExistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	void alterarProfessor(Professor entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	void removerProfessor(Professor entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	Professor consultarProfessorPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	List<Professor> consultarTodosProfessores()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	List<Professor> consultarTodosProfessores(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	Professor consultarProfessorPorNome(String nome)
		throws PessoaInexistenteException;
	
	Professor consultarProfessorPorCPF(String cpf)
		throws PessoaInexistenteException;
	
	List<Professor> consultarTodosProfessoresAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	List<Professor> consultarProfessorPorTipoProfessor(
		TipoProfessor tipoProfessor) throws PessoaInexistenteException;
	
	// Projeto
	void inserirProjeto(Projeto entidade) throws PessoaExistenteException,
		ProjetoExistenteException, NotaExistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	void alterarProjeto(Projeto entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	void removerProjeto(Projeto entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	Projeto consultarProjetoPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	List<Projeto> consultarTodosProjetos() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	List<Projeto> consultarTodosProjetos(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	List<Projeto> consultarTodosProjetosAtivos()
		throws ProjetoInexistenteException, PessoaInexistenteException,
		NotaInexistenteException;
	
	Projeto consultarProjetoPorNome(String nome)
		throws ProjetoInexistenteException;
	
	List<Projeto> consultarNotasPorProjetoAvaliador(Projeto projeto,
		Professor avaliador) throws ProjetoInexistenteException;
	
	// Usuario
	void inserirUsuario(Usuario entidade) throws PessoaExistenteException,
		ProjetoExistenteException, NotaExistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	void alterarUsuario(Usuario entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	void removerUsuario(Usuario entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	Usuario consultarUsuarioPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	List<Usuario> consultarTodosUsuarios() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	List<Usuario> consultarTodosUsuarios(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	Usuario efetuarLogin(Usuario usuario) throws PessoaInexistenteException,
		LoginInvalidoException;
	
	List<Usuario> consultarTodosUsuariosAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	Usuario consultarUsuarioPorNome(String nome)
		throws PessoaInexistenteException;
	
	// Nota
	void inserirNota(Nota entidade) throws PessoaExistenteException,
		ProjetoExistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	void alterarNota(Nota entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	void removerNota(Nota entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	Nota consultarNotaPorId(Integer id) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	List<Nota> consultarTodosNota() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException;
	
	List<Nota> consultarTodosNota(Integer indiceInicial, Integer quantidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException;
	
	List<Nota> consultarNotasPorProjeto(Projeto projeto)
		throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorProfessorOrientador(Professor orientador)
		throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorProfessorAvaliador(Professor avaliador)
		throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorProfessorOrientadorAvaliador(
		Professor orientador, Professor avaliador)
		throws NotaInexistenteException;
	
	List<Nota> consultarTodosNotasAtivas() throws NotaInexistenteException,
		PessoaInexistenteException, ProjetoInexistenteException;
	
	List<Nota> consultarNotasPorCriterio(Criterio criterio)
		throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorProjetoCriterio(Projeto projeto,
		Criterio criterio) throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorProjetoCriterioOrientadorAvaliador(
		Projeto projeto, Criterio criterio, Professor orientador,
		Professor avaliador) throws NotaInexistenteException;
}