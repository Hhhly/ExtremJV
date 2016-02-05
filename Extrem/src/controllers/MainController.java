package controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainController {

	@FXML
	private Label blockProfilIconEmploye;

	@FXML
	private Label blockProfilEmployeNom;

	@FXML
	private HBox topBar;

	@FXML
	private Label iconDeconnexion;

	@FXML
	private Label blockProfilIconMessagerie;

	@FXML
	private Label blockProfilIconStat;

	@FXML
	private Label blockProfilIconEvenements;

	@FXML
	private Label blockProfilIconParametres;

	@FXML
	private VBox flashMessageContainer;

	@FXML
	private Label flashMessageText;

	@FXML
	private VBox mainMenu;

	@FXML
	private HBox clientMenu;

	@FXML
	private Label iconClient;

	@FXML
	private HBox articleMenu;

	@FXML
	private Label iconArticle;

	@FXML
	private HBox fournisseurMenu;

	@FXML
	private Label iconFournisseur;

	@FXML
	private HBox employesMenu;

	@FXML
	private Label iconEmploye;

	@FXML
	private HBox evenementsMenu;

	@FXML
	private Label iconEvenement;

	@FXML
	private HBox calendrierMenu;

	@FXML
	private Label iconCalendrier;

	@FXML
	private HBox statistiquesMenu;

	@FXML
	private Label iconStatistiques;

	@FXML
	private HBox parametresMenu;

	@FXML
	private Label iconParametres;

	@FXML
	private Label block1Text;

	@FXML
	private AnchorPane block1;

	@FXML
	private Label block2Text;

	@FXML
	private AnchorPane block2;

	@FXML
	private Label block3Text;

	@FXML
	private AnchorPane block3;

	@FXML
	private Label blockContentText;

	@FXML
	private AnchorPane blockContent;

	@FXML
	private static MainController instance;

	public static MainController getInstance() {
		return instance;
	}

	private static Node activeMenu;

	@FXML
	public void initialize() {
		// Instantiation du Singleton
		if (instance == null)
			instance = this;

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

	/*** Application du style sur les HBox du MainMenu ***/

	public static void changeStyle(Node node) {

		if (activeMenu != null)
			activeMenu.getStyleClass().remove("menuActive");

		activeMenu = node;
		activeMenu.getStyleClass().add("menuActive");

		System.out.println(node);
	}

	@FXML
	void onAccueuilMenuClicked(MouseEvent event) {

	}

	@FXML
	void onBlockProfilIconEvenementsClicked(MouseEvent event) {
		changeStyle(blockProfilIconEvenements);
	}

	@FXML
	void onBlockProfilIconMessagerieClicked(MouseEvent event) {
		changeStyle(blockProfilIconMessagerie);
	}

	@FXML
	void onBlockProfilIconParametresClicked(MouseEvent event) {
		changeStyle(blockProfilIconParametres);
	}

	@FXML
	void onBlockProfilIconStatClicked(MouseEvent event) {
		changeStyle(blockProfilIconStat);
	}

	@FXML
	void onDeconnexionMenuClicked(MouseEvent event) {

	}

	@FXML
	void onClientMenuClicked(MouseEvent event) {
		changeStyle(clientMenu);

	}

	@FXML
	void onArticleMenuClicked(MouseEvent event) {
		changeStyle(articleMenu);
	}

	@FXML
	void onFournisseurMenuClicked(MouseEvent event) {
		changeStyle(fournisseurMenu);
	}

	@FXML
	void onEmployesMenuClicked(MouseEvent event) {
		changeStyle(employesMenu);
	}

	@FXML
	void onEvenementsMenuClicked(MouseEvent event) {
		changeStyle(evenementsMenu);
	}

	@FXML
	void onCalendrierMenuClicked(MouseEvent event) {
		changeStyle(calendrierMenu);
	}

	@FXML
	void onStatistiquesMenuClicked(MouseEvent event) {
		changeStyle(statistiquesMenu);
	}

	@FXML
	void onParametresMenuClicked(MouseEvent event) {
		changeStyle(parametresMenu);
	}

}
