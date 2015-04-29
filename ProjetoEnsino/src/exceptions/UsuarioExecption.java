/**
 * 
 */
package exceptions;

import util.Mensagens;

/**
 * @author Audry Martins
 *
 */
public class UsuarioExecption extends Exception
{
	
	//Atributos
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Construtores
	/**
	 * @param arg0
	 */
	public UsuarioExecption(String mensagem)
	{
		mensagem = Mensagens.MENSAGEM_PESSOA_NOME_USUARIO_INVALIDO;
		mensagem = Mensagens.MENSAGEM_PESSOA_SENHA_USUARIO_INVALIDA;
	}
	
	//Métodos
	
	//Gets e Sets
}