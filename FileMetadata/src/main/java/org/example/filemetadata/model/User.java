/**
 * Entity class from which the database table for user is created from
 *
 * @author Matej Kolesar
 * @version 1.0
 * @since 13-05-2023
 */
package org.example.filemetadata.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class User {

    private UUID userId;



    private String name;


    private String email;


    private Integer age;

    private boolean isActive;

    private String permissions;

    private String phoneNumber;

    private Date dateOfBirth;


    private Set<File> files = new HashSet<>();


    private UserAccount account;

    private Set<File> sharedFiles = new HashSet<>();

    public Set<File> getSharedFiles() {
        return sharedFiles;
    }

    public void setSharedFiles(Set<File> sharedFiles) {
        this.sharedFiles = sharedFiles;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", permissions='" + permissions + '\'' +
                ", files=" + files +
                ", sharedFiles=" + sharedFiles +
                '}';
    }
}
