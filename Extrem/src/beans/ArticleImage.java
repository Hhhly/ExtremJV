package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
public class ArticleImage
{

	//Propriétés
	private LongProperty						id				= new SimpleLongProperty();
	private StringProperty						path			= new SimpleStringProperty();
	private Article								article;

	//Getters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId()
	{
		return id.get();
	}

	@Column(nullable = false)
	public String getPath()
	{
		return path.get();
	}

	@ManyToOne
	@JoinColumn(name = "idArticle", insertable = false, updatable = false, nullable = false)
	public Article getArticle()
	{
		return article;
	}

	//Setters
	public void setId(long id)
	{
		this.id.set(id);
	}

	public void setPath(String path)
	{
		this.path.set(path);
	}

	public void setArticle(Article article)
	{
		this.article = article;
	}

	//Constructeurs
	public ArticleImage()
	{
	}

	public ArticleImage(String path, Article article)
	{
		this.path.set(path);
		this.article = article;
	}
}