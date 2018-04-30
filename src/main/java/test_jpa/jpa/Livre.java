package test_jpa.jpa;

import javax.persistence.*;

@Entity
@Table(name="livre")
public class Livre {
	
	@Id
	int id;
	
	@Column(name="titre")
	String titre;
	
	@Column(name="auteur")
	String auteur;
	
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
		return "Livre "+getId()+" :  "+getTitre()+" redige par  "+getAuteur();
	}
}
