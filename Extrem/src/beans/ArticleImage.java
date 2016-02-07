package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	//Setters
	public void setId(long id)
	{
		this.id.set(id);
	}

	public void setPath(String path)
	{
		this.path.set(path);
	}

	//Constructeurs
	public ArticleImage()
	{
	}

	public ArticleImage(String path)
	{
		this.path.set(path);
	}
}