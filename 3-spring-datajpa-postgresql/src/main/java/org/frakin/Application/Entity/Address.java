package org.frakin.Application.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Address {

    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(length = 500, name = "address")
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "person_address_id")
    private Person person;


    public enum AddressType{
        HOME,
        WORK,
        OTHER
    }
}
