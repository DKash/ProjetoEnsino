package gui;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import util.JPAUtil;

/**
 * Servlet Filter implementation class EntityManagerFilter
 */
@WebFilter(servletNames = "Faces Servlet", filterName = "/EntityManagerFilter")
public class EntityManagerFilter implements Filter
{
	private static EntityManagerFactory theEntityManagerFactory = null;
	
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException
	{
		EntityManager em = null;
		try
		{
			em = theEntityManagerFactory.createEntityManager();
			JPAUtil.ENTITY_MANAGERS.set(em);
			chain.doFilter(request, response);
			JPAUtil.ENTITY_MANAGERS.remove();
		}finally
		{
			try
			{
				if(em != null)
					em.close();
			}catch(Throwable t)
			{
				System.out.println(t.getMessage());
				t.printStackTrace();
			}
		}
	}
	
	public void init(FilterConfig config)
	{
		destroy();
		theEntityManagerFactory = Persistence
			.createEntityManagerFactory(JPAUtil.UNIT_PERSISTENCE);
	}
	
	public void destroy()
	{
		if(theEntityManagerFactory != null)
			theEntityManagerFactory.close();
	}
}