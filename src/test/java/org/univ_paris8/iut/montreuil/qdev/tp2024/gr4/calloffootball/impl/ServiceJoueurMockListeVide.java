package org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.modele.IservicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.exception.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ServiceJoueurMockListeVide implements IservicesJoueur {
    private ArrayList<JoueurDTO> joueursDTO = new ArrayList<>();

    @Override
    public JoueurDTO creerProfilJoueur(String nom, String pseudo, int naissance, Langues langue, List<String> centreInteret) {
        JoueurDTO joueur = new JoueurDTO(nom, pseudo, naissance, langue, centreInteret);
        joueursDTO.add(joueur);
        return joueur;
    }

    @Override
    public ArrayList<JoueurDTO> ListJoueurs() throws ListeVideException {
        if (joueursDTO.isEmpty()) {
            throw new ListeVideException("La liste des joueurs est vide.");
        }
        return joueursDTO;
    }
}
