package ru.stqa.pft.addressbook.model;

public class UserData {
    private final String firstname;
    private final String middlename;

    private final String company;
    private final String mobile;

    private String group;


    public UserData(String firstname, String middlename, String company, String mobile, String group) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.company = company;
        this.mobile = mobile;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }


    public String getCompany() {
        return company;
    }

    public String getMobile() {
        return mobile;
    }


    public String getGroup() {
        return group;
    }
}
