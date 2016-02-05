package beans;

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
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "article")
@Inheritance(strategy = InheritanceType.JOINED)
public class Article
{
	//Propriétés
	private LongProperty		id			= new SimpleLongProperty();
	private StringProperty		libelle		= new SimpleStringProperty();
	private StringProperty		description	= new SimpleStringProperty();
	private Set<ArticleImage>	images;
	private FloatProperty		tauxTVA		= new SimpleFloatProperty();
	private FloatProperty		prixTTC		= new SimpleFloatProperty();
	private IntegerProperty		stock			= new SimpleIntegerProperty();
	private Categorie			categorie;
	public static Article		instance;

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

	public String getDescription()
	{
		return description.get();
	}

	public StringProperty descriptionProperty()
	{
		return description;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Lien_Article_ArticleImage", joinColumns = @JoinColumn(name = "articleId") , inverseJoinColumns = @JoinColumn(name = "imageId") )
	public Set<ArticleImage> getImages()
	{
		return images;
	}

	@Column(nullable = false)
	public float getTauxTVA()
	{
		return tauxTVA.get();
	}

	public FloatProperty prixHTProperty()
	{
		return tauxTVA;
	}

	@Column(nullable = false)
	public float getPrixTTC()
	{
		return prixTTC.get();
	}

	public FloatProperty prixTTCProperty()
	{
		return prixTTC;
	}

	@Column(nullable = false)
	public int getStock()
	{
		return stock.get();
	}

	public IntegerProperty stockProperty()
	{
		return stock;
	}

	@OneToOne
	@JoinColumn(name = "idCategorie")
	public Categorie getCategorie()
	{
		return categorie;
	}

	//Setters
	public void setId(long id)
	{
		this.id.set(id);
	}

	@Column(nullable = false)
	public void setLibelle(String libelle)
	{
		this.libelle.set(libelle);
	}

	public void setDescription(String description)
	{
		this.description.set(description);
	}

	public void setImages(Set<ArticleImage> images)
	{
		this.images = images;
	}

	@Column(nullable = false)
	public void setTauxTVA(float prixHT)
	{
		this.tauxTVA.set(prixHT);
	}

	@Column(nullable = false)
	public void setPrixTTC(float prixTTC)
	{
		this.prixTTC.set(prixTTC);
	}

	@Column(nullable = false)
	public void setStock(int stock)
	{
		this.stock.set(stock);
	}

	@Column(nullable = false)
	public void setCategorie(Categorie categorie)
	{
		this.categorie = categorie;
	}

	//Constructeurs
	public Article()
	{
	}

	public Article(String libelle, String description, float tauxTVA, float prixTTC, int stock, Categorie categorie)
	{
		this.libelle.set(libelle);
		this.description.set(description);
		this.tauxTVA.set(tauxTVA);
		this.prixTTC.set(prixTTC);
		this.stock.set(stock);
		this.categorie = categorie;
	}

	//Générateur
	public static void generate(Session session)
	{
		/*
		Article article1 = new Article("Piano à queue SAMICK SIG 48", "Piano de type crapaud de faible encombrement (146cm)...un prix incroyable", 20, 7790.000f, 3, 12000, (Categorie) session.get(Categorie.class, new Long(2)));
		session.save(article1);
		*/
	}
}
