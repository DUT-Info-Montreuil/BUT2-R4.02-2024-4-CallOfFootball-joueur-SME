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
    public JoueurDTO ajouterJoueur(String nom, String pseudo, int anneeNaissance, Langues langue, List<String> centresInteret) throws PseudoDejaExistantException, NaissanceInvalideException, LangueException, CentreInteretException {
        if (joueursDTO.stream().anyMatch(joueur -> joueur.getPseudo().equals(pseudo))) {
            throw new PseudoDejaExistantException("Le pseudo choisi est déjà utilisé par un autre joueur.");
        }

        if (anneeNaissance < 1900 || anneeNaissance > LocalDate.now().getYear()) {
            throw new NaissanceInvalideException("L'année de naissance " + anneeNaissance + " est invalide.");
        }

        if (langue == null) {
            throw new LangueException("Le format de la langue est invalide.");
        }

        if (centresInteret == null || centresInteret.isEmpty()) {
            throw new CentreInteretException("La liste des centres d'intérêt ne peut pas être vide.");
        }

        JoueurDTO nouveauJoueur = new JoueurDTO(nom, pseudo, anneeNaissance, langue, centresInteret);
        joueursDTO.add(nouveauJoueur);
        return nouveauJoueur;
    }

    @Override
    public ArrayList<JoueurDTO> obtenirListeJoueurs() throws ListeVideException {
        if (joueursDTO.isEmpty()) {
            throw new ListeVideException("La liste des joueurs est vide.");
        }
        return new ArrayList<>(joueursDTO);
    }
}