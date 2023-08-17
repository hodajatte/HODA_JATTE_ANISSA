package com.example.hoda_jatte_anissa.Controller;

import com.example.hoda_jatte_anissa.Entity.Demande;
import com.example.hoda_jatte_anissa.Entity.Stagiaire;
import com.example.hoda_jatte_anissa.Repository.DemandeRepository;
import com.example.hoda_jatte_anissa.Repository.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DemandeController {
    @Autowired
    private StagiaireRepository stagiaireRepository;

    @Autowired
    private DemandeRepository demandeRepository;

    @GetMapping("/demande")
    public String formulaireDemande(Model model) {
        model.addAttribute("stagiaire", new Stagiaire());
        return "DemandeStage";
    }

    @PostMapping("/demande")
    public String soumettreDemande(@ModelAttribute Stagiaire stagiaire,
                                   @RequestParam("cvFile") MultipartFile cvFile,
                                   @RequestParam("lettreMotivationFile") MultipartFile lettreMotivationFile) {
        // Enregistrer le stagiaire dans la base de données
        stagiaireRepository.save(stagiaire);

        // Enregistrer les fichiers PDF (CV et lettre de motivation) sur le serveur
        String cvFileName = "cv_" + stagiaire.getId() + ".pdf";
        String lettreMotivationFileName = "lettre_" + stagiaire.getId() + ".pdf";

        // Code pour enregistrer les fichiers sur le serveur

        // Créer la demande et l'enregistrer dans la base de données
        Demande demande = new Demande();
        demande.setStagiaire(stagiaire);
        demande.setCV(cvFileName);
        demande.setLettre_Motivation(lettreMotivationFileName);
        demande.setValidee(false);
        demandeRepository.save(demande);

        return "redirect:/confirmation";
    }

}
