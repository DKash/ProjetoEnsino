/**
 * 
 */
package gui;

import negocio.Fachada;
import interfaces.negocio.IFachada;

/**
 * @author Audry Martins
 *
 */
public abstract class ObjetoMB
{
	// Atributos
	protected IFachada fachada = Fachada.getInstancia();
	
	// Métodos
	public abstract String inserir();
	
	public abstract String alterar();
	
	public abstract String remover();
	
	public abstract String consultarPorId();
	
	public abstract String consultarTodos();
	
	public abstract String consultarTodosComParametros();
	
	public abstract String consultarPorNome();
	
	public abstract String consultarPorCPF();
	
	public abstract String consultarTodosAtivos();
	
	public abstract String novo();
	
	public abstract String exibirIndex();
	
	public abstract String exibirMenu();
	
	// Gets e Sets
	/**
	 * @return the fachada
	 */
	public IFachada getFachada()
	{
		return fachada;
	}
	
	/**
	 * @param fachada
	 *            the fachada to set
	 */
	public void setFachada(IFachada fachada)
	{
		this.fachada = fachada;
	}
}