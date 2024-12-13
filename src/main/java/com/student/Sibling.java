package com.student;
public class Sibling {
    private String siblingName;
    private String siblingOccupation;
    private String siblingPhoneNumber;

    public Sibling(String siblingName, String siblingOccupation, String siblingPhoneNumber) {
        this.siblingName = siblingName;
        this.siblingOccupation = siblingOccupation;
        this.siblingPhoneNumber = siblingPhoneNumber;
    }

    public String getSiblingName() {
        return siblingName;
    }

    public String getSiblingOccupation() {
        return siblingOccupation;
    }

    public String getSiblingPhoneNumber() {
        return siblingPhoneNumber;
    }
}
