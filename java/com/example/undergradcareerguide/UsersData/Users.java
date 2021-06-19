package com.example.undergradcareerguide.UsersData;


public class Users {


    String ProfilePic;
    String UserName;
    String userid =null;
    String FirstName,LastName, Email, Pass, ConfirmPass,Gender =null;

    public Users(String profilePic, String userName, String userid, String email, String pass) {
        ProfilePic = profilePic;
        UserName = userName;
        Email = email;
        Pass = pass;
        this.userid = userid;
    }



    public Users(String firstName, String lastName, String email, String pass, String confirmPass, String gender) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Pass = pass;
        ConfirmPass = confirmPass;
        Gender = gender;
    }

    public Users()
    {

    }

    public String getProfilePic() {
        return ProfilePic;
    }

    public void setProfilePic(String profilePic) {
        ProfilePic = profilePic;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getConfirmPass() {
        return ConfirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        ConfirmPass = confirmPass;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}