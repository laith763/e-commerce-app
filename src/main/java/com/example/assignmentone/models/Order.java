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
@Table(name = "orders")
public class Order {
    private String orderName;
    @Id
    @GeneratedValue
    private Long orderId;
    private String orderDescription;
}
