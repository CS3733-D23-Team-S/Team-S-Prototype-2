package edu.wpi.teamname.controllers;

import edu.wpi.teamname.App;
import edu.wpi.teamname.Database.LoaderDAO;
import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.io.File;

public class CSVController {

	private FileChooser fileChooser = new FileChooser();
	DirectoryChooser directoryChooser = new DirectoryChooser();
	@FXML MFXButton backButton;
	@FXML
	MFXComboBox<String> exportOptions = new MFXComboBox<>();

	@FXML MFXButton importButton;
	@FXML MFXButton exportButton;


	@FXML
	public void initialize() {
		backButton.setOnMouseClicked(event -> Navigation.navigate(Screen.HOME));
		importButton.setOnMouseClicked(event -> importCSVOnClick());
		exportButton.setOnMouseClicked(event -> exportCSVOnClick());
		exportOptions.getItems().add("Nodes");
		exportOptions.getItems().add("Edges");
		exportOptions.getItems().add("Locations");
		exportOptions.getItems().add("Moves");
	}

	private void importCSVOnClick(){
		File selectedFile = fileChooser.showOpenDialog(App.getPrimaryStage());
		String path = selectedFile.toString();
		char choice =  exportOptions.getSelectionModel().getSelectedItem().toLowerCase().charAt(0);
		LoaderDAO.getInstance().loadCSV(path, choice);
	}

	private void exportCSVOnClick(){
		File outputDirectory = directoryChooser.showDialog(App.getPrimaryStage());
		String path = outputDirectory.toString();
		LoaderDAO.getInstance().exportCSVs(path);
	}

}
