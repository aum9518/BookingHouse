package main.entity;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Entity
@Table(name = "agencies")
@Getter
@Setter
@NoArgsConstructor(force = true)
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "agency_gen")
    @SequenceGenerator(name = "agency_gen",sequenceName = "agency_seq",allocationSize = 1)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String country;
    @Value("phone_number")
    @NotNull
    private String phoneNumber;
    @NotNull
    @Column(unique = true)
    private String email;
    @Column(length = 1000)
    @NotNull
    private String image;
    @ManyToMany(mappedBy = "agencies")
    private List<Customer>customers;
    @OneToMany (mappedBy = "agency")
    private List<House> houses;
}
