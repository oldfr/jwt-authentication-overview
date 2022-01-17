package com.example.authenticationoverview.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Universities")
public class UniversityDB implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String uname;
    private String address;

    public UniversityDB() {
    }

    public UniversityDB(String uname, String address) {
        this.uname = uname;
        this.address = address;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UniversityDB{" +
                "id=" + id +
                ", Uname='" + uname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
