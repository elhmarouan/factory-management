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

	@Column
	private String commandeNumero;

	@OneToOne(mappedBy = "article") 
	private Realisation realisation;

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

	public Realisation getRealisation() {
		return realisation;
	}

	public void setRealisation(Realisation realisation) {
		this.realisation = realisation;
	}

	public String getCommandeNumero() {
		return commandeNumero;
	}

	public void setCommandeNumero(String commandeNumero) {
		this.commandeNumero = commandeNumero;
	}

}

