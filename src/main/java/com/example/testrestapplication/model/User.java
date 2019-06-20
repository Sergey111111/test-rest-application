package com.example.testrestapplication.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "usr")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
