package com.project.company.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;


import javax.persistence.*;


@Entity
@Data
public class Address {
   @Id
   @Column
   @GeneratedValue(generator = "doc-uuid")
   @GenericGenerator(name = "doc-uuid", strategy = "uuid")
   private String id;
 //@Id
 //@GeneratedValue(strategy = GenerationType.IDENTITY)
 //private Long id;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String house;


}
