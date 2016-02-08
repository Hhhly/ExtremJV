package beans;

import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import utilitaires.bdd.DB;

@Entity
@Table(name = "article")
@Inheritance(strategy = InheritanceType.JOINED)
public class Article
{
	//Propriétés
	private LongProperty		id			= new SimpleLongProperty();
	private StringProperty		libelle		= new SimpleStringProperty();
	private StringProperty		description	= new SimpleStringProperty();
	private ArticleImage		vignette;
	private Set<ArticleImage>	images		= new HashSet<>();
	private FloatProperty		tauxTVA		= new SimpleFloatProperty();
	private FloatProperty		prixTTC		= new SimpleFloatProperty();
	private IntegerProperty		stock		= new SimpleIntegerProperty();
	private Categorie			categorie;

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

	@OneToOne
	@JoinColumn(name = "idVignette")
	public ArticleImage getVignette()
	{
		return vignette;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idArticle")
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

	public void setLibelle(String libelle)
	{
		this.libelle.set(libelle);
	}

	public void setDescription(String description)
	{
		this.description.set(description);
	}

	public void setVignette(ArticleImage vignette)
	{
		this.vignette = vignette;
	}

	public void setImages(Set<ArticleImage> images)
	{
		this.images = images;
	}

	public void setTauxTVA(float prixHT)
	{
		this.tauxTVA.set(prixHT);
	}

	public void setPrixTTC(float prixTTC)
	{
		this.prixTTC.set(prixTTC);
	}

	public void setStock(int stock)
	{
		this.stock.set(stock);
	}

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
	public static void generate()
	{
		//Console PS4
		Article consolePS4 = new Article("Playstation 4", "", 20, 349.99f, 14, (Categorie) DB.read(Categorie.class, new Long(2)));
		ArticleImage consolePS4Vignette = new ArticleImage("Consoles/PS4/Playstation4/ok2_1.jpg");
		consolePS4.setVignette(consolePS4Vignette);
		DB.create(consolePS4Vignette);
		consolePS4.getImages().add(new ArticleImage("Consoles/PS4/Playstation4/psquatre1_1_3.jpg"));
		consolePS4.getImages().add(new ArticleImage("Consoles/PS4/Playstation4/psquatre2_1.jpg"));
		consolePS4.getImages().add(new ArticleImage("Consoles/PS4/Playstation4/psquatre3_1.jpg"));
		DB.create(consolePS4);


		//Console XBoxOne
		Article consoleXBoxOne = new Article("Xbox One 500 Go", "", 20, 329.99f, 14, (Categorie) DB.read(Categorie.class, new Long(3)));
		ArticleImage consoleXBoxOneVignette = new ArticleImage("Consoles/XBoxOne/XboxOne500Go/sans_titre-1_1_7.jpg");
		consoleXBoxOne.setVignette(consoleXBoxOneVignette);
		DB.create(consoleXBoxOneVignette);
		consoleXBoxOne.getImages().add(new ArticleImage("Consoles/XBoxOne/XboxOne500Go/xbox_20one_console_f_tilt-1000.jpg"));
		consoleXBoxOne.getImages().add(new ArticleImage("Consoles/XBoxOne/XboxOne500Go/xbox_20one_console_rhs78-1000.jpg"));
		consoleXBoxOne.getImages().add(new ArticleImage("Consoles/XBoxOne/XboxOne500Go/xbox_controller_f_transbg_rgb_2013_3.jpg"));
		DB.create(consoleXBoxOne);

		//Jeux PS4
		Article jeuxPS4_1 = new Article("Assassin's Creed Chronicle", "", 20, 29.99f, 17, (Categorie) DB.read(Categorie.class, new Long(5)));
		jeuxPS4_1.getImages().add(new ArticleImage("Jeux/PS4/AssassinsCreedChronicle/ac_chronicles_trilogie_ps4.jpg"));
		DB.create(jeuxPS4_1);

		Article jeuxPS4_2 = new Article("Naruto Shippuden Ultimate Ninja Storm 4", "", 20, 49.99f, 19, (Categorie) DB.read(Categorie.class, new Long(5)));
		jeuxPS4_2.getImages().add(new ArticleImage("Jeux/PS4/NarutoShippudenUltimateNinjaStorm4/naruto_uns_4_ps4.jpg"));
		DB.create(jeuxPS4_2);

		Article jeuxPS4_3 = new Article("The Witcher 3 Wild Hunt", "", 20, 49.99f, 14, (Categorie) DB.read(Categorie.class, new Long(5)));
		jeuxPS4_3.getImages().add(new ArticleImage("Jeux/PS4/TheWitcher3WildHunt/the_witcher_3_ps4_3.jpg"));
		DB.create(jeuxPS4_3);

		//Jeux XBoxOne
		Article jeuxXBoxOne1 = new Article("Agatha Christie The ABC Murders", "", 20, 39.99f, 3, (Categorie) DB.read(Categorie.class, new Long(6)));
		jeuxXBoxOne1.getImages().add(new ArticleImage("Jeux/XBoxOne/AgathaChristieTheABCMurders/agatha_abc_one.jpg"));
		DB.create(jeuxXBoxOne1);

		Article jeuxXBoxOne2 = new Article("Sebastien Loeb Rally Evo", "", 20, 69.99f, 8, (Categorie) DB.read(Categorie.class, new Long(6)));
		jeuxXBoxOne2.getImages().add(new ArticleImage("Jeux/XBoxOne/SebastienLoebRallyEvo/seb_loeb_one.jpg"));
		DB.create(jeuxXBoxOne2);

		Article jeuxXBoxOne3 = new Article("This War of Mine : The Little Ones", "", 20, 29.99f, 11, (Categorie) DB.read(Categorie.class, new Long(6)));
		jeuxXBoxOne3.getImages().add(new ArticleImage("Jeux/XBoxOne/ThisWarofMineTheLittleOnes/this_war_of_mine_the_little_ones.jpg"));
		DB.create(jeuxXBoxOne3);

		//Accessoires PS4
		Article accessoirePS4 = new Article("Arcade Fightstick TE2 Street Fighter V - Chun Li", "", 20, 249.99f, 6, (Categorie) DB.read(Categorie.class, new Long(8)));
		accessoirePS4.getImages().add(new ArticleImage("Accessoires/PS4/ArcadeFightstickTE2StreetFighterVChunLi/stick_te2_chun_li_1_2.jpg"));
		accessoirePS4.getImages().add(new ArticleImage("Accessoires/PS4/ArcadeFightstickTE2StreetFighterVChunLi/stick_te2_chun_li_2.jpg"));
		accessoirePS4.getImages().add(new ArticleImage("Accessoires/PS4/ArcadeFightstickTE2StreetFighterVChunLi/stick_te2_chun_li_3.jpg"));
		accessoirePS4.getImages().add(new ArticleImage("Accessoires/PS4/ArcadeFightstickTE2StreetFighterVChunLi/stick_te2_chun_li_4.jpg"));
		accessoirePS4.getImages().add(new ArticleImage("Accessoires/PS4/ArcadeFightstickTE2StreetFighterVChunLi/stick_te2_chun_li_5.jpg"));
		DB.create(accessoirePS4);

		//Accessoires XBoxOne
		Article accessoireXboxOne = new Article("Manette Filaire Afterglow Prismatic", "", 20, 49.99f, 6, (Categorie) DB.read(Categorie.class, new Long(9)));
		accessoireXboxOne.getImages().add(new ArticleImage("Accessoires/XBoxOne/ManetteFilaireAfterglowPrismatic/manette_afterglow_prismatic_1.jpg"));
		accessoireXboxOne.getImages().add(new ArticleImage("Accessoires/XBoxOne/ManetteFilaireAfterglowPrismatic/manette_afterglow_prismatic_3.jpg"));
		accessoireXboxOne.getImages().add(new ArticleImage("Accessoires/XBoxOne/ManetteFilaireAfterglowPrismatic/manette_afterglow_prismatic_4.jpg"));
		accessoireXboxOne.getImages().add(new ArticleImage("Accessoires/XBoxOne/ManetteFilaireAfterglowPrismatic/manette_afterglow_prismatic_0_1.jpg"));
		DB.create(accessoireXboxOne);
	}
}
