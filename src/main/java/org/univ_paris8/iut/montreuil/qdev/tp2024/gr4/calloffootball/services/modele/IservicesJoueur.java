package org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.modele;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.exception.*;


import java.util.List;

public interface IservicesJoueur {
    public JoueurDTO creerProfilJoueur(String nom, String pseudo, int naissance, Langues langue, List<String> centreInteret) throws PseudoDejaExistantException, NaissanceInvalideException, LangueException, CentreInteretException;

    List<JoueurDTO> ListJoueurs() throws ListeVideException;
}
