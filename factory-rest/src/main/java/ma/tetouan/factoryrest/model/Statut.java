package ma.tetouan.factoryrest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Statut
{
	@Id 
	@Column(nullable = false)
	private Integer id;

	@Column(nullable = false) 
	private String statutNom;

	@OneToMany(mappedBy = "statut") 
	private Set<Realisation> realisation;

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

	public Set<Realisation> getRealisation() {
		return realisation;
	}

	public void setRealisation(Set<Realisation> realisation) {
		this.realisation = realisation;
	}

}

