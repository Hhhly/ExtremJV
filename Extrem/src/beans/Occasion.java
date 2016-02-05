package beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.Session;

import beans.enumerations.OccasionEtat;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@PrimaryKeyJoinColumn(name = "idArticle")
public class Occasion extends Article
{
	//Propriétés
	private OccasionEtat		etat;
	private StringProperty		description	= new SimpleStringProperty();
	private Set<ArticleImage>	images;

	//Getters
	@Column(nullable = false)
	public OccasionEtat getEtat()
	{
		return etat;
	}

	public String getDescription()
	{
		return description.get();
	}

	public StringProperty descriptionProperty()
	{
		return description;
	}

	public Set<ArticleImage> getImages()
	{
		return images;
	}

	//Setters
	public void setEtat(OccasionEtat etat)
	{
		this.etat = etat;
	}

	public void setDescription(String description)
	{
		this.description.set(description);
	}

	public void setImages(Set<ArticleImage> images)
	{
		this.images = images;
	}

	//Constructeurs
	public Occasion()
	{

	}

	public Occasion(OccasionEtat etat, Set<ArticleImage> images, String description)
	{
		this.etat = etat;
		this.images = images;
		this.description.set(description);
	}

	//Générateur
	public static void generate(Session session)
	{

	}
}