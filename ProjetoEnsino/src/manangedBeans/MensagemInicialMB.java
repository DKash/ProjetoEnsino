/**
 * 
 */
package manangedBeans;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;

/**
 * @author Audry Martins
 *
 */
@ManagedBean
public class MensagemInicialMB
{
	// Atributos
	
	private String mensagem;
	private LoginMB usuario = new LoginMB();
	
	// Métodos
	
	// Gets e Sets
	/**
	 * @return the mensagem
	 */
	public String getMensagem()
	{
		Calendar c = Calendar.getInstance();
		Integer horaAtual = c.get(Calendar.HOUR_OF_DAY);
		SimpleDateFormat sdf = new SimpleDateFormat("EEEEE, dd/MM/yyyy HH:mm:ss");
		
		if(horaAtual < 12)
		{
			setMensagem("#{msgs.mensagemBomDia}" + ", "
				+ "#{msgs.mensagemDiaSemana}" + " "
				+ sdf.format(c.getTime()) + ". "
				+ "#{msgs.mensagemBoasVindas}" + " "
				+ usuario.getUsuario().getNomeUsuario() + ".");
		}
		else
		{
			if(horaAtual >= 12 && horaAtual < 19)
			{
				setMensagem("#{msgs.mensagemBoaTarde}" + ", "
					+ "#{msgs.mensagemDiaSemana}" + " "
					+ sdf.format(c.getTime()) + ". "
					+ "#{msgs.mensagemBoasVindas}" + " "
					+ usuario.getUsuario().getNomeUsuario()+ ".");
			}
			else
			{
				if(horaAtual >= 19 && horaAtual <= 24)
				{
					setMensagem("#{msgs.mensagemBoaNoite}" + ", "
						+ "#{msgs.mensagemDiaSemana}" + " "
						+ sdf.format(c.getTime()) + ". "
						+ "#{msgs.mensagemBoasVindas}" + " "
						+ usuario.getUsuario().getNomeUsuario() + ".") ;
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