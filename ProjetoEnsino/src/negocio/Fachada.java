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
	public void inserirAluno(Aluno entidade) throws AlunoExistenteException,
		ProfessorExistenteException, CoordenadorExistenteException,
		ProjetoExistenteException, UsuarioExistenteException, NotaExistenteException
	{
		controladorAluno.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#alterarAluno(classesBasicas.Aluno)
	 */
	@Override
	public void alterarAluno(Aluno entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, ProfessorInexistenteException, NotaInexistenteException
	{
		controladorAluno.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#removerAluno(classesBasicas.Aluno)
	 */
	@Override
	public void removerAluno(Aluno entidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, CoordenadorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
	{
		return controladorAluno.consultarPorId(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosAlunos()
	 */
	@Override
	public List<Aluno> consultarTodosAlunos() throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
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
		Integer quantidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
	{
		return controladorAluno.consultarTodos(indiceInicial, quantidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosAlunosAtivos()
	 */
	@Override
	public List<Aluno> consultarTodosAlunosAtivos() throws AlunoInexistenteException
	{
		return controladorAluno.consultarTodosAtivos();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#inserirCoordenador(classesBasicas.Coordenador
	 * )
	 */
	@Override
	public void inserirCoordenador(Coordenador entidade)
		throws AlunoExistenteException, ProfessorExistenteException,
		CoordenadorExistenteException, ProjetoExistenteException,
		UsuarioExistenteException, NotaExistenteException
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
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, ProfessorInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
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
		Integer quantidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
	{
		return controladorCoordenador.consultarTodos(indiceInicial, quantidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * interfaces.negocio.IFachada#inserirProfessor(classesBasicas.Professor)
	 */
	@Override
	public void inserirProfessor(Professor entidade)
		throws AlunoExistenteException, ProfessorExistenteException,
		CoordenadorExistenteException, ProjetoExistenteException,
		UsuarioExistenteException, NotaExistenteException
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
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, ProfessorInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
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
		Integer quantidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
	{
		return controladorProfessor.consultarTodos(indiceInicial, quantidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#inserirProjeto(classesBasicas.Projeto)
	 */
	@Override
	public void inserirProjeto(Projeto entidade)
		throws AlunoExistenteException, ProfessorExistenteException,
		CoordenadorExistenteException, ProjetoExistenteException,
		UsuarioExistenteException, NotaExistenteException
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
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, ProfessorInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
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
		Integer quantidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
	{
		return controladorProjeto.consultarTodos(indiceInicial, quantidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#inserirUsuario(classesBasicas.Usuario)
	 */
	@Override
	public void inserirUsuario(Usuario entidade)
		throws AlunoExistenteException, ProfessorExistenteException,
		CoordenadorExistenteException, ProjetoExistenteException,
		UsuarioExistenteException, NotaExistenteException
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
		throws AlunoInexistenteException, CoordenadorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, ProfessorInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
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
		Integer quantidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
	{
		return controladorUsuario.consultarTodos(indiceInicial, quantidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#efetuarLogin(classesBasicas.Usuario)
	 */
	@Override
	public void efetuarLogin(Usuario usuario)
		throws UsuarioInexistenteException
	{
		controladorUsuario.efetuarLogin(usuario);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#inserirNota(classesBasicas.Nota)
	 */
	@Override
	public void inserirNota(Nota entidade) throws AlunoExistenteException,
		ProfessorExistenteException, CoordenadorExistenteException,
		ProjetoExistenteException, UsuarioExistenteException, NotaExistenteException
	{
		controladorNota.inserir(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#alterarNota(classesBasicas.Nota)
	 */
	@Override
	public void alterarNota(Nota entidade) throws AlunoInexistenteException,
		CoordenadorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, ProfessorInexistenteException, NotaInexistenteException
	{
		controladorNota.alterar(entidade);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#removerNota(classesBasicas.Nota)
	 */
	@Override
	public void removerNota(Nota entidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, CoordenadorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, NotaInexistenteException
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
		throws AlunoInexistenteException, ProfessorInexistenteException,
		ProjetoInexistenteException, UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
	{
		return controladorNota.consultarPorId(id);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.negocio.IFachada#consultarTodosNota()
	 */
	@Override
	public List<Nota> consultarTodosNota() throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
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
		Integer quantidade) throws AlunoInexistenteException,
		ProfessorInexistenteException, ProjetoInexistenteException,
		UsuarioInexistenteException, CoordenadorInexistenteException, NotaInexistenteException
	{
		return controladorNota.consultarTodos(indiceInicial, quantidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarNotasPorProjeto(classesBasicas.Projeto)
	 */
	@Override
	public List<Nota> consultarNotasPorProjeto(Projeto projeto)
		throws NotaInexistenteException
	{
		return controladorNota.consultarNotasPorProjeto(projeto);
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