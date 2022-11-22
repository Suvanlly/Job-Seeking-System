package com.jssgui.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    UserInstance inst = UserInstance.getInstance();

    @FXML
    private AnchorPane paneSign;

    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonJ;
    @FXML
    private Button buttonR;
    @FXML
    private Hyperlink buttonSign;

    @FXML
    private TextField userID;
    @FXML
    private PasswordField passID;
    @FXML
    private Label wrong;

    public LoginController(){}

    public void initialize(URL location, ResourceBundle resources) {
        buttonLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!userID.getText().isEmpty() && !passID.getText().isEmpty()){
                    Utility.logInUser(event, userID.getText(), passID.getText());
                }
                else if(userID.getText().isEmpty() && passID.getText().isEmpty()){
                    wrong.setText("Please Enter Your Credentials.");
                }
                else if(userID.getText().isEmpty() && !passID.getText().isEmpty()){
                    wrong.setText("Please Enter A Username.");
                }
                else {
                    wrong.setText("Please Enter A Password.");
                }
            }
        });

        buttonSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                paneSign.toFront();
            }
        });

        buttonJ.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                User u = inst.getUser();
                u.setUserTypeID(1);
                Utility.changeScene(event, "SignUpJS.fxml");

            }
        });

        buttonR.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                User u = inst.getUser();
                u.setUserTypeID(2);
                Utility.changeScene(event, "SignUpR.fxml");
            }
        });
    }

    //wrong.setText("Incorrect Username or Password. Please Try Again.");
}
