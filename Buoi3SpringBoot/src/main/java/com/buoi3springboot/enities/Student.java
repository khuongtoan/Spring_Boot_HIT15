package com.buoi3springboot.enities;

import jakarta.persistence.*;
import lombok.* ;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name ="full_name", nullable = false, length = 100 )
    private String name;

    @Column(name ="email", length = 150, unique = true )
    private String email;

    @Column(name ="phone_number", length = 15 )
    private String phone;

    @Column(name ="home_address",columnDefinition = "TEXT" )
    private String  address;

}
