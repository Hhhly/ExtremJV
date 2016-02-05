package beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "adresse")
public class Adresse
{
	//Propriétés
	private StringProperty	adresse1		= new SimpleStringProperty();
	private StringProperty	adresse2		= new SimpleStringProperty();
	private StringProperty	ville		= new SimpleStringProperty();
	private StringProperty	codePostal	= new SimpleStringProperty();

	//Getters
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

	public String getVille()
	{
		return ville.get();
	}

	public StringProperty villeProperty()
	{
		return ville;
	}

	public String getCodePostal()
	{
		return codePostal.get();
	}

	public StringProperty codePostalProperty()
	{
		return codePostal;
	}

	//Setters
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
