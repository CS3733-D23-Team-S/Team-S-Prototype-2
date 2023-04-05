package edu.wpi.teamname.controllers;

import static edu.wpi.teamname.navigation.Screen.HOME;

import edu.wpi.teamname.LoginPage;
import edu.wpi.teamname.navigation.Navigation;
import edu.wpi.teamname.navigation.Screen;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
  @FXML private MFXButton backButton;

  @FXML private Label errormessageLabel;

  @FXML private MFXButton loginbutton;

  @FXML private PasswordField pfPassword;

  @FXML private TextField tfUsername;

  private String errorMessage = "";

  private boolean isfieldFilled() {
    boolean isFilled = true;
    if (tfUsername.getText().isEmpty()) {
      isFilled = false;
      errorMessage = "Username is empty!";
    }

    if (pfPassword.getText().isEmpty()) {
      isFilled = false;
      if (errorMessage.isEmpty()) {
        errorMessage = "Password is empty!";
      } else {
        errorMessage += "\nPassword is empty!";
      }
    }
    errormessageLabel.setText(errorMessage);
    return isFilled;
  }

  private boolean isValid() {
    boolean isValid = true;
    if (!tfUsername.getText().equals(LoginPage.USERNAME)) {
      isValid = false;
      errorMessage = "Invalid Username!";
    }

    if (!pfPassword.getText().equals(LoginPage.PASSWORD)) {
      isValid = false;
      if (errorMessage.isEmpty()) {
        errorMessage = "Invalid Password!";
      } else {
        errorMessage += "\nInvalid Password!";
      }
    }
    errormessageLabel.setText(errorMessage);
    return isValid;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    backButton.setOnMouseClicked(event -> Navigation.navigate(Screen.WELCOME_PAGE));

    loginbutton.setOnMouseClicked(
        event -> {
          errorMessage = "";
          if (isfieldFilled() && isValid()) {
            Navigation.navigate(HOME);
          }
        });
  }
}
