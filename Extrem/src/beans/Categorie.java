package beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.Session;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
public class Categorie
{

	//Propriétés
	private LongProperty	id			= new SimpleLongProperty(0);
	private StringProperty	libelle		= new SimpleStringProperty();
	private LongProperty	position	= new SimpleLongProperty();
	private Categorie		parent;
	private Set<Article>	articles;

	//Getters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId()
	{
		return id.get();
	}

	@Column(nullable = false)
	public String getLibelle()
	{
		return libelle.get();
	}

	public StringProperty libelleProperty()
	{
		return libelle;
	}

	@Column(nullable = false)
	public long getPosition()
	{
		return position.get();
	}

	@OneToOne
	@JoinColumn(name = "idParent")
	public Categorie getParent()
	{
		return parent;
	}

	@OneToMany(mappedBy = "categorie")
	public Set<Article> getArticles()
	{
		return articles;
	}

	//Setters
	public void setId(long id)
	{
		this.id.set(id);
	}

	public void setLibelle(String libelle)
	{
		this.libelle.set(libelle);
	}

	public void setPosition(long position)
	{
		this.position.set(position);
	}

	public void setParent(Categorie parent)
	{
		this.parent = parent;
	}

	public void setArticles(Set<Article> articles)
	{
		this.articles = articles;
	}

	//Constructeurs
	public Categorie()
	{
	}

	public Categorie(String libelle, long position, Categorie parent)
	{
		this.libelle.set(libelle);
		this.position.set(position);
		this.parent = parent;
	}

	//Génération
	public static void generate(Session session)
	{
		//Catégorie Jeux
		Categorie jeux = new Categorie("Jeux", 1, null);
			Categorie jeuxPS4 = new Categorie("PS4", 1, jeux);
			Categorie jeuxXBoxOne = new Categorie("XBox One", 2, jeux);

		session.save(jeux);
			session.save(jeuxPS4);
			session.save(jeuxXBoxOne);

		//Catégorie Consoles
		Categorie consoles = new Categorie("Consoles", 2, null);
			Categorie consolePS4 = new Categorie("PS4", 1, consoles);
			Categorie consoleXBoxOne = new Categorie("XBox One", 2, consoles);

		session.save(consoles);
			session.save(consolePS4);
			session.save(consoleXBoxOne);

		//Catégorie Accessoires
		Categorie accessoires = new Categorie("Accessoires", 3, null);
			Categorie accessoirePS4 = new Categorie("PS4", 3, null);
			Categorie accessoireXBoxOne = new Categorie("XBox One", 3, null);

		session.save(accessoires);
			session.save(accessoirePS4);
			session.save(accessoireXBoxOne);
	}
}