package com.jssgui.gui;

import java.util.ArrayList;
import java.util.Date;

/**
 * Initial constructor for job class
 */
public class Job {
    private String jobTitle;

    private String id;

    private String description;

    private String companyName;

    private String location;

    private String jobCategory;

    private int salary;

    private int numberOfApplications;

    private Date expiryDate;

    private Date createDate;

    private boolean isAdvertised;


    public String getJobTitle() {
        return this.jobTitle;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public String getLocation() {
        return this.location;
    }

    public String getJobCategory() {
        return this.jobCategory;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getNumberOfApplications() {
        return this.numberOfApplications;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public Boolean getIsAdvertised() {
        return this.isAdvertised;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setNumberOfApplications(int numberOfApplications) {
        this.numberOfApplications = numberOfApplications;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setAdvertised(Boolean isAdvertised) {
        this.isAdvertised = isAdvertised;
    }

}
