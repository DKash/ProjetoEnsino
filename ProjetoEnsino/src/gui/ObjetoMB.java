/**
 * 
 */
package gui;

import interfaces.negocio.IFachada;
import negocio.Fachada;

/**
 * @author Audry Martins
 *
 */
public abstract class ObjetoMB<Entidade>
{
	// Atributos
	protected IFachada fachada = Fachada.getInstancia();
	
	// Métodos
	public abstract String inserir();
	
	/*public abstract void editar(ActionEvent actionEvent);*/
	
	public abstract String alterar();
	
	public abstract String remover();
	
	public abstract String consultarPorId();
	
	public abstract String consultarTodos();
	
	public abstract String consultarTodosComParametros();
	
	public abstract String consultarPorNome();
	
	public abstract String consultarPorCPF();
	
	public abstract String consultarTodosAtivos();
	
	public abstract String novo();
	
	public String exibirIndex()
	{
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String exibirMenu()
	{
		return "/menu.xhtml?faces-redirect=true";
	}
	
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