package com.example.hoda_jatte_anissa.Controller;

import com.example.hoda_jatte_anissa.Entity.Stagiaire;
import com.example.hoda_jatte_anissa.Repository.DemandeStageRepository;
import com.example.hoda_jatte_anissa.Repository.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StagiaireController {
    @Autowired
    StagiaireRepository stagiaireRepository;
    @Autowired
    private DemandeStageRepository demandeStageRepository;
    @GetMapping("/demande-stage")
    public String afficherFormulaireDemandeStage(Model model){
        model.addAttribute("stagiaire", new Stagiaire());
        return "demandeStageForm";
    }
    @PostMapping("/demande-stage")

        public String soumettreDemandeStage(@ModelAttribute Stagiaire stagiaire){
        return "redirect:/validation-demande";
    }
    @GetMapping("/validation-demande")
    public String afficherPageValidationDemande() {
        return "validationDemande";
    }

}
