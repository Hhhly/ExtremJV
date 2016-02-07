package beans;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import utilitaires.bdd.CRUD;

@Entity
@PrimaryKeyJoinColumn(name = "idTiers")
public class Employe extends Particulier
{
	//Propriétés
	private StringProperty	matricule		= new SimpleStringProperty("");
	private StringProperty	nomUtilisateur	= new SimpleStringProperty("");
	private StringProperty	motDePasse		= new SimpleStringProperty("");
	private StringProperty	droits			= new SimpleStringProperty("");
	private BooleanProperty	isActif			= new SimpleBooleanProperty(true);

	//Getters
	@Column(nullable = false)
	public String getMatricule()
	{
		return matricule.get();
	}

	public StringProperty matriculeProperty()
	{
		return matricule;
	}

	@Column(nullable = false)
	public String getNomUtilisateur()
	{
		return nomUtilisateur.get();
	}

	public StringProperty nomUtilisateurProperty()
	{
		return nomUtilisateur;
	}

	@Column(nullable = false)
	public String getMotDePasse()
	{
		return motDePasse.get();
	}

	public StringProperty motDePasseProperty()
	{
		return motDePasse;
	}

	@Column(nullable = false)
	public String getDroits()
	{
		return droits.get();
	}

	public StringProperty droitsProperty()
	{
		return droits;
	}

	@Column(nullable = false)
	public Boolean isActif()
	{
		return isActif.get();
	}

	public BooleanProperty actifProperty()
	{
		return isActif;
	}

	//Setters
	public void setMatricule(String matricule)
	{
		this.matricule.set(matricule);
	}

	public void setNomUtilisateur(String nomUtilisateur)
	{
		this.nomUtilisateur.set(nomUtilisateur);
	}

	public void setMotDePasse(String motDePasse)
	{
		this.motDePasse.set(motDePasse);
	}

	public void setDroits(String droits)
	{
		this.droits.set(droits);
	}

	public void setActif(boolean active)
	{
		this.isActif.set(active);
	}

	//Constructeurs
	public Employe()
	{
	}

	public Employe(String matricule, String nomUtilisateur, String motDePasse, String droits, String nom, String prenom, LocalDate dateNaissance, String telephone, String fax, String mail, ObservableSet<Adresse> adresses)
	{
		this.matricule.set(matricule);
		this.nomUtilisateur.set(nomUtilisateur);
		this.motDePasse.set(motDePasse);
		this.droits.set(droits);
		this.nom.set(nom);
		this.prenom.set(prenom);
		this.dateNaissance.set(dateNaissance);
		this.telephone.set(telephone);
		this.fax.set(fax);
		this.mail.set(mail);
		this.adresses = adresses;
	}

	//Génération
	public static void generate() throws ParseException
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		//Génération du compte administrateurs
		Adresse adresseAdmin = new Adresse("8 traverse de la dominique", "Les Naîades", "13011", "Marseille");
		ObservableSet<Adresse> adressesAdmin = FXCollections.observableSet();
		adressesAdmin.add(adresseAdmin);
		Employe employeAdmin = new Employe("AAN001", "Admin", "Admin", "Administrateur", "Sapone", "Alann", LocalDate.parse("10-10-1989", formatter), "0614498673", "", "sapone.alann@gmail.com", adressesAdmin);
		CRUD.saveOrUpdate(employeAdmin);

		//Génération du compte manager
		Adresse adresseManager = new Adresse("16 rue du tricot", "", "04220", "Corbières");
		ObservableSet<Adresse> adressesManager = FXCollections.observableSet();
		adressesManager.add(adresseManager);
		Employe employeManager = new Employe("MMR001", "Manager", "Manager", "Manager", "Begyn", "Philippe", LocalDate.parse("30-03-1988", formatter), "0782856192", "", "begyn.p@gmail.com", adressesManager);
		CRUD.saveOrUpdate(employeManager);

		//Génération du compte Employé
		Adresse adresseEmploye = new Adresse("8 rue du maréchal Pétain", "", "13290", "Aix-en-Provence");
		ObservableSet<Adresse> adressesEmploye = FXCollections.observableSet();
		adressesEmploye.add(adresseEmploye);
		Employe employeEmploye = new Employe("EEE001", "Employé", "Employé", "Employé", "Cullard", "Vincent", LocalDate.parse("20-03-1982", formatter), "0601107672", "", "vincent.cullard@yahoo.fr", adressesEmploye);
		CRUD.saveOrUpdate(employeEmploye);
	}
}