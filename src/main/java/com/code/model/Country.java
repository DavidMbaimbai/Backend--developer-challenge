package com.code.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name= "name")
    private String name;
    @Column(name = "capital")
    private String capital;
    @Column(name = "region")
    private String region;
    @Column(name = "sub_region")
    private String subRegion;
    @Column(name = "area")
    private String area;
}
