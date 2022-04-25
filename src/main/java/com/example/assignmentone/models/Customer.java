package com.example.assignmentone.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "customer")
public class Customer {
    private String gender;
    private String fullName;
    @Id
    @GeneratedValue
    private Long customerId;
    private String customerName;
    private int phoneNumber;
    private String email;
    private String password;
    private String imageUrl;

}
