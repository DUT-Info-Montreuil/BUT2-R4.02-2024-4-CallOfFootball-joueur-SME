package org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.modele.IservicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.exception.ListeVideException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.exception.NaissanceInvalideException;

import java.util.ArrayList;
import java.util.List;

public class ServiceJoueurMockNaissance implements IservicesJoueur {


    @Override
    public JoueurDTO creerProfilJoueur(String nom, String pseudo, int naissance, Langues langue, List<String> centreInteret) throws NaissanceInvalideException {
        if (naissance < 1900 || naissance > java.time.Year.now().getValue()) {
            throw new NaissanceInvalideException("L'année de naissance " + naissance + " est invalide.");
        }

        return new JoueurDTO(nom, pseudo, naissance, langue, centreInteret);
    }

    @Override
    public ArrayList<JoueurDTO> ListJoueurs() throws ListeVideException {
        return null;
    }
}
