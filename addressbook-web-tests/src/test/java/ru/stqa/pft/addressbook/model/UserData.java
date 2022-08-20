package ru.stqa.pft.addressbook.model;

public class UserData {
    private final String firstname;
    private final String middlename;
    private final String nickname;


    public UserData(String firstname, String middlename, String nickname) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.nickname = nickname;

    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getNickname() {
        return nickname;
    }


}
