import java.io.IOException;

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
import utilitaires.bdd.CRUD;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/views/main.fxml")));
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
		//Génération des catégories
		if (CRUD.count(Categorie.class) <= 0)
			Categorie.generate();

		//Génération des articles
		if (CRUD.count(Article.class) <= 0)
			Article.generate();

		//Génération des articles d'occasion
		if (CRUD.count(Occasion.class) <= 0)
			Occasion.generate();

		//Génération des employés de test
		if (CRUD.count(Employe.class) <= 0)
			Employe.generate();

		//Génération de particuliers (clients, etc...)
		if (CRUD.count(Particulier.class) <= 0)
			Particulier.generate();

		//Génération des organismes (Assos, Entreprises)
		if (CRUD.count(Organisme.class) <= 0)
			Organisme.generate();
	}
}