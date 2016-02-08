package beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import beans.enumerations.OccasionEtat;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import utilitaires.bdd.DB;

@Entity
@Table(name = "occasion")
public class Occasion
{
	//Propriétés
	private LongProperty					id				= new SimpleLongProperty();
	private ObjectProperty<OccasionEtat>	etat			= new SimpleObjectProperty<>();
	private StringProperty					description	= new SimpleStringProperty();
	private FloatProperty					prixTTC		= new SimpleFloatProperty();
	private FloatProperty					tauxTVA		= new SimpleFloatProperty();
	private Set<ArticleImage>				images			= new HashSet<>();
	private Article							article;

	//Getters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId()
	{
		return id.get();
	}

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public OccasionEtat getEtat()
	{
		return etat.get();
	}

	public String getDescription()
	{
		return description.get();
	}

	public StringProperty descriptionProperty()
	{
		return description;
	}

	public float getPrixTTC()
	{
		return prixTTC.get();
	}

	public FloatProperty prixTTCProperty()
	{
		return prixTTC;
	}

	public float getTauxTVA()
	{
		return tauxTVA.get();
	}

	public FloatProperty tauxTVAProperty()
	{
		return tauxTVA;
	}

	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinTable(name = "LienOccasionImage", joinColumns = @JoinColumn(name = "imageId") , inverseJoinColumns = @JoinColumn(name = "occasionId") )
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idOccasion")
	public Set<ArticleImage> getImages()
	{
		return images;
	}

	@OneToOne
	@JoinColumn(name = "idArticle")
	public Article getArticle()
	{
		return article;
	}

	//Setters
	public void setId(long id)
	{
		this.id.set(id);
	}

	public void setEtat(OccasionEtat etat)
	{
		this.etat.set(etat);
	}

	public void setDescription(String description)
	{
		this.description.set(description);
	}

	public void setPrixTTC(float prixTTC)
	{
		this.prixTTC.set(prixTTC);
	}

	public void setTauxTVA(float tauxTVA)
	{
		this.tauxTVA.set(tauxTVA);
	}

	public void setImages(Set<ArticleImage> images)
	{
		this.images = images;
	}

	public void setArticle(Article article)
	{
		this.article = article;
	}

	//Constructeurs
	public Occasion()
	{

	}

	public Occasion(OccasionEtat etat, String description, float prixTTC, float tauxTVA, Article article)
	{
		this.etat.set(etat);
		this.description.set(description);
		this.prixTTC.set(prixTTC);
		this.tauxTVA.set(tauxTVA);
		this.article = article;
	}

	//Générateur
	public static void generate()
	{
		Occasion occasion1 = new Occasion(OccasionEtat.CORRECT, "", 29.99f, 20, DB.read(Article.class, 1l));
		DB.create(occasion1);

		Occasion occasion2 = new Occasion(OccasionEtat.COMME_NEUF, "Le livret n'est pas disponible", 35f, 20, DB.read(Article.class, 5l));
		Set<ArticleImage> imagesOccasion2 = new HashSet<>();
		imagesOccasion2.add(new ArticleImage("Jeux/PS4/TheWitcher3WildHunt/Occasions/f40423159426790ef8e580a4bfaa62a54cd36e0b.jpg"));
		occasion2.setImages(imagesOccasion2);
		DB.create(occasion2);
	}
}