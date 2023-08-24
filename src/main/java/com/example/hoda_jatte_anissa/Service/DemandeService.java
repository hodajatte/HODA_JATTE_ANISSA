package com.example.hoda_jatte_anissa.Service;

import com.example.hoda_jatte_anissa.Entity.Demande;
import java.util.List;

public interface DemandeService {
    List<Demande> getAllDemandes();
    void saveDemande(Demande demande);
    Demande getDemandeById(Long id);
    void deleteDemande(Long id);
    // Ajoutez d'autres méthodes nécessaires
}

