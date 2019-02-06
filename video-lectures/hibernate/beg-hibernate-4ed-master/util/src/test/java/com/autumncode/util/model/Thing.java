package com.autumncode.util.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Thing")
@Data
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @SequenceGenerator(name = "departments_generator", sequenceName = "seq_departments", allocationSize = 20)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departments_generator")
    private Integer id;
    @Column
    private String name;
}
