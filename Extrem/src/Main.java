import java.io.IOException;
import java.util.ResourceBundle;

import beans.Article;
import beans.Categorie;
import beans.Employe;
import beans.Occasion;
import beans.Organisme;
import beans.Particulier;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilitaires.ExtremError;
import utilitaires.bdd.DB;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setResources(ResourceBundle.getBundle("font.Font-Awesome"));
			Scene scene = new Scene(fxmlLoader.load(getClass().getResource("/views/main.fxml").openStream()));
			scene.getStylesheets().add("/css/style.css");
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.setTitle("Extrem JV");
			primaryStage.show();
		}
		catch (IOException e)
		{
			new ExtremError(e);
		}
	}

	public static void main(String[] args)
	{
		try
		{
			generate();
			launch(args);
		}
		catch (Exception e)
		{
			new ExtremError(e);
		}
	}

	public static void generate() throws Exception
	{
		//G�n�ration des cat�gories
		if (DB.count(Categorie.class) <= 0)
			Categorie.generate();

		//G�n�ration des articles et g�n�ration des articles d'occasion
		if (DB.count(Article.class) <= 0 && DB.count(Occasion.class) <= 0)
		{
			Article.generate();
			Occasion.generate();
		}

		//G�n�ration des employ�s de test et g�n�ration de particuliers (clients, etc...)
		if (DB.count(Employe.class) <= 0 && DB.count(Particulier.class) <= 0)
		{
			Employe.generate();
			Particulier.generate();
		}

		//G�n�ration des organismes (Assos, Entreprises)
		if (DB.count(Organisme.class) <= 0)
			Organisme.generate();
	}
}