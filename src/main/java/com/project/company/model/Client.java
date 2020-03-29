package com.project.company.model;

import com.project.company.EnumS.GroupsENUM;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Client implements Serializable {

   @Id
   @Column
   @GeneratedValue(generator = "doc-uuid")
   @GenericGenerator(name = "doc-uuid", strategy = "uuid")
   private String id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private GroupsENUM groups;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "listS_id")
    private List<Comp> listS;
}
