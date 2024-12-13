package com.student;
public class Parent {
    private String fatherName;
    private String motherName;
    private String fatherPhoneNumber;
    private String motherPhoneNumber;

    public Parent(String fatherName, String motherName, String fatherPhoneNumber, String motherPhoneNumber) {
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.fatherPhoneNumber = fatherPhoneNumber;
        this.motherPhoneNumber = motherPhoneNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getFatherPhoneNumber() {
        return fatherPhoneNumber;
    }

    public String getMotherPhoneNumber() {
        return motherPhoneNumber;
    }
}
