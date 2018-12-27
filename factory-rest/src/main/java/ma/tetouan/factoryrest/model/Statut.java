package ma.tetouan.factoryrest.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity 
public class Statut
{
	@Id 
	@Column(nullable = false)
	private Integer id;

	@Column(nullable = false) 
	private String statutNom;

//	@OneToMany(mappedBy = "statut")
//	protected Set<Commande> commande;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatutNom() {
		return statutNom;
	}

	public void setStatutNom(String statutNom) {
		this.statutNom = statutNom;
	}

}

