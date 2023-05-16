package com.example.usermanagement.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "ACCOUNT")
public class UserAccount {
    @Id
    @Column(name = "ACCOUND_TID")
    private UUID accountId;


    private String permissions;

    private Date billingDate;

    private String amount;

    @OneToOne(mappedBy = "account")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "accountId=" + accountId +
                ", permissions='" + permissions + '\'' +
                ", billingDate=" + billingDate +
                ", amount='" + amount + '\'' +
                '}';
    }
}
