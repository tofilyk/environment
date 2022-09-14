package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class UserData {

    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String email2;
    private String email3;
    private String mobilePhone;
    private String workPhone;
    private String homePhone;
    private String phone2;
    private String group;

    private String allPhones;
    private String allEmails;

    public String getAllEmails() {
        return allEmails;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }
    public String getPhone2() { return phone2; }


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
    public UserData withAddress(String address) {
        this.address = address;
        return this;
    }

    public UserData withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserData withEmail2(String email2) {
        this.email2 = email2;
        return this;

    }

    public UserData withEmail3(String email3) {
        this.email3 = email3;
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
    public UserData withPhone2(String phone2) {
        this.phone2 = phone2;
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

    public UserData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }


    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (id != userData.id) return false;
        if (!Objects.equals(firstname, userData.firstname)) return false;
        if (!Objects.equals(lastname, userData.lastname)) return false;
        if (!Objects.equals(email, userData.email)) return false;
        if (!Objects.equals(mobilePhone, userData.mobilePhone))
            return false;
        return Objects.equals(address, userData.address);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

}
