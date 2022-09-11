package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class UserData {

    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String email;
    private String mobilePhone;
    private String workPhone;
    private String homePhone;
    private String group;
    private String allPhones;



    public int getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }
    public String getAllPhones() {
        return allPhones;
    }


    public String getHomePhone() {
        return homePhone;
    }

    public String getGroup() {
        return group;
    }

    public UserData withId(int id) {
        this.id = id;
        return this;
    }

    public UserData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserData withMobilePhone(String mobile) {
        this.mobilePhone = mobile;
        return this;
    }

    public UserData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public UserData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public UserData withGroup(String group) {
        this.group = group;
        return this;
    }
    public UserData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (id != userData.id) return false;
        if (!Objects.equals(firstname, userData.firstname)) return false;
        if (!Objects.equals(lastname, userData.lastname)) return false;
        if (!Objects.equals(mobilePhone, userData.mobilePhone))
            return false;
        if (!Objects.equals(workPhone, userData.workPhone)) return false;
        return Objects.equals(homePhone, userData.homePhone);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        return result;
    }


}
