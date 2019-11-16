package com.mmt.lib.models;

import java.util.Date;

public class Book {
    String name;
    Integer id;
    Boolean isReserved;
    Boolean isIssued;
    Date issuedOn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }

    public Boolean getIssued() {
        return isIssued;
    }

    public void setIssued(Boolean issued) {
        isIssued = issued;
    }

    public Date getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(Date issuedOn) {
        this.issuedOn = issuedOn;
    }

    public Book(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.isReserved = false;
        this.isIssued = false;
        this.issuedOn = null;
    }
}