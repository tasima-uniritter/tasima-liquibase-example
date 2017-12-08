package br.edu.tasimaliquibaseexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="IT_STUDENT")
public class ITStudent {
    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="AGE")
    private Long age;

    @Column(name="DATE_OF_BIRTH")
    private LocalDateTime dateOfBirth;

    @Column(name="ADDRESS")
    private String address;
}
