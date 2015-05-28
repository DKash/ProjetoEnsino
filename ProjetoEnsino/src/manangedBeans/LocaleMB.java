/**
 * 
 */
package manangedBeans;

import java.util.HashMap;
import java.util.Locale;

/*import javax.faces.bean.ManagedBean;*/
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author Audry Martins
 *
 */
/*@ManagedBean*/
public class LocaleMB
{
	// Atributos
	
	private HashMap<String, Locale> locales = null;
	
	//Construtores
	
	public LocaleMB()
	{
		locales = new HashMap<String, Locale>(6);
		locales.put("PT", new Locale("pt_BR", "BR"));
		locales.put("US", new Locale("en_US", "US"));
		locales.put("ES", new Locale("es_ES", "ES"));
		locales.put("FR", new Locale("fr_FR", "FR"));
		locales.put("FR", new Locale("de_DE", "DE"));
		locales.put("JP", new Locale("jp_JP", "JP"));
	}
	
	// Métodos
	
	public void chooseLocaleFromLink(ActionEvent event)
	{
		String current = event.getComponent().getId();
		/*String current = (String) event.getComponent().getAttributes()
			.get("value");*/
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale((Locale) locales.get(current));
	}
	
	// Gets e Sets
}