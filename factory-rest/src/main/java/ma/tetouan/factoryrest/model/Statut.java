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

}

