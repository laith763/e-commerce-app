package com.example.assignmentone.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="order")
public class Order {
    private String orderName;
    @Id
    @GeneratedValue
    private Long orderId;
    private String orderDescription;
}
