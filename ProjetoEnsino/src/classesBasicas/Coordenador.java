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
	@NamedQuery(name = "Coordenador.findAllActives" , query = "SELECT c FROM Coordenador c WHERE c.situacao =:situacao"),
	@NamedQuery(name = "Coordenador.findByName", query = "SELECT c FROM Coordenador c WHERE c.nome LIKE :nome"),
	@NamedQuery(name = "Coordenador.findByCPF", query = "SELECT c FROM Coordenador c WHERE c.cpf = :cpf")
})
@Entity
public class Coordenador extends Pessoa
{
	//Atributos

	//Métodos
	
	//Gets e Sets
}