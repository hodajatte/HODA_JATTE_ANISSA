package com.example.hoda_jatte_anissa.Controller;

import org.springframework.ui.Model;
import com.example.hoda_jatte_anissa.Entity.Demande;
import com.example.hoda_jatte_anissa.Repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Controller
public class AdminController {
    @Autowired
    private DemandeRepository demandeRepository;

    @GetMapping("/admin")
    public String listeDemandes(Model model) {
        List<Demande> demandes = demandeRepository.findAll();
        model.addAttribute("demandes", demandes);
        return "admin";
    }
}