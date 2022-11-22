package com.jssgui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashController implements Initializable {
    @FXML
    private BorderPane borderMain;

    @FXML
    private Button buttonDash;
    @FXML
    private Button buttonProfile;
    @FXML
    private Button buttonJobs;
    @FXML
    private Button buttonCandidates;
    @FXML
    private Button buttonSettings;
    @FXML
    private Button buttonChat;
    @FXML
    private Button buttonInbox;
    @FXML
    private Button buttonTopProfile;
    @FXML
    private Button buttonSearch;
    @FXML
    private Button buttonLogout;

    @FXML
    private Label labelHeader;
    @FXML
    private Label labelTest;

    @FXML
    private ProfileController profileController;


    UserInstance inst = UserInstance.getInstance();

    public DashController(){}

    public void initialize(URL location, ResourceBundle resources){
        labelTest.setText("Test - username: " + inst.getUser().getUsername() + " " + "typeID: " + inst.getUser().getUserTypeID()); //test
    }

    public void dashPress(ActionEvent event) {
        if (event.getSource() == buttonDash || event.getSource() == buttonChat || event.getSource() == buttonInbox){
            labelHeader.setText(buttonDash.getText());
            try {
                Parent centerPane = FXMLLoader.load(Utility.class.getResource("Dashboard.fxml"));
                borderMain.setCenter(centerPane);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else if (event.getSource() == buttonProfile || event.getSource() == buttonTopProfile){
            labelHeader.setText(buttonProfile.getText());
            try {
                Parent centerPane = FXMLLoader.load(Utility.class.getResource("Profile.fxml"));
                borderMain.setCenter(centerPane);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else if (event.getSource() == buttonJobs){
            labelHeader.setText(buttonJobs.getText());
            try {
                Parent centerPane = FXMLLoader.load(Utility.class.getResource("Jobs.fxml"));
                borderMain.setCenter(centerPane);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else if (event.getSource() == buttonCandidates){
            labelHeader.setText(buttonCandidates.getText());
            try {
                Parent centerPane = FXMLLoader.load(Utility.class.getResource("Candidates.fxml"));
                borderMain.setCenter(centerPane);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else if (event.getSource() == buttonSettings){
            labelHeader.setText(buttonSettings.getText());
            try {
                Parent centerPane = FXMLLoader.load(Utility.class.getResource("Settings.fxml"));
                borderMain.setCenter(centerPane);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else if (event.getSource() == buttonSearch) {
            //labelHeader.setText(buttonSearch.getText());
            try {
                Parent centerPane = FXMLLoader.load(Utility.class.getResource("Search.fxml"));
                borderMain.setCenter(centerPane);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else{
            Utility.changeScene(event,"Login.fxml");
        }
    }
}
