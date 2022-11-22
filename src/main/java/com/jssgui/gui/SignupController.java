package com.jssgui.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import java.sql.Date;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable{
    @FXML
    private Button buttonSubmit;
    @FXML
    private Button buttonCancel;

    @FXML
    private ScrollPane scrollSign;

    @FXML
    private TextField tfFirst;
    @FXML
    private TextField tfLast;
    @FXML
    private TextField tfUser;
    @FXML
    private TextField tfPass;
    @FXML
    private TextField tfPassConfirm;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfDob;
    @FXML
    private TextField tfContact;
    @FXML
    private TextField tfAddress;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfState;
    @FXML
    private TextField tfPost;
    @FXML
    private TextField tfCountry;
    @FXML
    private TextField tfEdu;
    @FXML
    private TextField tfCompletion;
    @FXML
    private TextField tfSkills;

    @FXML
    private TextField tfCompany;
    @FXML
    private TextField tfCompEmail;
    @FXML
    private TextField tfCompNo;
    @FXML
    private TextField tfCompAddress;
    @FXML
    private TextField tfCompCity;
    @FXML
    private TextField tfCompState;
    @FXML
    private TextField tfCompPost;
    @FXML
    private TextField tfCompCountry;

    @FXML
    private Label userError;
    @FXML
    private Label blankError;

    UserInstance inst = UserInstance.getInstance();

    public void initialize(URL location, ResourceBundle resources){
        User user = inst.getUser();
        blankError.setText("Test User Type - " + user.getUserTypeID()); //test user type

        tfCompletion.disableProperty().bind(tfEdu.textProperty().isEmpty());
        if (user.getUserTypeID() == 1){
            buttonSubmit.disableProperty().bind(tfFirst.textProperty().isEmpty().or(tfLast.textProperty().isEmpty()).or(tfUser.textProperty().isEmpty()).or(tfPass.textProperty().isEmpty()).or(tfPassConfirm.textProperty().isEmpty()).or(tfEmail.textProperty().isEmpty()).or(tfDob.textProperty().isEmpty()).or(tfContact.textProperty().isEmpty()).or(tfAddress.textProperty().isEmpty()).or(tfCity.textProperty().isEmpty()).or(tfState.textProperty().isEmpty()).or(tfPost.textProperty().isEmpty()).or(tfCountry.textProperty().isEmpty()));
        }
        else{
            buttonSubmit.disableProperty().bind(tfFirst.textProperty().isEmpty().or(tfLast.textProperty().isEmpty()).or(tfUser.textProperty().isEmpty()).or(tfPass.textProperty().isEmpty()).or(tfPassConfirm.textProperty().isEmpty()).or(tfEmail.textProperty().isEmpty()).or(tfDob.textProperty().isEmpty()).or(tfContact.textProperty().isEmpty()).or(tfAddress.textProperty().isEmpty()).or(tfCity.textProperty().isEmpty()).or(tfState.textProperty().isEmpty()).or(tfPost.textProperty().isEmpty()).or(tfCountry.textProperty().isEmpty()).or(tfCompany.textProperty().isEmpty()).or(tfCompEmail.textProperty().isEmpty()).or(tfCompNo.textProperty().isEmpty()).or(tfCompAddress.textProperty().isEmpty()).or(tfCompCity.textProperty().isEmpty()).or(tfCompState.textProperty().isEmpty()).or(tfCompPost.textProperty().isEmpty()).or(tfCompCountry.textProperty().isEmpty()));
        }

        buttonSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!tfPass.getText().isEmpty() && tfPass.getText().equals(tfPassConfirm.getText())) {
                    if (user.getUserTypeID() == 1){
                        Utility.signUp(event, "DashJS.fxml", user.getUserTypeID(), tfUser.getText(), tfPass.getText(), tfFirst.getText(), tfLast.getText(), tfEmail.getText(), Date.valueOf(tfDob.getText()), tfContact.getText(), tfAddress.getText(), tfCity.getText(), tfState.getText(), tfPost.getText(), tfCountry.getText(), tfEdu.getText(), tfCompletion.getText(), tfSkills.getText(), null, null, null, null, null, null, null, null);
                    }
                    else{
                        Utility.signUp(event, "DashR.fxml", user.getUserTypeID(), tfUser.getText(), tfPass.getText(), tfFirst.getText(), tfLast.getText(), tfEmail.getText(), Date.valueOf(tfDob.getText()), tfContact.getText(), tfAddress.getText(), tfCity.getText(), tfState.getText(), tfPost.getText(), tfCountry.getText(), tfEdu.getText(), tfCompletion.getText(), tfSkills.getText(), tfCompany.getText(), tfCompEmail.getText(), tfCompNo.getText(), tfCompAddress.getText(), tfCompCity.getText(), tfCompState.getText(), tfCompPost.getText(), tfCompCountry.getText());
                    }
                }
                else {
                    scrollSign.setVvalue(0);
                    blankError.setText("Passwords Do Not Match. Please Try Again");
                }
            }
        });

        buttonCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Utility.changeScene(event,"Login.fxml");
            }
        });
    }
    //userError.setText("Username Already Taken. Please Try Again.");
}
