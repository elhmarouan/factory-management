package ma.tetouan.factoryrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
public class Commande {
	
	@Id 
	@Column(nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false) 
	protected String commandeNumero;

	@ManyToOne 
	@JoinColumn(nullable = false) 
	protected Article article;

	@ManyToOne 
	@JoinColumn(nullable = false)
	protected Statut statut;

	@ManyToOne 
	@JoinColumn(nullable = false) 
	protected Ouvrier ouvrier;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommandeNumero() {
		return commandeNumero;
	}

	public void setCommandeNumero(String commandeNumero) {
		this.commandeNumero = commandeNumero;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Ouvrier getOuvrier() {
		return ouvrier;
	}

	public void setOuvrier(Ouvrier ouvrier) {
		this.ouvrier = ouvrier;
	}

}
