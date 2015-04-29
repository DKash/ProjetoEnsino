/**
 * 
 */
package manangedBeans;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;

import util.Mensagens;
import classesBasicas.Usuario;


/**
 * @author Audry Martins
 *
 */
@ManagedBean
public class MensagemInicialMB
{
	// Atributos
	
	private String mensagem;
	
	// Construtores
	
	public MensagemInicialMB()
	{
		super();
		
		this.mensagem = "";
	}
	
	/**
	 * @param mensagem
	 */
	public MensagemInicialMB(String mensagem)
	{
		super();
		this.mensagem = mensagem;
	}
	
	// Métodos
	
	// Gets e Sets
	/**
	 * @return the mensagem
	 */
	public String getMensagem()
	{
		Calendar c = Calendar.getInstance();
		Integer horaAtual = c.get(Calendar.HOUR_OF_DAY);
		SimpleDateFormat sdf = new SimpleDateFormat("EEEEE, dd/MM/yyyy");
		
		Usuario usuario = new Usuario();
		if(horaAtual < 12)
		{
			setMensagem(Mensagens.MENSAGEM_BOM_DIA + ", "
				+ Mensagens.MENSAGEM_DIA_SEMANA + " "
				+ sdf.format(c.getTime()) + ". "
				+ Mensagens.MENSAGEM_BOAS_VINDAS + " "
				+ usuario.getNomeUsuario() + ".");
		}
		else
		{
			if(horaAtual >= 12 && horaAtual < 19)
			{
				setMensagem(Mensagens.MENSAGEM_BOA_TARDE + ", "
					+ Mensagens.MENSAGEM_DIA_SEMANA + " "
					+ sdf.format(c.getTime()) + ". "
					+ Mensagens.MENSAGEM_BOAS_VINDAS + " "
					+ usuario.getNomeUsuario() + ".");
			}
			else
			{
				if(horaAtual >= 19 && horaAtual <= 24)
				{
					setMensagem(Mensagens.MENSAGEM_BOA_NOITE + ", "
						+ Mensagens.MENSAGEM_DIA_SEMANA + " "
						+ sdf.format(c.getTime()) + ". "
						+ Mensagens.MENSAGEM_BOAS_VINDAS + " "
						+ usuario.getNomeUsuario() + ".");
				}
			}
		}
		return mensagem;
	}
	
	/**
	 * @param mensagem
	 *            the mensagem to set
	 */
	public void setMensagem(String mensagem)
	{
		this.mensagem = mensagem;
	}
}