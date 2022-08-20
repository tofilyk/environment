package model;

public class UserData {
    private final String firstname;
    private final String middlename;
    private final String nickname;
    private final String company;
    private final String mobile;

    public UserData(String firstname, String middlename, String nickname, String company, String mobile) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.nickname = nickname;
        this.company = company;
        this.mobile = mobile;
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

    public String getCompany() {
        return company;
    }

    public String getMobile() {
        return mobile;
    }
}
