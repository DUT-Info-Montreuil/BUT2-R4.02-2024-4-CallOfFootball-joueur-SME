package org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.modele.IservicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.exception.ListeVideException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.exception.PseudoDejaExistantException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServiceJoueurMockPseudoIdentique implements IservicesJoueur {

    private List<String> pseudosUtilises = new ArrayList<>();

    @Override
    public JoueurDTO creerProfilJoueur(String nom, String pseudo, int anneeNaissance, Langues langue, List<String> centreInteret) throws PseudoDejaExistantException {
        if (pseudosUtilises.contains(pseudo)) {
            throw new PseudoDejaExistantException("Le pseudo choisi est déjà utilisé par un autre joueur.");
        }
        pseudosUtilises.add(pseudo);
        return new JoueurDTO(nom, pseudo, anneeNaissance, langue, centreInteret);
    }

    @Override
    public List<JoueurDTO> obtenirListeJoueurs() throws ListeVideException {
        return null;
    }

}