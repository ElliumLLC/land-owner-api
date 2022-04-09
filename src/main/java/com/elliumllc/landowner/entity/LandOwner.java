package com.elliumllc.landowner.entity;


import javax.persistence.*;

@Entity
@Table(name = "land_owner")
public class LandOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String county;
    private String state;
    private int totalAcres;

    public LandOwner() {

    }

    public LandOwner(int ownerId, String firstName, String lastName, String address, String city, String county, String state, Integer totalAcres) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.county = county;
        this.state = state;
        this.totalAcres = totalAcres;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getTotalAcres() {
        return totalAcres;
    }

    public void setTotalAcres(Integer totalAcres) {
        this.totalAcres = totalAcres;
    }

    @Override
    public String toString() {
        return "LandOwner{" +
                "ownerId=" + ownerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", state='" + state + '\'' +
                ", totalAcres=" + totalAcres +
                '}';
    }
}
