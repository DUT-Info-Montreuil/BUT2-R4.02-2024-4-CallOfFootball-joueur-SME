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
    public JoueurDTO creerProfilJoueur(String nom, String pseudo, int annéeNaissance, Langues langue, List<String> centreInteret) throws NaissanceInvalideException {
        if (annéeNaissance < 1900 || annéeNaissance > java.time.Year.now().getValue()) {
            throw new NaissanceInvalideException("L'année de naissance " + annéeNaissance + " est invalide.");
        }

        return new JoueurDTO(nom, pseudo, annéeNaissance, langue, centreInteret);
    }

    @Override
    public ArrayList<JoueurDTO> obtenirListeJoueurs() throws ListeVideException {
        return null;
    }
}
