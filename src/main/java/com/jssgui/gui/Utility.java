package com.jssgui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

//Need to refactor

public class Utility {

    public static void changeScene(ActionEvent event, String fxml) {
        try {
            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent pane = FXMLLoader.load(Utility.class.getResource(fxml));
            stg.getScene().setRoot(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        UserInstance inst = UserInstance.getInstance();

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/monjs", "root", "kali");
            preparedStatement = connection.prepareStatement("SELECT user_id, user_type_id, username, password, fname, lname, email, dob, contactno, address, city, state, post, country, education, graduation, skills, company, compemail, compno, compaddress, compcity, compstate, comppost, compcountry  FROM user WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery(); //resultSet = selected columns

            if (!resultSet.isBeforeFirst()){ //empty
                System.out.println("event = " + event + ", username = " + username + ", password = " + password);  //Add invalid credentials back in
            }
            else{
                while(resultSet.next()){
                    int userID = resultSet.getInt("user_id");
                    int typeID = resultSet.getInt("user_type_id");
                    //String user = resultSet.getString("username");
                    String dbPassword = resultSet.getString("password");
                    String fname = resultSet.getString("fname");
                    String lname = resultSet.getString("lname");
                    String email = resultSet.getString("email");
                    Date dob = Date.valueOf(resultSet.getString("dob"));
                    String contactno = resultSet.getString("contactno");
                    String address = resultSet.getString("address");
                    String city = resultSet.getString("city");
                    String state = resultSet.getString("state");
                    String post = resultSet.getString("post");
                    String country = resultSet.getString("country");
                    String education = resultSet.getString("education");
                    String graduation = resultSet.getString("graduation");
                    String skills = resultSet.getString("skills");
                    /*if (typeID == 2){
                        String company = resultSet.getString("company");
                        String compemail = resultSet.getString("compemail");
                        String compno = resultSet.getString("compno");
                        String compaddress = resultSet.getString("compaddress");
                        String compcity = resultSet.getString("compcity");
                        String compstate = resultSet.getString("compstate");
                        String comppost = resultSet.getString("comppost");
                        String compcountry = resultSet.getString("compcountry");
                    }*/



                    if (dbPassword.equals(password)){
                        User u = inst.getUser();

                        u.setUserID(userID);
                        u.setUserTypeID(typeID);
                        u.setUsername(username);
                        u.setPassword(dbPassword);
                        u.setFirstName(fname);
                        u.setLastName(lname);
                        u.setEmail(email);
                        u.setDateOfBirth(dob);
                        u.setPhoneNo(contactno);
                        u.setAddress(address);
                        u.setCity(city);
                        u.setState(state);
                        u.setPost(post);
                        u.setCountry(country);
                        u.setEducation(education);
                        u.setGraduation(graduation);
                        u.setSkills(skills);

                        //set address + company details

                        if (typeID == 1){
                            Utility.changeScene(event,"DashJS.fxml");
                        }
                        if (typeID == 2) {
                            Utility.changeScene(event, "DashR.fxml");
                        }
                    }
                    else{
                        System.out.println("event = " + event + ", username = " + username + ", password = " + password); //Add invalid credentials back in
                    }
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if (resultSet != null){
                try{
                    resultSet.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try{
                    preparedStatement.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try{
                    connection.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void signUp(ActionEvent event, String fxml, int typeID, String username, String password, String fname, String lname, String email, Date dob, String contactno, String address, String city, String state, String post, String country, String education, String graduation, String skills, String company, String compemail, String compno, String compaddress, String compcity, String compstate, String comppost, String compcountry) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement psInsert = null;
        PreparedStatement psUserCheck = null;
        ResultSet resultSet = null;

        UserInstance inst = UserInstance.getInstance();

        try {
            psUserCheck = connection.prepareStatement("SELECT * FROM user WHERE username = ?");
            psUserCheck.setString(1, username);
            resultSet = psUserCheck.executeQuery();

            if (resultSet.isBeforeFirst()){
                //user exists prompt
            }
            else{
                psInsert = connection.prepareStatement("INSERT INTO user (username, password, fname, lname, email, dob, contactno, address, city, state, post, country, education, graduation, skills, user_type_id, company, compemail, compno, compaddress, compcity, compstate, comppost, compcountry) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                psInsert.setString(1, username);
                psInsert.setString(2, password);
                psInsert.setString(3, fname);
                psInsert.setString(4, lname);
                psInsert.setString(5, email);
                psInsert.setDate(6, dob);
                psInsert.setString(7, contactno);
                psInsert.setString(8, address);
                psInsert.setString(9, city);
                psInsert.setString(10, state);
                psInsert.setString(11, post);
                psInsert.setString(12, country);
                if (!education.isEmpty())
                    psInsert.setString(13, education);
                else
                    psInsert.setNull(13, Types.VARCHAR);
                if (!graduation.isEmpty())
                    psInsert.setString(14, graduation);
                else
                    psInsert.setNull(14, Types.VARCHAR);
                if (!skills.isEmpty())
                    psInsert.setString(15, skills);
                else
                    psInsert.setNull(15, Types.VARCHAR);
                psInsert.setInt(16, typeID);
                psInsert.setString(17, company);
                psInsert.setString(18, compemail);
                psInsert.setString(19, compno);
                psInsert.setString(20, compaddress);
                psInsert.setString(21, compcity);
                psInsert.setString(22, compstate);
                psInsert.setString(23, comppost);
                psInsert.setString(24, compcountry);

                psInsert.executeUpdate();

                User u = inst.getUser();

                //u.setUserID(userID);
                u.setUserTypeID(typeID);
                u.setUsername(username);
                u.setPassword(password);
                u.setFirstName(fname);
                u.setLastName(lname);
                u.setEmail(email);
                u.setDateOfBirth(dob);
                u.setPhoneNo(contactno);
                u.setAddress(address);
                u.setCity(city);
                u.setState(state);
                u.setPost(post);
                u.setCountry(country);
                u.setEducation(education);
                u.setGraduation(graduation);
                u.setSkills(skills);

                //set address + company details

                Utility.changeScene(event, fxml);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(resultSet != null){
                try{
                    resultSet.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if (psUserCheck != null){
                try{
                    psUserCheck.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (psInsert != null){
                try{
                    psInsert.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try{
                    connection.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
