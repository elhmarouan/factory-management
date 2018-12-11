package ma.tetouan.factoryrest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


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

	@OneToOne(mappedBy = "ouvrier") 
	private TableUsine table;

	@OneToMany(mappedBy = "ouvrier") 
	private Set<Realisation> realisation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOuvrierNom() {
		return this.ouvrierNom;
	}

	public void setOuvrierNom(String ouvrierNom) {
		this.ouvrierNom = ouvrierNom;
	}

	public String getOuvrierPrenom() {
		return this.ouvrierPrenom;
	}

	public void setOuvrierPrenom(String ouvrierPrenom) {
		this.ouvrierPrenom = ouvrierPrenom;
	}

	public TableUsine getTable() {
		return table;
	}

	public void setTable(TableUsine table) {
		this.table = table;
	}

	public Set<Realisation> getRealisation() {
		return realisation;
	}

	public void setRealisation(Set<Realisation> realisation) {
		this.realisation = realisation;
	}

}

