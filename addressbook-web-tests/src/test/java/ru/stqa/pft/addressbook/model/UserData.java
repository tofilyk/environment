package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class UserData {

    private int id;
    private final String firstname;
    private final String middlename;

    private final String company;
    private final String mobile;

    private String group;

    public UserData(int id,String firstname, String middlename, String company, String mobile, String group) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.company = company;
        this.mobile = mobile;
        this.group = group;
    }


    public UserData(String firstname, String middlename, String company, String mobile, String group) {
        this.id = Integer.MAX_VALUE;
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


    @Override
    public String toString() {
        return "UserData{" +
                "firstname='" + firstname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        return Objects.equals(firstname, userData.firstname);
    }

    @Override
    public int hashCode() {
        return firstname != null ? firstname.hashCode() : 0;
    }
}
