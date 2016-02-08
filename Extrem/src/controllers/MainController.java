package controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import utilitaires.helpers.ViewHelper;

public class MainController
{

	@FXML
	private Label		blockProfilIconEmploye;

	@FXML
	private Label		blockProfilEmployeNom;

	@FXML
	private HBox		topBar;

	@FXML
	private Label		iconDeconnexion;

	@FXML
	private Label		blockProfilIconMessagerie;

	@FXML
	private Label		blockProfilIconStat;

	@FXML
	private Label		blockProfilIconEvenements;

	@FXML
	private Label		blockProfilIconParametres;

	@FXML
	private VBox		flashMessageContainer;

	@FXML
	private Label		flashMessageText;

	@FXML
	private VBox		mainMenu;

	@FXML
	private HBox		clientMenu;

	@FXML
	private Label		iconClient;

	@FXML
	private HBox		articleMenu;

	@FXML
	private Label		iconArticle;

	@FXML
	private HBox		fournisseurMenu;

	@FXML
	private Label		iconFournisseur;

	@FXML
	private HBox		employesMenu;

	@FXML
	private Label		iconEmploye;

	@FXML
	private HBox		evenementsMenu;

	@FXML
	private Label		iconEvenement;

	@FXML
	private HBox		calendrierMenu;

	@FXML
	private Label		iconCalendrier;

	@FXML
	private HBox		statistiquesMenu;

	@FXML
	private Label		iconStatistiques;

	@FXML
	private HBox		parametresMenu;

	@FXML
	private Label		iconParametres;

	@FXML
	private Label		block1Text;

	@FXML
	private StackPane	block1;

	@FXML
	private Label		block2Text;

	@FXML
	private StackPane	block2;

	@FXML
	private Label		block3Text;

	@FXML
	private StackPane	block3;

	@FXML
	private Label		blockContentText;

	@FXML
	private StackPane	blockContent;

	//Menu actif
	private Node		activeMenu;

	@FXML
	public void initialize()
	{
		//TODO : Enregistrement des liens des menus (EX: articleMenu -> new ViewCombinaison(3);&>
	}

	@FXML
	private void onDeconnexionMenuClicked()
	{
		System.out.println("Déco");
	}

	@FXML
	private void onAccueilMenuClicked()
	{
		System.out.println("Accueil");
	}

	@FXML
	void onMenuClicked(MouseEvent event)
	{
		if (event.getSource().equals(articleMenu))
		{
			ViewHelper.switchView(blockContent, "articles");
		}
		else if (event.getSource().equals(employesMenu))
		{
			ViewHelper.switchView(blockContent, "employes");
		}

		updateActiveMenu();
	}

	/*** Application du style sur les HBox du MainMenu ***/
	public void updateActiveMenu()
	{
		if (activeMenu != null)
			activeMenu.getStyleClass().remove("menuActive");

		System.out.println(ViewHelper.getLoadedViews());

		//activeMenu = newActiveMenu;
		//activeMenu.getStyleClass().add("menuActive");
	}
}
