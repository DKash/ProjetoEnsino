/**
 * 
 */
package gui;

import classesBasicas.Operadora;
import classesBasicas.Sexo;
import classesBasicas.Situacao;
import classesBasicas.TipoLogradouro;
import classesBasicas.UF;


/*import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import negocio.Fachada;
import classesBasicas.Endereco;
import classesBasicas.Telefone;
import classesBasicas.Usuario;*/

/**
 * @author Audry Martins
 *
 */
public abstract class CadastroPessoaMB
{
	//Métodos
	
	public abstract String inserir();
	
	public abstract String alterar();
	
	public abstract String remover();
	
	public abstract String consultarPorId();
	
	public abstract String consultarTodos();
	
	public abstract String consultarTodosComParametros();
	
	
	/**
	 * @return the sexos
	 */
	public Sexo[] getSexos()
	{
		return Sexo.values();
	}
	
	/**
	 * @return the tipoLogradouros
	 */
	public TipoLogradouro[] getTipoLogradouros()
	{
		return TipoLogradouro.values();
	}
	
	/**
	 * @return the operadoras
	 */
	public Operadora[] getOperadoras()
	{
		return Operadora.values();
	}

	/**
	 * @return the ufs
	 */
	public UF[] getUFs()
	{
		return UF.values();
	}
	
	/**
	 * @return the ufs
	 */
	public Situacao[] getSituacao()
	{
		return Situacao.values();
	}
}