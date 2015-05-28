package util;

import javax.persistence.EntityManager;

/**
 * @author Audry Martins
 *
 */
public class JPAUtil
{
	//Atributos
	
	public static final ThreadLocal<EntityManager> ENTITY_MANAGERS = new ThreadLocal<EntityManager>();
	public static String UNIT_PERSISTENCE = "unitProjetoEnsino";
	public static final String UNIT_PERSISTENCE_NAME = "unitProjetoEnsino";
	
	//Gets e Sets
	
	public static EntityManager getEntityManager()
	{
		return ENTITY_MANAGERS.get();
	}
}