/*package manangedBeans;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import classesBasicas.TipoUsuario;

*//**
 * Servlet Filter implementation class LoginAutenticadoFilter
 *//*
@WebFilter(servletNames = "Faces Servlet", filterName = "/LoginAutenticadoFilter")
public class LoginAutenticadoFilter implements Filter
{
	private static final String[] arquivosEscape = { "javax.faces.resource",
			"index.xhtml", "CadastroUsuario.xhtml", "PesquisaUsuario.xhtml", 
			".xhtml"};
	
	private static final String[] arquivosAdmin = { "PesquisaProjeto.xhtml",
			"PesquisaAluno.xhtml", "PesquisaProfessor.xhtml",
			"PesquisaProjeto.xhtml", "PesquisaAluno.xhtml",
			"PesquisaProfessor.xhtml", "CadastroNota.xhtml",
			"PesquisaAluno.xhtml", "PesquisaProfessor.xhtml",
			"PesquisaProjeto.xhtml", "CadastroProfessor.xhtml", 
			"PesquisaProfessor.xhtml", "PesquisaProjeto.xhtml"};
	
	
	private static final String[] arquivosAluno = { "PesquisaProjeto.xhtml",
			"PesquisaAluno.xhtml", "PesquisaProfessor.xhtml"};
	
	private static final String[] arquivosOrientador = { "PesquisaProjeto.xhtml",
			"PesquisaAluno.xhtml", "PesquisaProfessor.xhtml"};
	
	private static final String[] arquivosAvaliador = { "CadastroNota.xhtml",
			"PesquisaAluno.xhtml", "PesquisaProfessor.xhtml",
			"PesquisaProjeto.xhtml"};
	
	private static final String[] arquivosCoordenador = { "CadastroProfessor.xhtml", 
			"PesquisaProfessor.xhtml", "PesquisaProjeto.xhtml"};
	
	public void destroy()
	{
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException
	{
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession sessao = req.getSession();
		if(verificaPaginaInicial(request))
		{
			chain.doFilter(request, response);
		}
		else
		{
			if(sessao == null
				|| sessao.getAttribute("loginMB") == null
				|| ((LoginMB) sessao.getAttribute("loginMB"))
					.getUsuarioLogado() == null)
			{
				RequestDispatcher dis = request
					.getRequestDispatcher("/index.xhtml");
				dis.forward(request, response);
			}
			else
			{
				if(verificaUsuarioAdmin(request))
				{
					chain.doFilter(request, response);
				}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Usuario sem Permissão, entre com outro Usuario"));
					
					RequestDispatcher dis = request
					.getRequestDispatcher("/index.xhtml");
					dis.forward(request, response);
				}
				
				if(verificaUsuarioAluno(request))
				{
					chain.doFilter(request, response);
				}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Usuario sem Permissão, entre com outro Usuario"));
					
					RequestDispatcher dis = request
					.getRequestDispatcher("/index.xhtml");
					dis.forward(request, response);
				}
				
				if(verificaUsuarioOrientador(request))
				{
					chain.doFilter(request, response);
				}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Usuario sem Permissão, entre com outro Usuario"));
					
					RequestDispatcher dis = request
					.getRequestDispatcher("/index.xhtml");
					dis.forward(request, response);
				}
				
				if(verificaUsuarioAvaliador(request))
				{
					chain.doFilter(request, response);
				}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Usuario sem Permissão, entre com outro Usuario"));
					
					RequestDispatcher dis = request
					.getRequestDispatcher("/index.xhtml");
					dis.forward(request, response);
				}
				
				if(verificaUsuarioCoordenador(request))
				{
					chain.doFilter(request, response);
				}
				else
				{
					FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Usuario sem Permissão, entre com outro Usuario"));
					
					RequestDispatcher dis = request
					.getRequestDispatcher("/index.xhtml");
					dis.forward(request, response);
				}
			
				//Outra forma de fazer o de cima.
				
				// Liberar Todas as opções
				if(((LoginMB) sessao.getAttribute("loginMB"))
					.getUsuarioLogado().getTipoUsuario() == TipoUsuario.Admin)
				{
					chain.doFilter(request, response);
				}
				// liberar apenas opções de visualização
				if(((LoginMB) sessao.getAttribute("loginMB"))
					.getUsuarioLogado().getTipoUsuario() == TipoUsuario.Aluno)
				{
					if(!req.getRequestURI().endsWith("PesquisaProjeto.xhtml")
						|| !req.getRequestURI().endsWith("PesquisaAluno.xhtml")
						|| !req.getRequestURI().endsWith(
							"PesquisaProfessor.xhtml"))
					{
						RequestDispatcher dis = request
							.getRequestDispatcher("/index.xhtml");
						dis.forward(request, response);
					}
					else
					{
						chain.doFilter(request, response);
					}
				}
				// Liberar somente opções de visualização de projetos
				if(((LoginMB) sessao.getAttribute("loginMB"))
					.getUsuarioLogado().getTipoUsuario() == TipoUsuario.Orientador)
				{
					if(!req.getRequestURI().endsWith("PesquisaProjeto.xhtml")
						|| !req.getRequestURI().endsWith("PesquisaAluno.xhtml")
						|| !req.getRequestURI().endsWith(
							"PesquisaProfessor.xhtml"))
					{
						RequestDispatcher dis = request
							.getRequestDispatcher("/index.xhtml");
						dis.forward(request, response);
					}
					else
					{
						chain.doFilter(request, response);
					}
				}
				// Liberar somente opções de atribuição de notas aos projetos
				if(((LoginMB) sessao.getAttribute("loginMB"))
					.getUsuarioLogado().getTipoUsuario() == TipoUsuario.Avaliador)
				{
					if(!req.getRequestURI().endsWith("CadastroNota.xhtml")
						|| !req.getRequestURI().endsWith("PesquisaAluno.xhtml")
						|| !req.getRequestURI().endsWith(
							"PesquisaProfessor.xhtml")
						|| !req.getRequestURI().endsWith(
							"PesquisaProjeto.xhtml"))
					{
						RequestDispatcher dis = request
							.getRequestDispatcher("/index.xhtml");
						dis.forward(request, response);
					}
					else
					{
						chain.doFilter(request, response);
					}
				}
				// liberar somente a atribuição de avaliadores aos projetos
				if(((LoginMB) sessao.getAttribute("loginMB"))
					.getUsuarioLogado().getTipoUsuario() == TipoUsuario.Coordenador)
				{
					if(!req.getRequestURI().endsWith("CadastroProfessor.xhtml")
						|| !req.getRequestURI().endsWith(
							"PesquisaProfessor.xhtml")
						|| !req.getRequestURI().endsWith(
							"PesquisaProjeto.xhtml"))
					{
						RequestDispatcher dis = request
							.getRequestDispatcher("/index.xhtml");
						dis.forward(request, response);
					}
					else
					{
						chain.doFilter(request, response);
					}
				}
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException
	{
		
	}
	
	protected boolean verificaPaginaInicial(ServletRequest request)
	{
		String resource = ((HttpServletRequest) request).getRequestURI();
		for(String esc : arquivosEscape)
		{
			if(resource.contains(esc))
			{
				return true;
			}
		}
		System.out.println(resource);
		return false;
	}
	
	private boolean verificaUsuarioAdmin(ServletRequest request)
	{
		String resource = ((HttpServletRequest) request).getRequestURI();
		for(String esc : arquivosAdmin)
		{
			if(resource.contains(esc))
			{
				return true;
			}
		}
		System.out.println(resource);
		return false;
	}
	
	private boolean verificaUsuarioAluno(ServletRequest request)
	{
		String resource = ((HttpServletRequest) request).getRequestURI();
		for(String esc : arquivosAluno)
		{
			if(resource.contains(esc))
			{
				return true;
			}
		}
		System.out.println(resource);
		return false;
	}
	
	private boolean verificaUsuarioOrientador(ServletRequest request)
	{
		String resource = ((HttpServletRequest) request).getRequestURI();
		for(String esc : arquivosOrientador)
		{
			if(resource.contains(esc))
			{
				return true;
			}
		}
		System.out.println(resource);
		return false;
	}
	
	private boolean verificaUsuarioAvaliador(ServletRequest request)
	{
		String resource = ((HttpServletRequest) request).getRequestURI();
		for(String esc : arquivosAvaliador)
		{
			if(resource.contains(esc))
			{
				return true;
			}
		}
		System.out.println(resource);
		return false;
	}
	
	private boolean verificaUsuarioCoordenador(ServletRequest request)
	{
		String resource = ((HttpServletRequest) request).getRequestURI();
		for(String esc : arquivosCoordenador)
		{
			if(resource.contains(esc))
			{
				return true;
			}
		}
		System.out.println(resource);
		return false;
	}
	
	 (non-Javadoc)
	 * @see java.util.logging.Filter#isLoggable(java.util.logging.LogRecord)
	 
	@Override
	public boolean isLoggable(LogRecord arg0)
	{
		return false;
	}
}*/