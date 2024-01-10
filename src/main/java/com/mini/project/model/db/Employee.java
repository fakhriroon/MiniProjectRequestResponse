package com.mini.project.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "posisi")
    private String posisi;

    @Column(name = "sys_created_date")
    private Date createdDate;

    public Employee(String nama, Date dob, String posisi, Date createdDate) {
        this.id = id;
        this.nama = nama;
        this.dob = dob;
        this.posisi = posisi;
        this.createdDate = createdDate;
    }
}
