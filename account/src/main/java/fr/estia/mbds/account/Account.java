package fr.estia.mbds.account;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    private String id;
    private Double balance;
    @CreationTimestamp
    private LocalDate dateCreated;
    @Enumerated(EnumType.STRING)  // stocker dans la base de donné la valeur en string de l'enum
    private CurrencyType currencyType;
    @Transient   // non stocké dans la base de donné
    private Customer customer;
    private Long customerId;
}