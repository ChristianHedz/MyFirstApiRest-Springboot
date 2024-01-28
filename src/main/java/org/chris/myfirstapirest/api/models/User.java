package org.chris.myfirstapirest.api.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String email;

}
