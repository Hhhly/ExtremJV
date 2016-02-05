package beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.Session;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import utilitaires.LocalDateConverter;

@Entity
@PrimaryKeyJoinColumn(name = "idTiers")
public class Particulier extends Tiers
{
	//Propriétés
	protected StringProperty			nom				= new SimpleStringProperty("");
	protected StringProperty			prenom			= new SimpleStringProperty("");
	protected ObjectProperty<LocalDate>	dateNaissance	= new SimpleObjectProperty<LocalDate>(LocalDate.now());

	//Getters
	@Column(nullable = false)
	public String getNom()
	{
		return nom.get();
	}

	public StringProperty nomProperty()
	{
		return nom;
	}

	@Column(nullable = false)
	public String getPrenom()
	{
		return prenom.get();
	}

	public StringProperty prenomProperty()
	{
		return prenom;
	}

	@Column(nullable = false)
	@Convert(converter = LocalDateConverter.class)
	public LocalDate getDateNaissance()
	{
		return dateNaissance.get();
	}

	public ObjectProperty<LocalDate> dateNaissanceProperty()
	{
		return dateNaissance;
	}

	//Setters
	public void setNom(String nom)
	{
		this.nom.set(nom);
	}

	public void setPrenom(String prenom)
	{
		this.prenom.set(prenom);
	}

	public void setDateNaissance(LocalDate dateNaissance)
	{
		this.dateNaissance.set(dateNaissance);
	}

	//Constructeurs
	public Particulier()
	{
	}

	public Particulier(String nom, String prenom, LocalDate dateNaissance, String telephone, String fax, String mail, Adresse adresse)
	{
		this.nom.set(nom);
		this.prenom.set(prenom);
		this.dateNaissance.set(dateNaissance);
		this.telephone.set(telephone);
		this.fax.set(fax);
		this.mail.set(mail);
		this.adresse.set(adresse);
	}

	//Génération
	public static void generate(Session session) throws Exception
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		Adresse adresseParticulier = new Adresse("Rue des merles", "", "75422", "Paris");
		Particulier particulier = new Particulier("Medico", "Julien", LocalDate.parse("05-10-1982", formatter), "0614498674", "", "client1@gmail.com", adresseParticulier);
		session.save(particulier);
	}

	//Autres
	@Override
	public String toString()
	{
		return this.nom + " " + this.prenom;
	}
}