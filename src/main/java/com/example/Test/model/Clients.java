package com.example.Test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "clients")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Clients {
    @Id
    private long id;

    private String firstname;
    private String lastname;
    private String email;
    private int age;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    private String city;
    private String country;

    private String password;
}
