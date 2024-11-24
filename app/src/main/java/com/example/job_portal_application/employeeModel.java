package com.example.job_portal_application;

public class employeeModel {
    private String editname;
    private String editphone;
    private String editcity;
    private String editcountry;

    employeeModel() {

    }

    private employeeModel(String name, String cname, String phone, String city, String country, String vacancy, String documentid) {
        this.editname = name;
        this.editphone = phone;
        this.editcity = city;
        this.editcountry = country;
    }

    String getEditname() {
        return editname;
    }

    public void setEditname(String editname) {
        this.editname = editname;
    }


    String getEditphone() {
        return editphone;
    }

    public void setEditphone(String editphone) {
        this.editphone = editphone;
    }

    String getEditcity() {
        return editcity;
    }

    public void setEditcity(String editcity) {
        this.editcity = editcity;
    }

    String getEditcountry() {
        return editcountry;
    }

    public void setEditcountry(String editcountry) {
        this.editcountry = editcountry;
    }

}
