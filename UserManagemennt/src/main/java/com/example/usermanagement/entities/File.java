/**
 * Entity class from which the database table for file is created from
 *
 * @author Matej Kolesar
 * @version 1.0
 * @since 13-05-2023
 */
package com.example.usermanagement.entities;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "FILE")
public class File {

    @Id
    @Column(name = "FILE_TID")
    private String fileTID;

    private String size;
    @Column(name = "ORIGINAL_NAME")
    private String originalName;

    @Column(name = "add_info")
    private String addInfo;

    @Column(name = "name")
    private String name;

    @Column(name = "CREATION_DATE")
    private Date creationDate;


    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User owner;


    @ManyToMany(mappedBy = "sharedFiles", cascade = {CascadeType.ALL})
    private Set<User> users = new HashSet<>();


    public String getFileTID() {
        return fileTID;
    }

    public void setFileTID(String fileTID) {
        this.fileTID = fileTID;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(fileTID, file.fileTID) && Objects.equals(size, file.size) && Objects.equals(originalName, file.originalName) && Objects.equals(addInfo, file.addInfo) && Objects.equals(name, file.name) && Objects.equals(owner, file.owner) && Objects.equals(users, file.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileTID, size, originalName, addInfo, name, owner, users);
    }

    @Override
    public String toString() {
        return "File{" +
                "fileTID='" + fileTID + '\'' +
                ", size='" + size + '\'' +
                ", originalName='" + originalName + '\'' +
                ", addInfo='" + addInfo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
