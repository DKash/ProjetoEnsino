/**
 * 
 */
package manangedBeans;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedProperty;


/**
 * @author Audry Martins
 *
 */
public class ComandosMB
{
	// Atributos
	
	@ManagedProperty("#{msg}")
	private ResourceBundle bundle;
	
	// Métodos
	
	public String exibirIndex()
	{
		return bundle.getString("msg.urlPaginaInicial");
	}
	
	public String exibirMenu()
	{
		return bundle.getString("msg.urlMenu");
	}
	
	public String exibirCadastroAluno()
	{
		return bundle.getString("msg.urlCadastroAluno");
	}
	
	// Gets e Sets
}