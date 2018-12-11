package ma.tetouan.factoryrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity 
public class Realisation
{
	@Id 
	@Column(nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false) 
	private String dateDebut;

	@Column(nullable = false) 
	private String dateFin;

	@ManyToOne 
	@JoinColumn(nullable = false) 
	private Statut statut;

	@OneToOne 
	private Article article;

	@ManyToOne 
	@JoinColumn(nullable = false) 
	private Ouvrier ouvrier;

}

