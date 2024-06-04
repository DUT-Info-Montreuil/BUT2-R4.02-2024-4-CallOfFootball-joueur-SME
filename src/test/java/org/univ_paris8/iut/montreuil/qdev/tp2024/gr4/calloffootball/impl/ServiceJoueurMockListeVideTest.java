package org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.impl;

import org.junit.Before;
import org.junit.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.impl.ServiceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.modele.IservicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.exception.*;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.enums.Langues;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ServiceJoueurMockListeVideTest {
    private IservicesJoueur service;

    @Before
    public void setUp() {
        service = ServiceJoueur.getInstance();

        //  service = new ServiceJoueurMockListeVide();
    }

    @Test
    public void testAjouterEtObtenirJoueur() throws ListeVideException, CentreInteretException, PseudoDejaExistantException, NaissanceInvalideException, LangueException {
        List<String> centresInteret = new ArrayList<>();
        centresInteret.add("Gaming");
        JoueurDTO joueurAjoute = new JoueurDTO("Horeb","hbs",2004,Langues.Portugais,centresInteret);
        JoueurDTO joueurObtenu = service.creerProfilJoueur("Horeb", "hbs", 2004, Langues.Portugais, centresInteret);

        assertEquals(joueurAjoute, joueurObtenu);
    }
}
