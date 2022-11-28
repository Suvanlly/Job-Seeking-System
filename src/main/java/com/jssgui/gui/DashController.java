package com.jssgui.gui;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


    @FXML
    private ComboBox<String> comboCategory;

    @FXML
    private ComboBox<String> comboLocation;

    @FXML
    private ComboBox<String> comboSalary;

    @FXML
    private TextField searchBar;

    @FXML
    private String searchQuery;

    @FXML
    private String selectedCategory;

    @FXML
    private String selectedLocation;

    @FXML
    private String selectedSalary;



    UserInstance inst = UserInstance.getInstance();

    public DashController(){

    }


    public void initialize(URL location, ResourceBundle resources){
        labelTest.setText("Test - username: " + inst.getUser().getUsername() + " " + "typeID: " + inst.getUser().getUserTypeID()); //test
        /*comboCategory.setItems(FXCollections.observableArrayList("Software Engineer","Business Analyst","Consultant", "Web Developer", "Network Engineer", "Product Manager", "IT Support","Test operator"));
        comboLocation.setItems(FXCollections.observableArrayList("Melbourne","Sydney","Brisbane","Perth","Hobart","Remote"));
        comboSalary.setItems(FXCollections.observableArrayList("Below $50000","$50000-$70000","$70000-$90000","$90000-$120000","$120000-$150000","Above $150000"));
        */
        populateCategory();
        populateLocation();
        populateSalary();
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

            searchQuery = searchBar.getText();
            handleComboSelections();

            //testing value of combobox/search query
            System.out.println(selectedCategory);
            System.out.println(selectedLocation);
            System.out.println(selectedSalary);
            System.out.println(searchQuery);

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

    public void populateCategory() {
        //change the list to retrieve from database
        List<String> categories = Arrays.asList("category1", "category2", "category3");
        for (String category : categories) {
            comboCategory.getItems().add(category);
        }
        comboCategory.setValue("Select Category");
    }

    public void populateLocation() {
        //change the list to retrieve from database
        List<String> locations = Arrays.asList("location1", "location2", "location3");
        for (String location : locations) {
            comboLocation.getItems().add(location);
        }
        comboLocation.setValue("Select Location");
    }

    public void populateSalary() {
        //change the list to retrieve from database
        List<String> salaries = Arrays.asList("salary1", "salary2", "salary3");
        for (String salary : salaries) {
            comboSalary.getItems().add(salary);
        }
        comboSalary.setValue("Select Salary");
    }

    public void handleComboSelections() {
        comboCategory.setOnAction(actionEvent -> {
            selectedCategory = comboCategory.getSelectionModel().getSelectedItem();
        });
        comboLocation.setOnAction(actionEvent -> {
            selectedLocation = comboLocation.getSelectionModel().getSelectedItem();
        });
        comboSalary.setOnAction(actionEvent-> {
            selectedSalary = comboSalary.getSelectionModel().getSelectedItem();
        });
    }

    public String getSearchQuery() {
        return this.searchQuery;
    }

    public String getSelectedCategory() {
        return this.selectedCategory;
    }

    public String getSelectedLocation() {
        return this.selectedLocation;
    }

    public String getSelectedSalary() {
        return this.selectedSalary;
    }

}
