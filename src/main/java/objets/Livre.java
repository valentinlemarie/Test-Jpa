package objets;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="livre")
public class Livre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="titre")
	String titre;
	
	@Column(name="auteur")
	String auteur;
	
	@ManyToMany (mappedBy="livres")
	private Set<Emprunt> emprunts;
	
	public int getId() {
		return this.id;
	}
	
	public String getAuteur() {
		return this.auteur;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Livre "+getId()+" :  "+getTitre()+" redige par "+getAuteur();
	}
}
