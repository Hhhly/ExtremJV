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
		//G�n�ration des cat�gories
		if (CRUD.count(Categorie.class) <= 0)
			Categorie.generate();

		//G�n�ration des articles
		if (CRUD.count(Article.class) <= 0)
			Article.generate();

		//G�n�ration des articles d'occasion
		if (CRUD.count(Occasion.class) <= 0)
			Occasion.generate();

		//G�n�ration des employ�s de test
		if (CRUD.count(Employe.class) <= 0)
			Employe.generate();

		//G�n�ration de particuliers (clients, etc...)
		if (CRUD.count(Particulier.class) <= 0)
			Particulier.generate();

		//G�n�ration des organismes (Assos, Entreprises)
		if (CRUD.count(Organisme.class) <= 0)
			Organisme.generate();
	}
}