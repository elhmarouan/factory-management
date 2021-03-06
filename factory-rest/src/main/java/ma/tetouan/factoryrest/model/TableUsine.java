package ma.tetouan.factoryrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TableUsine
{
	@Id 
	@Column(nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false) 
	protected String tableNumero;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTableNumero() {
		return tableNumero;
	}

	public void setTableNumero(String tableNumero) {
		this.tableNumero = tableNumero;
	}
	
}

