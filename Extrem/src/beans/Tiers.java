package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "tiers")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tiers
{

	//Propriétés
	protected LongProperty		id			= new SimpleLongProperty(-1);
	protected StringProperty	telephone	= new SimpleStringProperty("");
	protected StringProperty	fax			= new SimpleStringProperty("");
	protected StringProperty	mail		= new SimpleStringProperty("");
	protected Set<Adresse>		adresses	= new HashSet<>();

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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idTiers")
	public Set<Adresse> getAdresses()
	{
		return adresses;
	}

	public Set<Adresse> adressesProperty()
	{
		return adresses;
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

	public void setAdresses(Set<Adresse> adresses)
	{
		this.adresses = adresses;
	}

	//Constructeurs
	public Tiers()
	{

	}

	public Tiers(String telephone, String fax, String mail, Set<Adresse> adresses)
	{
		this.telephone.set(telephone);
		this.fax.set(fax);
		this.mail.set(mail);
		this.adresses = adresses;
	}
}