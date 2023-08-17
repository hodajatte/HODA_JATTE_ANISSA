package com.example.hoda_jatte_anissa.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stagiaires")
public class Stagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nom;
    private String Prénom;
    private String Tel;
    private String email;

    private String Genre;
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date DateNaissance;

    @OneToOne(mappedBy = "stagiaire")

    private Demande demandeStage;


}
