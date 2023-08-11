package com.example.hoda_jatte_anissa.Entity;

import jakarta.persistence.*;

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

    @OneToOne(mappedBy = "stagiaire")

    private DemandeStage demandeStage;


}
