package com.example.georgihristov.colleaguedatabase;

public class Colleague {
    private String colleagueName;
    private String colleaguePicture;
    private String colleagueTitle;
    private String colleaguePhoneNumber;
    private String colleagueSkypeName;
    private String colleagueEmailAddress;

    public Colleague(String colleagueName,
                     String colleaguePicture,
                     String colleaguePosition,
                     String colleaguePhoneNumber,
                     String colleagueSkypeName,
                     String colleagueEmailAddress) {
        this.colleagueName = colleagueName;
        this.colleaguePicture = colleaguePicture;
        this.colleagueTitle = colleaguePosition;
        this.colleaguePhoneNumber = colleaguePhoneNumber;
        this.colleagueSkypeName = colleagueSkypeName;
        this.colleagueEmailAddress = colleagueEmailAddress;
    }

    public Colleague() {
    }

    public String getColleagueName() {
        return colleagueName;
    }

    public void setColleagueName(String colleagueName) {
        this.colleagueName = colleagueName;
    }

    public String getColleaguePicture() {
        return colleaguePicture;
    }

    public void setColleaguePicture(String colleaguePicture) {
        this.colleaguePicture = colleaguePicture;
    }

    public String getColleagueTitle() {
        return colleagueTitle;
    }

    public void setColleagueTitle(String colleagueTitle) {
        this.colleagueTitle = colleagueTitle;
    }

    public String getColleaguePhoneNumber() {
        return colleaguePhoneNumber;
    }

    public void setColleaguePhoneNumber(String colleaguePhoneNumber) {
        this.colleaguePhoneNumber = colleaguePhoneNumber;
    }

    public String getColleagueSkypeName() {
        return colleagueSkypeName;
    }

    public void setColleagueSkypeName(String colleagueSkypeName) {
        this.colleagueSkypeName = colleagueSkypeName;
    }

    public String getColleagueEmailAddress() {
        return colleagueEmailAddress;
    }

    public void setColleagueEmailAddress(String colleagueEmailAddress) {
        this.colleagueEmailAddress = colleagueEmailAddress;
    }
}
