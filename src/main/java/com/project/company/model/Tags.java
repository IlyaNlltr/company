package com.project.company.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Entity

@Data
public class Tags {

   @Id
   @Column
   @GeneratedValue(generator = "doc-uuid")
   @GenericGenerator(name = "doc-uuid", strategy = "uuid")
   private String id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column
    private String tag;


}
