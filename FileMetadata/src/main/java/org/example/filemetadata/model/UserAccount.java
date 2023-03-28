package org.example.filemetadata.model;

import java.sql.Date;
import java.util.Objects;
import java.util.UUID;


public class UserAccount {

    private UUID accountId;


    private String permissions;

    private Date billingDate;

    private String amount;

    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(permissions, that.permissions) && Objects.equals(billingDate, that.billingDate) && Objects.equals(amount, that.amount) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, permissions, billingDate, amount, user);
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
