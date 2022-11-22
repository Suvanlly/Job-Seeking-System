package com.jssgui.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.util.ResourceBundle;

public class ProfileController implements Initializable{
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
    private DashController dashController;

    UserInstance inst = UserInstance.getInstance();
    public void initialize(URL location, ResourceBundle resources){

        tfCompletion.disableProperty().bind(tfEdu.textProperty().isEmpty());

        tfFirst.setText(inst.getUser().getFirstName());
        tfLast.setText(inst.getUser().getLastName());
        tfUser.setText(inst.getUser().getUsername());
        tfPass.setText(inst.getUser().getPassword());
        tfPassConfirm.setText(inst.getUser().getPassword());
        tfEmail.setText(inst.getUser().getEmail());
        tfDob.setText(String.format("%1$tY-%1$tm-%1$td", inst.getUser().getDateOfBirth()));
        tfContact.setText(inst.getUser().getPhoneNo());
        tfAddress.setText(inst.getUser().getAddress());
        tfCity.setText(inst.getUser().getCity());
        tfState.setText(inst.getUser().getState());
        tfPost.setText(inst.getUser().getPost());
        tfCountry.setText(inst.getUser().getCountry());
        tfEdu.setText(inst.getUser().getEducation());
        tfCompletion.setText(inst.getUser().getGraduation());
        tfSkills.setText(inst.getUser().getSkills());

        /*tfCompany.setText(inst.getUser().get);
        tfCompEmail.setText(inst.getUser().get);
        tfCompNo.setText(inst.getUser().get);
        tfCompAddress.setText(inst.getUser().get);
        tfCompCity.setText(inst.getUser().get);
        tfCompState.setText(inst.getUser().get);
        tfCompPost.setText(inst.getUser().get);
        tfCompCountry.setText(inst.getUser().get);*/
    }

}
