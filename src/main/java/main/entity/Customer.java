package main.entity;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.enums.Gender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor(force = true)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_gen")
    @SequenceGenerator(name = "customer_gen",sequenceName = "customer_seq",allocationSize = 1)
    private Long id;
    @NotNull
    @Value("first_name")
    private String firstName;
    @NotNull
    @Value("last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    @NotNull
    private Gender gender;
    @NotNull
    private String phoneNumber;
    @NotNull
    private LocalDate dateOfBirth;
    @ManyToMany
    private List<Agency>agencies;
    @OneToMany(mappedBy = "customerId")
    private List<Booking> booking;
}
