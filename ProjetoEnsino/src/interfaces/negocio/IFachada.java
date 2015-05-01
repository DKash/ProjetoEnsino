/**
 * 
 */
package interfaces.negocio;

import java.util.List;

import classesBasicas.Aluno;
import classesBasicas.Coordenador;
import classesBasicas.Professor;
import classesBasicas.Projeto;
import classesBasicas.Usuario;

/**
 * @author Audry Martins
 *
 */
public interface IFachada
{
	//Métodos
	
	//Aluno
	
	void inserirAluno(Aluno entidade);

	void alterarAluno(Aluno entidade);

	void removerAluno(Aluno entidade);
	
	Aluno consultarAlunoPorId(Integer id);
	
	List<Aluno> consultarTodosAlunos();

	List<Aluno> consultarTodosAlunos(Integer indiceInicial, Integer quantidade);
	
	//Coordenador
	
	void inserirCoordenador(Coordenador entidade);

	void alterarCoordenador(Coordenador entidade);

	void removerCoordenador(Coordenador entidade);

	Coordenador consultarCoordenadorPorId(Integer id);

	List<Coordenador> consultarTodosCoordenadores();

	List<Coordenador> consultarTodosCoordenadores(Integer indiceInicial, Integer quantidade);
	
	//Professor
	
	void inserirProfessor(Professor entidade);

	void alterarProfessor(Professor entidade);

	void removerProfessor(Professor entidade);

	Professor consultarProfessorPorId(Integer id);

	List<Professor> consultarTodosProfessores();

	List<Professor> consultarTodosProfessores(Integer indiceInicial, Integer quantidade);
	
	//Projeto
	
	void inserirProjeto(Projeto entidade);

	void alterarProjeto(Projeto entidade);

	void removerProjeto(Projeto entidade);

	Projeto consultarProjetoPorId(Integer id);

	List<Projeto> consultarTodosProjetos();

	List<Projeto> consultarTodosProjetos(Integer indiceInicial, Integer quantidade);
	
	//Usuario
	
	void inserirUsuario(Usuario entidade);

	void alterarUsuario(Usuario entidade);

	void removerUsuario(Usuario entidade);

	Usuario consultarUsuarioPorId(Integer id);

	List<Usuario> consultarTodosUsuarios();

	List<Usuario> consultarTodosUsuarios(Integer indiceInicial, Integer quantidade);
}