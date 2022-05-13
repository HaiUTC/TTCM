package com.example.thuctap.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "checkout")
public class CheckoutEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;
    @Column(name = "order_id")
    private Long order;
}
