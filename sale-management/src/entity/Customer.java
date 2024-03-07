package entity;

import utils.FileUtils;

public class Customer {
    private int customerId;
    private String fullName;
    private String address;
    private String phoneNumber;

    public Customer(int customerId, String fullName, String address, String phoneNumber) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String fullName, String address, String phoneNumber) {
        int lastCustomerId = FileUtils.getLastCustomerId();
        if(lastCustomerId == 0) this.customerId = 10000;
        else this.customerId = lastCustomerId+1;

        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
