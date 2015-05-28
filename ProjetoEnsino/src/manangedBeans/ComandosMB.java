/**
 * 
 */
package manangedBeans;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 * @author Audry Martins
 *
 */
@ManagedBean
public class ComandosMB
{
	// Atributos
	
	@ManagedProperty("#{msgs}")
	private ResourceBundle bundle;
	
	// Métodos
	
	public String exibirIndex()
	{
		return bundle.getString("urlPaginaInicial");
	}
	
	public String exibirMenu()
	{
		return bundle.getString("urlMenu");
	}
	
	public String exibirCadastroAluno()
	{
		return bundle.getString("urlCadastroAluno");
	}
	
	public String exibirCadastroProfessor()
	{
		return bundle.getString("urlCadastroProfessor");
	}
	
	public String exibirCadastroCoordenador()
	{
		return bundle.getString("urlCadastroCoordenador");
	}
	
	public String exibirCadastroProjeto()
	{
		return bundle.getString("urlCadastroProjeto");
	}
	
	public String exibirCadastroNota()
	{
		return bundle.getString("urlCadastroNota");
	}
	
	public String exibirCadastroUsuario()
	{
		return bundle.getString("urlCadastroUsuario");
	}
	
	// Gets e Sets
}