package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import utilitaires.bdd.DB;

@Entity
@PrimaryKeyJoinColumn(name = "idTiers")
public class Organisme extends Tiers
{
	//Propriétés
	private StringProperty	raisonSociale	= new SimpleStringProperty();
	private StringProperty	typeOrganisme	= new SimpleStringProperty();

	//Getters
	@Column(nullable = false)
	public String getRaisonSociale()
	{
		return raisonSociale.get();
	}

	@Column(nullable = false)
	public String getTypeOrganisme()
	{
		return typeOrganisme.get();
	}

	//Setters
	public void setRaisonSociale(String raisonSociale)
	{
		this.raisonSociale.set(raisonSociale);
	}

	public void setTypeOrganisme(String typeOrganisme)
	{
		this.typeOrganisme.set(typeOrganisme);
	}

	//Constructeurs
	public Organisme()
	{
	}

	public Organisme(String raisonSociale, String typeOrganisme, String telephone, String fax, String mail, ObservableSet<Adresse> adresses)
	{
		this.raisonSociale.set(raisonSociale);
		this.typeOrganisme.set(typeOrganisme);
		this.telephone.set(telephone);
		this.fax.set(fax);
		this.mail.set(mail);
		this.adresses = adresses;
	}

	//Générateur
	public static void generate()
	{
		Adresse adresseOrganisme = new Adresse("15 chemin des frêles", "", "15422", "Freodi");
		ObservableSet<Adresse> adressesOrganisme = FXCollections.observableSet();
		adressesOrganisme.add(adresseOrganisme);
		Organisme organisme = new Organisme("Les tous petits", "Association", "0102030405", "", "lestouspetits-association@gmail.com", adressesOrganisme);
		DB.create(organisme);

		Adresse adresseOrganisme2 = new Adresse("12 impasse du four", "", "12045", "Grenoble");
		ObservableSet<Adresse> adressesOrganisme2 = FXCollections.observableSet();
		adressesOrganisme2.add(adresseOrganisme2);
		Organisme organisme2 = new Organisme("Jeux-entreprise", "Entreprise", "0605040302", "", "jeux-entreprise@gmail.com", adressesOrganisme2);
		DB.create(organisme2);
	}
}
