package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
public class Adresse
{
	//Propriétés
	protected LongProperty	id			= new SimpleLongProperty(-1);
	private StringProperty	adresse1	= new SimpleStringProperty();
	private StringProperty	adresse2	= new SimpleStringProperty();
	private StringProperty	ville		= new SimpleStringProperty();
	private StringProperty	codePostal	= new SimpleStringProperty();

	//Getters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId()
	{
		return id.get();
	}

	@Column(nullable = false)
	public String getAdresse1()
	{
		return adresse1.get();
	}

	public StringProperty adresse1Property()
	{
		return adresse1;
	}

	public String getAdresse2()
	{
		return adresse2.get();
	}

	public StringProperty adresse2Property()
	{
		return adresse2;
	}

	@Column(nullable = false)
	public String getVille()
	{
		return ville.get();
	}

	public StringProperty villeProperty()
	{
		return ville;
	}

	@Column(nullable = false)
	public String getCodePostal()
	{
		return codePostal.get();
	}

	public StringProperty codePostalProperty()
	{
		return codePostal;
	}

	//Setters
	public void setId(long id)
	{
		this.id.set(id);
	}

	public void setAdresse1(String adresse1)
	{
		this.adresse1.set(adresse1);
	}

	public void setAdresse2(String adresse2)
	{
		this.adresse2.set(adresse2);
	}

	public void setVille(String ville)
	{
		this.ville.set(ville);
	}

	public void setCodePostal(String codePostal)
	{
		this.codePostal.set(codePostal);
	}

	//Constructeurs
	public Adresse()
	{

	}

	public Adresse(String adresse1, String adresse2, String ville, String codePostal)
	{
		this.adresse1.set(adresse1);
		this.adresse2.set(adresse2);
		this.ville.set(ville);
		this.codePostal.set(codePostal);
	}
}
