/**
 * 
 */
package gui;

import javax.faces.bean.ManagedBean;

import classesBasicas.Operadora;
import classesBasicas.Sexo;
import classesBasicas.Situacao;
import classesBasicas.TipoLogradouro;
import classesBasicas.UF;

/**
 * @author Audry Martins
 *
 */
@ManagedBean
public class CadastroPessoaMB extends ObjetoMB
{
	// Atributos
	
	// Métodos
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#inserir()
	 */
	@Override
	public String inserir()
	{
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#alterar()
	 */
	@Override
	public String alterar()
	{
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#remover()
	 */
	@Override
	public String remover()
	{
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#consultarPorId()
	 */
	@Override
	public String consultarPorId()
	{
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#consultarTodos()
	 */
	@Override
	public String consultarTodos()
	{
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#consultarTodosComParametros()
	 */
	@Override
	public String consultarTodosComParametros()
	{
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#consultarPorNome()
	 */
	@Override
	public String consultarPorNome()
	{
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#consultarPorCPF()
	 */
	@Override
	public String consultarPorCPF()
	{
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#consultarTodosAtivos()
	 */
	@Override
	public String consultarTodosAtivos()
	{
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.ObjetoMB#novo()
	 */
	@Override
	public String novo()
	{
		return null;
	}
	
	/* (non-Javadoc)
	 * @see gui.ObjetoMB#exibirIndex()
	 */
	@Override
	public String exibirIndex()
	{
		return "/index.xhtml?faces-redirect=true";
	}
	
	/* (non-Javadoc)
	 * @see gui.ObjetoMB#exibirMenu()
	 */
	@Override
	public String exibirMenu()
	{
		return "/menu.xhtml?faces-redirect=true";
	}
	
	// Gets e Sets
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
	public Situacao[] getSituacoes()
	{
		return Situacao.values();
	}
}