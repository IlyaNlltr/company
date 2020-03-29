package com.project.company.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity

@Data
public class Comp {

   @Id
   @Column
   @GeneratedValue(generator = "doc-uuid")
   @GenericGenerator(name = "doc-uuid", strategy = "uuid")
   private String id;
//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   private Long id;

    @Column
    private String name;

    @Column
    private String checkDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "staff_id")
    private List<Staff> staff;
}
