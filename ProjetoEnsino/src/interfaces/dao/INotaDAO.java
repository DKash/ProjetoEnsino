/**
 * 
 */
package interfaces.dao;

import java.util.List;

import classesBasicas.Criterio;
import classesBasicas.Nota;
import classesBasicas.Professor;
import classesBasicas.Projeto;
import dao.generics.IDAOGeneric;
import exceptions.NotaInexistenteException;

/**
 * @author Audry Martins
 *
 */
public interface INotaDAO extends IDAOGeneric<Nota>
{
	// Métodos
	
	List<Nota> consultarNotasPorProjeto(Projeto projeto)
		throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorCriterio(Criterio criterio)
		throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorProjetoCriterio(Projeto projeto,
		Criterio criterio) throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorProjetoCriterioAvaliador(Projeto projeto,
		Criterio criterio, Professor avaliador) throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorProfessorOrientador(Professor orientador)
		throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorProfessorAvaliador(Professor avaliador)
		throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorProfessorOrientadorAvaliador(
		Professor orientador, Professor avaliador)
		throws NotaInexistenteException;
	
	List<Nota> consultarNotasPorProjetoCriterioOrientadorAvaliador(
		Projeto projeto, Criterio criterio, Professor orientador,
		Professor avaliador) throws NotaInexistenteException;
}