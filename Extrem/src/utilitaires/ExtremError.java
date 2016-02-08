package utilitaires;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ExtremError
{
	public ExtremError(Exception e)
	{
		e.printStackTrace();
		afficherErreur(e.getLocalizedMessage());
		//TODO : fichier de log pour transfert mail
	}

	public ExtremError(String e)
	{
		afficherErreur(e);
	}

	private void afficherErreur(String erreur)
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erreur...");
		alert.setContentText(erreur);
		alert.showAndWait();
	}
}