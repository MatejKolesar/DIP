/**
 * This Class is used as a default object for memory testing
 * its only purpose is to take space in memory
 *
 * @author Matej Kolesar
 * @version 1.0
 * @since 13-05-2023
 */
package com.example.usermanagement.entities;

import java.util.UUID;

public class BigObject {
    private String name;
    private String surname;
    private String city;
    private String street;
    private String descrription;
    private boolean tenured;
    private double lastEvaluation;

    public BigObject() {
        this(null, null, null, null, null, false, 0);
    }

    public BigObject(String name, String surname, String city, String street, String descrription, boolean tenured, double lastEvaluation) {
        this.name = UUID.randomUUID() + "Really long name to init this object Really long name to init this object Really long name to init this object Really long name to init this object Really long name to init this object";
        this.surname = UUID.randomUUID() + "Really long name to init this object Really long name to init t Really long name to init t Really long name to init t Really long name to init t";
        this.city = UUID.randomUUID() + "Really long name to init t Really long name to init t";
        this.street = UUID.randomUUID() + "Really long name to init t Really long name to init t Really long name to init t Really long name to init t";
        this.descrription = UUID.randomUUID() + "Really long name to init t Really long name to init t Really long name to init t Really long name to init t Really long name to init tReally long name to init t Really long name to init t";
        this.tenured = false;
        this.lastEvaluation = 123123123123.321;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescrription() {
        return descrription;
    }

    public void setDescrription(String descrription) {
        this.descrription = descrription;
    }

    public boolean isTenured() {
        return tenured;
    }

    public void setTenured(boolean tenured) {
        this.tenured = tenured;
    }

    public double getLastEvaluation() {
        return lastEvaluation;
    }

    public void setLastEvaluation(double lastEvaluation) {
        this.lastEvaluation = lastEvaluation;
    }
}
