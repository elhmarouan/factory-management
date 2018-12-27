package ma.tetouan.factoryrest.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity 
public class Ouvrier
{
	
	@Id 
	@Column(nullable = false) 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false) 
	private String ouvrierNom;
	 
	@Column(nullable = false) 
	private String ouvrierPrenom;

	@OneToOne
	private TableUsine tableUsine;

	@OneToMany(mappedBy = "ouvrier")
    @JsonManagedReference
	private Set<Commande> commande;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOuvrierNom() {
		return ouvrierNom;
	}

	public void setOuvrierNom(String ouvrierNom) {
		this.ouvrierNom = ouvrierNom;
	}

	public String getOuvrierPrenom() {
		return ouvrierPrenom;
	}

	public void setOuvrierPrenom(String ouvrierPrenom) {
		this.ouvrierPrenom = ouvrierPrenom;
	}

	public TableUsine getTableUsine() {
		return tableUsine;
	}

	public void setTableUsine(TableUsine tableUsine) {
		this.tableUsine = tableUsine;
	}

	public Set<Commande> getCommande() {
		return commande;
	}

	public void setCommande(Set<Commande> commande) {
		this.commande = commande;
	}


}

