package beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import utilitaires.LocalDateConverter;
import utilitaires.bdd.DB;

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

	public Particulier(String nom, String prenom, LocalDate dateNaissance, String telephone, String fax, String mail, ObservableSet<Adresse> adresses)
	{
		this.nom.set(nom);
		this.prenom.set(prenom);
		this.dateNaissance.set(dateNaissance);
		this.telephone.set(telephone);
		this.fax.set(fax);
		this.mail.set(mail);
		this.adresses = adresses;
	}

	//Génération
	public static void generate() throws Exception
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		Adresse adresseParticulier = new Adresse("12 Rue des merles", "", "75422", "Paris");
		Adresse adresseParticulier2 = new Adresse("15 impasse des choux", "société géniale", "75000", "Paris");
		ObservableSet<Adresse> adressesParticulier = FXCollections.observableSet();
		adressesParticulier.add(adresseParticulier);
		adressesParticulier.add(adresseParticulier2);
		Particulier particulier = new Particulier("Medico", "Julien", LocalDate.parse("05-10-1982", formatter), "0614498674", "", "client1@gmail.com", adressesParticulier);
		DB.create(particulier);
	}

	//Autres
	@Override
	public String toString()
	{
		return this.nom + " " + this.prenom;
	}
}