package ma.tetouan.factoryrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Semaine {
	
	@Id 
	@Column(nullable = false)
	private Integer id;

	@Column(nullable = false) 
	private String semaineNom;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSemaineNom() {
		return semaineNom;
	}

	public void setSemaineNom(String semaineNom) {
		this.semaineNom = semaineNom;
	}

}
