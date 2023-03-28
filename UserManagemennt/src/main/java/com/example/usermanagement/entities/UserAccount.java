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


}
