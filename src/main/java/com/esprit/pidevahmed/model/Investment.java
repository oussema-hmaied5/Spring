package com.esprit.pidevahmed.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// Domain Model
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInv;

    private String name;
    private String description;
    private Float value;
    @Temporal(TemporalType.DATE)
    private LocalDate dateInv;
    private Float interestRate;

    @Enumerated(EnumType.STRING)
    private StatusInvestment status;

    private String sector;
 /*   relation maa luser
    @ManyToOne
    @JoinColumn(name = "partner_id", nullable = false)
    private Partner partner;
*/
}





