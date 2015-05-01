/**
 * 
 */
package negocio;

import interfaces.negocio.IControladorAluno;
import interfaces.negocio.IControladorCoordenador;
import interfaces.negocio.IControladorProfessor;
import interfaces.negocio.IControladorProjeto;
import interfaces.negocio.IControladorUsuario;
import interfaces.negocio.IFachada;

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
public class Fachada implements IFachada
{
	//Atributos
	
	private IControladorAluno controladorAluno;
	private IControladorCoordenador controladorCoordenador;
	private IControladorProfessor controladorProfessor;
	private IControladorProjeto controladorProjeto;
	private IControladorUsuario controladorUsuario;
	
	//Construtores
	
	public Fachada()
	{
		super();
		
		this.controladorAluno = new ControladorAluno();
		this.controladorCoordenador = new ControladorCoordenador();
		this.controladorProfessor = new ControladorProfessor();
		this.controladorProjeto = new ControladorProjeto();
		this.controladorUsuario = new ControladorUsuario();
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
		IControladorUsuario controladorUsuario)
	{
		super();
		
		this.controladorAluno = controladorAluno;
		this.controladorCoordenador = controladorCoordenador;
		this.controladorProfessor = controladorProfessor;
		this.controladorProjeto = controladorProjeto;
		this.controladorUsuario = controladorUsuario;
	}

	//Métodos
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#inserirAluno(classesBasicas.Aluno)
	 */
	@Override
	public void inserirAluno(Aluno entidade)
	{
		controladorAluno.inserir(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#alterarAluno(classesBasicas.Aluno)
	 */
	@Override
	public void alterarAluno(Aluno entidade)
	{
		controladorAluno.alterar(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#removerAluno(classesBasicas.Aluno)
	 */
	@Override
	public void removerAluno(Aluno entidade)
	{
		controladorAluno.remover(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarAlunoPorId(java.lang.Integer)
	 */
	@Override
	public Aluno consultarAlunoPorId(Integer id)
	{
		return controladorAluno.consultarPorId(id);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarTodosAlunos()
	 */
	@Override
	public List<Aluno> consultarTodosAlunos()
	{
		return controladorAluno.consultarTodos();
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarTodosAlunos(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Aluno> consultarTodosAlunos(Integer indiceInicial,
		Integer quantidade)
	{
		return controladorAluno.consultarTodos(indiceInicial, quantidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#inserirCoordenador(classesBasicas.Coordenador)
	 */
	@Override
	public void inserirCoordenador(Coordenador entidade)
	{
		controladorCoordenador.inserir(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#alterarCoordenador(classesBasicas.Coordenador)
	 */
	@Override
	public void alterarCoordenador(Coordenador entidade)
	{
		controladorCoordenador.alterar(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#removerCoordenador(classesBasicas.Coordenador)
	 */
	@Override
	public void removerCoordenador(Coordenador entidade)
	{
		controladorCoordenador.remover(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarCoordenadorPorId(java.lang.Integer)
	 */
	@Override
	public Coordenador consultarCoordenadorPorId(Integer id)
	{
		return controladorCoordenador.consultarPorId(id);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarTodosCoordenadores()
	 */
	@Override
	public List<Coordenador> consultarTodosCoordenadores()
	{
		return controladorCoordenador.consultarTodos();
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarTodosCoordenadores(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Coordenador> consultarTodosCoordenadores(Integer indiceInicial,
		Integer quantidade)
	{
		return controladorCoordenador.consultarTodos(indiceInicial, quantidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#inserirProfessor(classesBasicas.Professor)
	 */
	@Override
	public void inserirProfessor(Professor entidade)
	{
		controladorProfessor.inserir(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#alterarProfessor(classesBasicas.Professor)
	 */
	@Override
	public void alterarProfessor(Professor entidade)
	{
		controladorProfessor.alterar(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#removerProfessor(classesBasicas.Professor)
	 */
	@Override
	public void removerProfessor(Professor entidade)
	{
		controladorProfessor.remover(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarProfessorPorId(java.lang.Integer)
	 */
	@Override
	public Professor consultarProfessorPorId(Integer id)
	{
		return controladorProfessor.consultarPorId(id);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarTodosProfessores()
	 */
	@Override
	public List<Professor> consultarTodosProfessores()
	{
		return controladorProfessor.consultarTodos();
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarTodosProfessores(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Professor> consultarTodosProfessores(Integer indiceInicial,
		Integer quantidade)
	{
		return controladorProfessor.consultarTodos(indiceInicial, quantidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#inserirProjeto(classesBasicas.Projeto)
	 */
	@Override
	public void inserirProjeto(Projeto entidade)
	{
		controladorProjeto.inserir(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#alterarProjeto(classesBasicas.Projeto)
	 */
	@Override
	public void alterarProjeto(Projeto entidade)
	{
		controladorProjeto.alterar(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#removerProjeto(classesBasicas.Projeto)
	 */
	@Override
	public void removerProjeto(Projeto entidade)
	{
		controladorProjeto.remover(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarProjetoPorId(java.lang.Integer)
	 */
	@Override
	public Projeto consultarProjetoPorId(Integer id)
	{
		return controladorProjeto.consultarPorId(id);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarTodosProjetos()
	 */
	@Override
	public List<Projeto> consultarTodosProjetos()
	{
		return controladorProjeto.consultarTodos();
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarTodosProjetos(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Projeto> consultarTodosProjetos(Integer indiceInicial,
		Integer quantidade)
	{
		return controladorProjeto.consultarTodos(indiceInicial, quantidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#inserirUsuario(classesBasicas.Usuario)
	 */
	@Override
	public void inserirUsuario(Usuario entidade)
	{
		controladorUsuario.inserir(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#alterarUsuario(classesBasicas.Usuario)
	 */
	@Override
	public void alterarUsuario(Usuario entidade)
	{
		controladorUsuario.alterar(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#removerUsuario(classesBasicas.Usuario)
	 */
	@Override
	public void removerUsuario(Usuario entidade)
	{
		controladorUsuario.remover(entidade);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarUsuarioPorId(java.lang.Integer)
	 */
	@Override
	public Usuario consultarUsuarioPorId(Integer id)
	{
		return controladorUsuario.consultarPorId(id);
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarTodosUsuarios()
	 */
	@Override
	public List<Usuario> consultarTodosUsuarios()
	{
		return controladorUsuario.consultarTodos();
	}
	
	/* (non-Javadoc)
	 * @see interfaces.negocio.IFachada#consultarTodosUsuarios(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Usuario> consultarTodosUsuarios(Integer indiceInicial,
		Integer quantidade)
	{
		return controladorUsuario.consultarTodos(indiceInicial, quantidade);
	}
	
	//Gets e Sets
	/**
	 * @return the controladorAluno
	 */
	public IControladorAluno getControladorAluno()
	{
		return controladorAluno;
	}

	/**
	 * @param controladorAluno the controladorAluno to set
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
	 * @param controladorCoordenador the controladorCoordenador to set
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
	 * @param controladorProfessor the controladorProfessor to set
	 */
	public void setControladorProfessor(IControladorProfessor controladorProfessor)
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
	 * @param controladorProjeto the controladorProjeto to set
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
	 * @param controladorUsuario the controladorUsuario to set
	 */
	public void setControladorUsuario(IControladorUsuario controladorUsuario)
	{
		this.controladorUsuario = controladorUsuario;
	}
}