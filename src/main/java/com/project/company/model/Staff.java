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
public class Staff implements Serializable {

    @Id
    @Column
    @GeneratedValue(generator = "doc-uuid")
    @GenericGenerator(name = "doc-uuid", strategy = "uuid")
    private String id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String patronymic;

    @Column
    private String position;

    @Column
    @Enumerated(EnumType.STRING)
    private GenderENUM gender;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "share_id")
    private Share share;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    //@ManyToMany
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "tags_id")
    private List<Tags> tags;
}
