package com.example.hoda_jatte_anissa.Entity;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Entity
@Table(name = "demandes_stage")
public class DemandeStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int Durée;

    private String CV;
    private String Lettre_Motivation;

    private boolean validee;

    private  String Etat;
    private String filière;
    private String Etablissement;

    private String Niveau_Scolaire;

    @OneToOne
    @JoinColumn(name ="stagiaire_id" )
    private Stagiaire stagiaire;
}
