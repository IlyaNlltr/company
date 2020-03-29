package com.project.company.model;

import com.project.company.EnumS.GenderENUM;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity

@Data
public class Share {

   @Id
   @Column
   @GeneratedValue(generator = "doc-uuid")
   @GenericGenerator(name = "doc-uuid", strategy = "uuid")
   private String id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String facebook;

    @Column
    private String instagram;


}
