package com.example.hoda_jatte_anissa.Controller;

import org.springframework.ui.Model;
import com.example.hoda_jatte_anissa.Entity.DemandeStage;
import com.example.hoda_jatte_anissa.Repository.DemandeStageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Controller
public class AdminController {
    @Autowired
    private DemandeStageRepository demandeStageRepository;

    @GetMapping("/admin/liste-demandes")
    public String afficherListeDemandes(Model model) {
        List<DemandeStage> demandes = demandeStageRepository.findAll();
        model.addAttribute("demandes", demandes);
        return "listeDemandes";
    }

    @GetMapping("/admin/details-demande/{id}")
    public String afficherDetailsDemande(@PathVariable Long id, Model model) {
        DemandeStage demande = demandeStageRepository.findById(id).orElse(null);
        model.addAttribute("demande", demande);
        return "detailsDemande";
    }

    // Autres méthodes pour accepter/refuser les demandes
}

