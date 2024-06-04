package org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.impl;

import org.junit.Before;
import org.junit.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.entities.dto.JoueurDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.impl.ServiceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.modele.IservicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.exception.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ServiceJoueurMockNaissanceTest {
    private IservicesJoueur service;

    @Before
    public void setUp() {
        service = ServiceJoueur.getInstance();

        //service = new ServiceJoueurMockNaissance();
    }

    @Test
    public void ajouterJoueurAvecAnneeValide() throws NaissanceInvalideException, CentreInteretException, PseudoDejaExistantException, LangueException {
        int anneeCourante = Year.now().getValue();
        List<String> centresInteret = new ArrayList<>();
        centresInteret.add("Football");
        JoueurDTO joueur = service.creerProfilJoueur("John Doe", "jd123", anneeCourante - 1, Langues.Anglais, centresInteret);
        assertNotNull(joueur);
    }


    @Test(expected = NaissanceInvalideException.class)
    public void ajouterJoueurAvecAnneeInvalide() throws NaissanceInvalideException, CentreInteretException, PseudoDejaExistantException, LangueException {
        int anneeCourante = Year.now().getValue() + 1;
        List<String> centresInteret = new ArrayList<>();
        centresInteret.add("Football");
        service.creerProfilJoueur("Jane Doe", "jd456", anneeCourante, Langues.Espanol, centresInteret);
    }
}
