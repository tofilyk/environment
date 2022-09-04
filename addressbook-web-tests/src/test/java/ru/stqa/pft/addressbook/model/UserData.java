package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class UserData {

    private int id;

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (!Objects.equals(firstname, userData.firstname)) return false;
        return Objects.equals(lastname, userData.lastname);
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    private final String firstname;
    private final String lastname;
    private final String company;
    private final String mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String group;

    public UserData(int id, String firstname, String lastname, String company, String mobile, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.mobile = mobile;
        this.group = group;
    }


    public UserData(String firstname, String lastname, String company, String mobile, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.mobile = mobile;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
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
