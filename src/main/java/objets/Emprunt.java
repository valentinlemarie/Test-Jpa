package objets;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column (name="date_debut",columnDefinition = "DATE DEFAULT CURRENT_DATE")
	Date date_debut ;
	
	@Column (name="date_fin")
	Date date_fin ;
	
	@Column (name="delai",columnDefinition="default '5'" )
	int delai ;
	
	@ManyToOne @JoinColumn(name="id_client")
	Client client;
	
	@ManyToMany
	@JoinTable(name="COMPO",
		joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
		inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID") )
	public
	Set<Livre> livres;
	
	public Client getClient() {
		return this.client;
	}
	
	public Date getDate_debut() {
		return this.date_debut;
	}
	
	public Date getDate_fin() {
		return this.date_fin;
	}
	
	public int getDelai() {
		return this.delai;
	}
	
	public int getId() {
		return this.id;
	}
	public Set<Livre> getLivres() {
		return this.livres;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Emprunt "+getId()+" : "+getClient()+" a emprunte des livre(s) avec un delai de "+getDelai()+" jour(s) de "+getDate_debut()+" a "+getDate_fin();
	}
}
