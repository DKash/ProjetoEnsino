/**
 * 
 */
package negocio;

import interfaces.negocio.IControladorAluno;
import interfaces.negocio.IControladorCoordenador;
import interfaces.negocio.IControladorNota;
import interfaces.negocio.IControladorProfessor;
import interfaces.negocio.IControladorProjeto;
import interfaces.negocio.IControladorUsuario;
import interfaces.negocio.IFachada;

import java.util.List;

import classesBasicas.Aluno;
import classesBasicas.Coordenador;
import classesBasicas.Criterio;
import classesBasicas.Nota;
import classesBasicas.Professor;
import classesBasicas.Projeto;
import classesBasicas.TipoProfessor;
import classesBasicas.TipoUsuario;
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
public class Fachada implements IFachada
{
	// Atributos
	private static IFachada instancia;
	
	
	private IControladorAluno controladorAluno;
	
	
	private IControladorCoordenador controladorCoordenador;
	
	
	private IControladorProfessor controladorProfessor;
	
	
	private IControladorProjeto controladorProjeto;
	
	
	private IControladorUsuario controladorUsuario;
	
	
	private IControladorNota controladorNota;
	
	// Construtores
	public Fachada()
	{
		super();
		this.controladorAluno = new ControladorAluno();
		this.controladorCoordenador = new ControladorCoordenador();
		this.controladorProfessor = new ControladorProfessor();
		this.controladorProjeto = new ControladorProjeto();
		this.controladorUsuario = new ControladorUsuario();
		this.controladorNota = new ControladorNota();
	}
	
	/**
	 * @param controladorAluno
	 * @param controladorCoordenador
	 * @param controladorProfessor
	 * @param controladorProjeto
	 * @param controladorUsuario
	 */
	public Fachada(IControladorAluno controladorAluno,
		IControladorCoordenador controladorCoordenador,
		IControladorProfessor controladorProfessor,
		IControladorProjeto controladorProjeto,
		IControladorUsuario controladorUsuario, IControladorNota controladorNota)
	{
		super();
		this.controladorAluno = controladorAluno;
		this.controladorCoordenador = controladorCoordenador;
		this.controladorProfessor = controladorProfessor;
		this.controladorProjeto = controladorProjeto;
		this.controladorUsuario = controladorUsuario;
		this.controladorNota = controladorNota;
	}
	
	// Métodos
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#inserirAluno(classesBasicas.Aluno)
	 */
	@Override
	public void inserirAluno(Aluno entidade) throws PessoaExistenteException,
		ProjetoExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorAluno.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#alterarAluno(classesBasicas.Aluno)
	 */
	@Override
	public void alterarAluno(Aluno entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		controladorAluno.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#removerAluno(classesBasicas.Aluno)
	 */
	@Override
	public void removerAluno(Aluno entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		controladorAluno.remover(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarAlunoPorId(java.lang.Integer)
	 */
	@Override
	public Aluno consultarAlunoPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorAluno.consultarPorId(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosAlunos()
	 */
	@Override
	public List<Aluno> consultarTodosAlunos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorAluno.consultarTodos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosAlunos(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Aluno> consultarTodosAlunos(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		return controladorAluno.consultarTodos(indiceInicial, quantidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosAlunosAtivos()
	 */
	@Override
	public List<Aluno> consultarTodosAlunosAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorAluno.consultarTodosAtivos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarAlunoPorNome(java.lang.String)
	 */
	@Override
	public Aluno consultarAlunoPorNome(String nome)
		throws PessoaInexistenteException
	{
		return controladorAluno.consultarAlunoPorNome(nome);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarAlunoPorCPF(java.lang.String)
	 */
	@Override
	public Aluno consultarAlunoPorCPF(String cpf)
		throws PessoaInexistenteException
	{
		return controladorAluno.consultarAlunoPorCPF(cpf);
	}
	
	// Coordenador
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#inserirCoordenador(classesBasicas.Coordenador
	 * )
	 */
	@Override
	public void inserirCoordenador(Coordenador entidade)
		throws PessoaExistenteException, ProjetoExistenteException,
		NotaExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorCoordenador.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#alterarCoordenador(classesBasicas.Coordenador
	 * )
	 */
	@Override
	public void alterarCoordenador(Coordenador entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorCoordenador.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#removerCoordenador(classesBasicas.Coordenador
	 * )
	 */
	@Override
	public void removerCoordenador(Coordenador entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorCoordenador.remover(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarCoordenadorPorId(java.lang.Integer)
	 */
	@Override
	public Coordenador consultarCoordenadorPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorCoordenador.consultarPorId(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosCoordenadores()
	 */
	@Override
	public List<Coordenador> consultarTodosCoordenadores()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorCoordenador.consultarTodos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarTodosCoordenadores(java.lang.Integer
	 * , java.lang.Integer)
	 */
	@Override
	public List<Coordenador> consultarTodosCoordenadores(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		return controladorCoordenador.consultarTodos(indiceInicial, quantidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosCoordenadoresAtivos()
	 */
	@Override
	public List<Coordenador> consultarTodosCoordenadoresAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorCoordenador.consultarTodosAtivos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarCoordenadorPorNome(java.lang.String)
	 */
	@Override
	public Coordenador consultarCoordenadorPorNome(String nome)
		throws PessoaInexistenteException
	{
		return controladorCoordenador.consultarCoordenadorPorNome(nome);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarCoordenadorPorCPF(java.lang.String)
	 */
	@Override
	public Coordenador consultarCoordenadorPorCPF(String cpf)
		throws PessoaInexistenteException
	{
		return controladorCoordenador.consultarCoordenadorPorCPF(cpf);
	}
	
	// Professor
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#inserirProfessor(classesBasicas.Professor)
	 */
	@Override
	public void inserirProfessor(Professor entidade)
		throws ProjetoExistenteException, NotaExistenteException,
		PessoaExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorProfessor.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#alterarProfessor(classesBasicas.Professor)
	 */
	@Override
	public void alterarProfessor(Professor entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorProfessor.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#removerProfessor(classesBasicas.Professor)
	 */
	@Override
	public void removerProfessor(Professor entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorProfessor.remover(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarProfessorPorId(java.lang.Integer)
	 */
	@Override
	public Professor consultarProfessorPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorProfessor.consultarPorId(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosProfessores()
	 */
	@Override
	public List<Professor> consultarTodosProfessores()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorProfessor.consultarTodos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarTodosProfessores(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Professor> consultarTodosProfessores(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		return controladorProfessor.consultarTodos(indiceInicial, quantidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosProfessorAtivos()
	 */
	@Override
	public List<Professor> consultarTodosProfessoresAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorProfessor.consultarTodosAtivos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarProfessorPorNome(java.lang.String)
	 */
	@Override
	public Professor consultarProfessorPorNome(String nome)
		throws PessoaInexistenteException
	{
		return controladorProfessor.consultarProfessorPorNome(nome);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarProfessorPorCPF(java.lang.String)
	 */
	@Override
	public Professor consultarProfessorPorCPF(String cpf)
		throws PessoaInexistenteException
	{
		return controladorProfessor.consultarProfessorPorCPF(cpf);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarProfessorPorTipoProfessor(classesBasicas.TipoProfessor)
	 */
	@Override
	public List<Professor> consultarProfessorPorTipoProfessor(
		TipoProfessor tipoProfessor) throws PessoaInexistenteException
	{
		return controladorProfessor.consultarProfessorPorTipoProfessor(tipoProfessor);
	}
	
	// Projeto
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#inserirProjeto(classesBasicas.Projeto)
	 */
	@Override
	public void inserirProjeto(Projeto entidade)
		throws PessoaExistenteException, ProjetoExistenteException,
		NotaExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorProjeto.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#alterarProjeto(classesBasicas.Projeto)
	 */
	@Override
	public void alterarProjeto(Projeto entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorProjeto.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#removerProjeto(classesBasicas.Projeto)
	 */
	@Override
	public void removerProjeto(Projeto entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorProjeto.remover(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarProjetoPorId(java.lang.Integer)
	 */
	@Override
	public Projeto consultarProjetoPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorProjeto.consultarPorId(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosProjetos()
	 */
	@Override
	public List<Projeto> consultarTodosProjetos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorProjeto.consultarTodos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarTodosProjetos(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Projeto> consultarTodosProjetos(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		return controladorProjeto.consultarTodos(indiceInicial, quantidade);
	}
	
	public Projeto consultarProjetoPorNome(String nome)
		throws ProjetoInexistenteException
	{
		return controladorProjeto.consultarProjetoPorNome(nome);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosProjetosAtivos()
	 */
	@Override
	public List<Projeto> consultarTodosProjetosAtivos()
		throws ProjetoInexistenteException, PessoaInexistenteException,
		NotaInexistenteException
	{
		return controladorProjeto.consultarTodosAtivos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarNotasPorProjetoAvaliador(classesBasicas
	 * .Projeto, classesBasicas.Professor)
	 */
	@Override
	public List<Projeto> consultarNotasPorProjetoAvaliador(Projeto projeto,
		Professor avaliador) throws ProjetoInexistenteException
	{
		return controladorProjeto.consultarNotasPorProjetoAvaliador(projeto,
			avaliador);
	}
	
	// Usuario
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#inserirUsuario(classesBasicas.Usuario)
	 */
	@Override
	public void inserirUsuario(Usuario entidade)
		throws ProjetoExistenteException, NotaExistenteException,
		PessoaExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorUsuario.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#alterarUsuario(classesBasicas.Usuario)
	 */
	@Override
	public void alterarUsuario(Usuario entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorUsuario.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#removerUsuario(classesBasicas.Usuario)
	 */
	@Override
	public void removerUsuario(Usuario entidade)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorUsuario.remover(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarUsuarioPorId(java.lang.Integer)
	 */
	@Override
	public Usuario consultarUsuarioPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorUsuario.consultarPorId(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosUsuarios()
	 */
	@Override
	public List<Usuario> consultarTodosUsuarios()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorUsuario.consultarTodos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarTodosUsuarios(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Usuario> consultarTodosUsuarios(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		return controladorUsuario.consultarTodos(indiceInicial, quantidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#efetuarLogin(classesBasicas.Usuario)
	 */
	@Override
	public Usuario efetuarLogin(Usuario usuario)
		throws PessoaInexistenteException, LoginInvalidoException
	{
		return controladorUsuario.efetuarLogin(usuario);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosUsuariosAtivos()
	 */
	@Override
	public List<Usuario> consultarTodosUsuariosAtivos()
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorUsuario.consultarTodosAtivos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarUsuarioPorNome(java.lang.String)
	 */
	@Override
	public Usuario consultarUsuarioPorNome(String nome)
		throws PessoaInexistenteException
	{
		return controladorUsuario.consultarUsuarioPorNome(nome);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarUsuarioPorTipo(classesBasicas.TipoUsuario)
	 */
	@Override
	public List<Usuario> consultarUsuarioPorTipo(TipoUsuario tipoUsuario)
		throws PessoaInexistenteException
	{
		return controladorUsuario.consultarUsuarioPorTipo(tipoUsuario);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarUsuarioPorTipos(classesBasicas.TipoUsuario, classesBasicas.TipoUsuario)
	 */
	@Override
	public List<Usuario> consultarUsuarioPorTipos() throws PessoaInexistenteException
	{
		return controladorUsuario.consultarUsuarioPorTipos();
	}
	
	// Nota
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#inserirNota(classesBasicas.Nota)
	 */
	@Override
	public void inserirNota(Nota entidade) throws PessoaExistenteException,
		ProjetoExistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		controladorNota.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#alterarNota(classesBasicas.Nota)
	 */
	@Override
	public void alterarNota(Nota entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		controladorNota.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#removerNota(classesBasicas.Nota)
	 */
	@Override
	public void removerNota(Nota entidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		controladorNota.remover(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarNotaPorId(java.lang.Integer)
	 */
	@Override
	public Nota consultarNotaPorId(Integer id)
		throws PessoaInexistenteException, ProjetoInexistenteException,
		NotaInexistenteException
	{
		return controladorNota.consultarPorId(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosNota()
	 */
	@Override
	public List<Nota> consultarTodosNota() throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		return controladorNota.consultarTodos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosNota(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Nota> consultarTodosNota(Integer indiceInicial,
		Integer quantidade) throws PessoaInexistenteException,
		ProjetoInexistenteException, NotaInexistenteException
	{
		return controladorNota.consultarTodos(indiceInicial, quantidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarNotasPorProjeto(classesBasicas.Projeto
	 * )
	 */
	@Override
	public List<Nota> consultarNotasPorProjeto(Projeto projeto)
		throws NotaInexistenteException
	{
		return controladorNota.consultarNotasPorProjeto(projeto);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosNotasAtivas()
	 */
	@Override
	public List<Nota> consultarTodosNotasAtivas()
		throws NotaInexistenteException, PessoaInexistenteException,
		ProjetoInexistenteException
	{
		return controladorNota.consultarTodosAtivos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarNotasPorCriterio(java.lang.String)
	 */
	@Override
	public List<Nota> consultarNotasPorCriterio(Criterio criterio)
		throws NotaInexistenteException
	{
		return controladorNota.consultarNotasPorCriterio(criterio);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarNotasPorProjetoCriterio(classesBasicas
	 * .Projeto, java.lang.String)
	 */
	@Override
	public List<Nota> consultarNotasPorProjetoCriterio(Projeto projeto,
		Criterio criterio) throws NotaInexistenteException
	{
		return controladorNota.consultarNotasPorProjetoCriterio(projeto,
			criterio);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarNotasPorProfessorOrientador(
	 * classesBasicas.Professor)
	 */
	@Override
	public List<Nota> consultarNotasPorProfessorOrientador(Professor orientador)
		throws NotaInexistenteException
	{
		return controladorNota.consultarNotasPorProfessorOrientador(orientador);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarNotasPorProfessorAvaliador(
	 * classesBasicas.Professor)
	 */
	@Override
	public List<Nota> consultarNotasPorProfessorAvaliador(Professor avaliador)
		throws NotaInexistenteException
	{
		return controladorNota.consultarNotasPorProfessorAvaliador(avaliador);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#consultarNotasPorProfessorOrientadorAvaliador
	 * (classesBasicas.Professor, classesBasicas.Professor)
	 */
	@Override
	public List<Nota> consultarNotasPorProfessorOrientadorAvaliador(
		Professor orientador, Professor avaliador)
		throws NotaInexistenteException
	{
		return controladorNota.consultarNotasPorProfessorOrientadorAvaliador(
			orientador, avaliador);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#
	 * consultarNotasPorProjetoCriterioOrientadorAvaliador
	 * (classesBasicas.Projeto, java.lang.String, classesBasicas.Professor,
	 * classesBasicas.Professor)
	 */
	@Override
	public List<Nota> consultarNotasPorProjetoCriterioOrientadorAvaliador(
		Projeto projeto, Criterio criterio, Professor orientador,
		Professor avaliador) throws NotaInexistenteException
	{
		return controladorNota
			.consultarNotasPorProjetoCriterioOrientadorAvaliador(projeto,
				criterio, orientador, avaliador);
	}
	
	// Gets e Sets
	// Singleton Pattern
	public static IFachada getInstancia()
	{
		if(instancia == null)
		{
			instancia = new Fachada();
		}
		return instancia;
	}
	
	/**
	 * @return the controladorAluno
	 */
	public IControladorAluno getControladorAluno()
	{
		return controladorAluno;
	}
	
	/**
	 * @param controladorAluno
	 *            the controladorAluno to set
	 */
	public void setControladorAluno(IControladorAluno controladorAluno)
	{
		this.controladorAluno = controladorAluno;
	}
	
	/**
	 * @return the controladorCoordenador
	 */
	public IControladorCoordenador getControladorCoordenador()
	{
		return controladorCoordenador;
	}
	
	/**
	 * @param controladorCoordenador
	 *            the controladorCoordenador to set
	 */
	public void setControladorCoordenador(
		IControladorCoordenador controladorCoordenador)
	{
		this.controladorCoordenador = controladorCoordenador;
	}
	
	/**
	 * @return the controladorProfessor
	 */
	public IControladorProfessor getControladorProfessor()
	{
		return controladorProfessor;
	}
	
	/**
	 * @param controladorProfessor
	 *            the controladorProfessor to set
	 */
	public void setControladorProfessor(
		IControladorProfessor controladorProfessor)
	{
		this.controladorProfessor = controladorProfessor;
	}
	
	/**
	 * @return the controladorProjeto
	 */
	public IControladorProjeto getControladorProjeto()
	{
		return controladorProjeto;
	}
	
	/**
	 * @param controladorProjeto
	 *            the controladorProjeto to set
	 */
	public void setControladorProjeto(IControladorProjeto controladorProjeto)
	{
		this.controladorProjeto = controladorProjeto;
	}
	
	/**
	 * @return the controladorUsuario
	 */
	public IControladorUsuario getControladorUsuario()
	{
		return controladorUsuario;
	}
	
	/**
	 * @param controladorUsuario
	 *            the controladorUsuario to set
	 */
	public void setControladorUsuario(IControladorUsuario controladorUsuario)
	{
		this.controladorUsuario = controladorUsuario;
	}
	
	/**
	 * @return the controladorNota
	 */
	public IControladorNota getControladorNota()
	{
		return controladorNota;
	}
	
	/**
	 * @param controladorNota
	 *            the controladorNota to set
	 */
	public void setControladorNota(IControladorNota controladorNota)
	{
		this.controladorNota = controladorNota;
	}
}