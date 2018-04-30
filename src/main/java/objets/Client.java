package objets;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column (name="nom",length=50)
	String nom ;
	
	@Column (name="prenom",length=50)
	String prenom;
	
	@OneToMany(mappedBy="client")
	public
	 Set<Emprunt> emprunts;
	
	public int getId() {
		return this.id;
	}
	
	public Set<Emprunt> getEmprunts() {
		return this.emprunts;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Client "+getId()+" : "+getNom()+" "+getPrenom(); 
	}
}
