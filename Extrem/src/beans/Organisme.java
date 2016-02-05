package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.Session;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

	public Organisme(String raisonSociale, String typeOrganisme, String telephone, String fax, String mail, Adresse adresse)
	{
		this.raisonSociale.set(raisonSociale);
		this.typeOrganisme.set(typeOrganisme);
		this.telephone.set(telephone);
		this.fax.set(fax);
		this.mail.set(mail);
		this.adresse.set(adresse);
	}

	//Générateur
	public static void generate(Session session)
	{

		Adresse adresseOrganisme = new Adresse("15 chemin des frêles", "", "15422", "Freodi");
		Organisme organisme = new Organisme("Les tous petits", "Association", "0102030405", "", "musique-association@gmail.com", adresseOrganisme);
		session.save(organisme);

		Adresse adresseOrganisme2 = new Adresse("12 impasse du four", "", "12045", "Grenoble");
		Organisme organisme2 = new Organisme("Musique entreprise", "Entreprise", "0605040302", "", "musique-entreprise@gmail.com", adresseOrganisme2);
		session.save(organisme2);
	}
}
