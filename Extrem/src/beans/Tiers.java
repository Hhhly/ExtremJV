package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "tiers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tiers
{

	//Propriétés
	protected LongProperty				id		= new SimpleLongProperty(-1);
	protected StringProperty			telephone	= new SimpleStringProperty("");
	protected StringProperty			fax		= new SimpleStringProperty("");
	protected StringProperty			mail		= new SimpleStringProperty("");
	protected ObjectProperty<Adresse>	adresse	= new SimpleObjectProperty<>();

	//Getters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId()
	{
		return id.get();
	}

	@Column(nullable = false)
	public String getTelephone()
	{
		return telephone.get();
	}

	public StringProperty telephoneProperty()
	{
		return telephone;
	}

	@Column(nullable = false)
	public String getFax()
	{
		return fax.get();
	}

	public StringProperty faxProperty()
	{
		return fax;
	}

	@Column(nullable = false)
	public String getMail()
	{
		return mail.get();
	}

	public StringProperty mailProperty()
	{
		return mail;
	}

	@Column(nullable = false)
	public Adresse getAdresse()
	{
		return adresse.get();
	}

	public ObjectProperty<Adresse> adresseProperty()
	{
		return adresse;
	}

	//Setters
	public void setId(long id)
	{
		this.id.set(id);
	}

	public void setTelephone(String telephone)
	{
		this.telephone.set(telephone);
	}

	public void setFax(String fax)
	{
		this.fax.set(fax);
	}

	public void setMail(String mail)
	{
		this.mail.set(mail);
	}

	public void setAdresse(Adresse adresse)
	{
		this.adresse.set(adresse);
	}

	//Constructeurs
	public Tiers()
	{

	}

	public Tiers(String telephone, String fax, String mail, Adresse adresse)
	{
		this.telephone.set(telephone);
		this.fax.set(fax);
		this.mail.set(mail);
		this.adresse.set(adresse);
	}
}