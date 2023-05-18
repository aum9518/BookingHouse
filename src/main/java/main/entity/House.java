package main.entity;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.enums.HouseType;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor(force = true)
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "house_gen")
    @SequenceGenerator(name = "house_gen",sequenceName = "house_seq",allocationSize = 1)
    private Long id;
    @NotNull
    @Value("house_type")
    private HouseType houseType;
    @NotNull
    private String address;
    @NotNull
    private int price;
    @NotNull
    private int room;
    @NotNull
    private String country;
    @NotNull
    private String description;
    @NotNull
    private boolean isBooked;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST})
    private Agency agency;
    @OneToOne(mappedBy = "houseId",cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST})
    private Booking booking;
}
