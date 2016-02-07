package utilitaires.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class FormHelper
{
	@SuppressWarnings("unchecked")
	public static <T> List<T> getNodesOfType(Pane parent, Class<T> type)
	{
		List<T> elements = new ArrayList<>();
		for (Node node : parent.getChildren())
		{
			if (node instanceof Pane)
				elements.addAll(getNodesOfType((Pane) node, type));
			else if (type.isAssignableFrom(node.getClass()))
				elements.add((T) node);
		}
		return Collections.unmodifiableList(elements);
	}

	public static boolean validateFields(Pane fieldsParent)
	{
		boolean isValid = true;
		for (Node node : FormHelper.getNodesOfType(fieldsParent, Node.class))
			isValid = (isValid == true) ? validateNode(node) : false;

		return isValid;
	}

	private static boolean validateNode(Node node)
	{
		boolean isValid = true;
		String errorMessage = null;

		boolean isRequired = node.getStyleClass().contains("required");
		boolean isMail = node.getStyleClass().contains("mail");
		boolean isPhone = node.getStyleClass().contains("phoneNumber");
		boolean isDate = node.getStyleClass().contains("date");

		//System.out.println("Validation du noeud : " + node + "\r\tisRequired : " + isRequired + "\r\tisMail : " + isMail + "\r\tisPhone : " + isPhone + "\r\tisDate : " + isDate);

		//Si le champ contient des informations, on les check
		if (!isEmpty(node))
		{
			if (isMail && !isValidMail(node))
			{
				errorMessage = "Le mail saisi est incorrect";
				isValid = false;
			}
			if (isPhone && !isValidPhoneNumber(node))
			{
				errorMessage = "Le numéro saisi est incorrect";
				isValid = false;
			}
			if (isDate && !isValidDate(node))
			{
				errorMessage = "La date saisie est incorrecte";
				isValid = false;
			}
		}
		//S'il n'y en a pas, on vérifie s'il faut obligatoirement en mettre
		else
		{
			if (isRequired)
			{
				errorMessage = "Le champ ne peut être vide";
				isValid = false;
			}
		}

		handleErrorStyle(isValid, node);
		handleErrorLabel(isValid, node, errorMessage);

		return isValid;
	}

	public static boolean isValidMail(Node node)
	{
		if (node instanceof TextField)
		{
			TextField mailField = (TextField) node;
			mailField.setText(mailField.getText().replace(" ", ""));
			boolean isValid = mailField.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			return isValid;
		}
		else
			return true;
	}

	public static boolean isValidPhoneNumber(Node node)
	{
		if (node instanceof TextField)
		{
			TextField phoneField = (TextField) node;
			String valueToParse = phoneField.getText();
			valueToParse = valueToParse.replace(" ", "");
			valueToParse = valueToParse.replaceFirst("^(\\+33|0|0033)", "0");
			valueToParse = valueToParse.replaceAll("^(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})", "$1 $2 $3 $4 $5");
			boolean isValid = valueToParse.matches("^((\\d{2}) ){4}(\\d{2})");
			
			if (isValid)
				phoneField.setText(valueToParse);
			return isValid;
		}
		else
			return true;
	}

	public static boolean isValidDate(Node node)
	{
		if (node instanceof DatePicker)
		{
			DatePicker dateField = (DatePicker) node;
			dateField.getEditor().setText(dateField.getEditor().getText().replace(" ", ""));
			boolean isValid = dateField.getValue() != null;
			return isValid;
		}
		else
			return true;
	}

	public static boolean isEmpty(Node node)
	{
		if (node instanceof TextField)
			return ((TextField) node).getText().replace(" ", "").isEmpty();
		else if (node instanceof DatePicker)
			return ((DatePicker) node).getEditor().getText().replace(" ", "").isEmpty();
		else if (node instanceof ComboBox)
			return ((ComboBox<?>) node).getValue().toString().replace(" ", "").isEmpty();

		return false;
	}

	private static void handleErrorStyle(boolean isValid, Node node)
	{
		if (!isValid)
		{
			if (!node.getStyleClass().contains("error"))
				node.getStyleClass().add("error");
		}
		else
		{
			if (node.getStyleClass().contains("error"))
				node.getStyleClass().remove("error");
		}
	}

	private static void handleErrorLabel(boolean isValid, Node node, String errorString)
	{
		if (node.getParent() instanceof Pane)
		{
			Label errorLabel = null;
			Pane parent = (Pane) node.getParent();

			for (int i = parent.getChildren().size() - 1; i >= 0; i--)
			{
				Node childNode = parent.getChildren().get(i);
				if (childNode instanceof Label && childNode.getId() != null && childNode.getId().equals(node.getId() + "ErrorLabel"))
					parent.getChildren().remove(childNode);
			}

			if (!isValid)
			{
				errorLabel = new Label(errorString);
				errorLabel.setId(node.getId() + "ErrorLabel");
				errorLabel.getStyleClass().add("error");
				parent.getChildren().add(errorLabel);
			}
		}
		System.out.println(node);
		System.out.println("\t" + isValid);
	}
}