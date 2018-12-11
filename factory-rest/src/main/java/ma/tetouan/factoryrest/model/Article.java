package ma.tetouan.factoryrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity 
public class Article
{
	@Id 
	@Column(nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false) 
	private String articleNumero;

	@OneToOne(mappedBy = "article") 
	private Commande commande;

	@OneToOne(mappedBy = "article") 
	private Realisation realisation;

}

