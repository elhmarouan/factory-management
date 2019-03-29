package ma.tetouan.factoryrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Article
{
	@Id 
	@Column(nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false) 
	protected String articleNumero;
	
	@Column
	protected Long nbHeures;
	
//	@OneToMany(mappedBy = "article") 
//	protected Set<Commande> commande;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArticleNumero() {
		return articleNumero;
	}

	public void setArticleNumero(String articleNumero) {
		this.articleNumero = articleNumero;
	}

	public Long getNbHeures() {
		return nbHeures;
	}

	public void setNbHeures(Long nbHeures) {
		this.nbHeures = nbHeures;
	}

//	public Set<Commande> getCommande() {
//		return commande;
//	}
//
//	public void setCommande(Set<Commande> commande) {
//		this.commande = commande;
//	}
	
}

