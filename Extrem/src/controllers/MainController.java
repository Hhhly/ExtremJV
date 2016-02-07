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
		// Définition des GlyphsIcon
		// Block profil
		blockProfilIconEmploye.setText("\uf21b");
		blockProfilIconMessagerie.setText("\uf086");
		blockProfilIconStat.setText("\uf1fe");
		blockProfilIconEvenements.setText("\uf091");
		blockProfilIconParametres.setText("\uf0ad");

		// TopBar
		iconDeconnexion.setText("\uf011");

		// MenuGauche
		iconClient.setText("\uf007");
		iconArticle.setText("\uf135");
		iconFournisseur.setText("\uf0d1");
		iconEvenement.setText("\uf091");
		iconEmploye.setText("\uf21b");
		iconCalendrier.setText("\uf073");
		iconStatistiques.setText("\uf1fe");
		iconParametres.setText("\uf0ad");
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
			changeStyle((Node) event.getSource(), activeMenu);
		}
	}

	/*** Application du style sur les HBox du MainMenu ***/
	public static void changeStyle(Node node, Node activeMenu)
	{
		if (activeMenu != null)
			activeMenu.getStyleClass().remove("menuActive");

		node.getStyleClass().add("menuActive");
		activeMenu = node;
	}
}
