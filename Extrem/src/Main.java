
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilitaires.ExtremError;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			Parent root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add("/css/style.css");
			primaryStage.centerOnScreen();
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
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
		launch(args);
	}
}