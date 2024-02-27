package com.esprit.pidevahmed.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Returns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idR;

    private Float amount;
    private Float returnRate;
    private LocalDate dateR;

    @ManyToOne
    @JoinColumn(name = "investment_id", nullable = false)
    private Investment investment;


}