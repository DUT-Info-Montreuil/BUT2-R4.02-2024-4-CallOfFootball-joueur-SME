package org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.impl;


import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.modele.IservicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.exception.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceJoueur implements IservicesJoueur {
    private static ServiceJoueur uniqueInstance = null;
    private ArrayList<JoueurDTO> joueursDTO;

    private ServiceJoueur() {
        this.joueursDTO = new ArrayList<>();
    }

    public static ServiceJoueur getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ServiceJoueur();
        }
        return uniqueInstance;
    }

    @Override
    public JoueurDTO creerProfilJoueur(String nom, String pseudo, int naissance, Langues langue, List<String> centresInteret) throws PseudoDejaExistantException, NaissanceInvalideException, LangueException, CentreInteretException {
        if (joueursDTO.stream().anyMatch(joueur -> joueur.getPseudo().equals(pseudo))) {
            throw new PseudoDejaExistantException("Le pseudo choisi est déjà utilisé par un autre joueur.");
        }

        if (naissance < 1900 || naissance > LocalDate.now().getYear()) {
            throw new NaissanceInvalideException("L'année de naissance " + naissance + " est invalide.");
        }

        if (langue == null) {
            throw new LangueException("Le format de la langue est invalide.");
        }

        if (centresInteret == null || centresInteret.isEmpty()) {
            throw new CentreInteretException("La liste des centres d'intérêt ne peut pas être vide.");
        }

        JoueurDTO nouveauJoueur = new JoueurDTO(nom, pseudo, naissance, langue, centresInteret);
        joueursDTO.add(nouveauJoueur);
        return nouveauJoueur;
    }

    @Override
    public ArrayList<JoueurDTO> ListJoueurs() throws ListeVideException {
        if (joueursDTO.isEmpty()) {
            throw new ListeVideException("La liste des joueurs est vide.");
        }
        return new ArrayList<>(joueursDTO);
    }
}