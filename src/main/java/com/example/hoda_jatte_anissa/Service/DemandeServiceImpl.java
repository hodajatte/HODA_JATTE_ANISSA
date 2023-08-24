package com.example.hoda_jatte_anissa.Service;

import com.example.hoda_jatte_anissa.Entity.Demande;
import com.example.hoda_jatte_anissa.Repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DemandeServiceImpl implements DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    @Override
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    @Override
    public void saveDemande(Demande demande) {
        demandeRepository.save(demande);
    }

    @Override
    public Demande getDemandeById(Long id) {
        return demandeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDemande(Long id) {
        demandeRepository.deleteById(id);
    }
}
