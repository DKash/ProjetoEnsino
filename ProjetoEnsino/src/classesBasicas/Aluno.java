/**
 * 
 */
package classesBasicas;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * @author Audry Martins
 *
 */
@NamedQueries({
		@NamedQuery(name = "Aluno.findByName", query = "SELECT a FROM Aluno a WHERE a.nome LIKE :nome"),
		@NamedQuery(name = "Aluno.findByCPF", query = "SELECT a FROM Aluno a WHERE a.cpf = :cpf")
})
@Entity
public class Aluno extends Pessoa
{
	// Atributos
	
	// Métodos
	
	// Gets e Sets
}