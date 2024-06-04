package org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.impl.ServiceJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.modele.IservicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.exception.PseudoDejaExistantException;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ServiceJoueurMockPseudoIdentiqueTest {
    private IservicesJoueur service;
    @BeforeEach
    void setUp() {
        service = ServiceJoueur.getInstance();

        //service = new ServiceJoueurMockPseudoIdentique();
    }

    @Test
    void ajouterDeuxFoisLeMemePseudo() {
        List<String> centres = new ArrayList<>();
        centres.add("Test");
        assertDoesNotThrow(() -> service.creerProfilJoueur("Premier Joueur", "pseudoTest", 2015, Langues.Anglais, centres));
        assertThrows(PseudoDejaExistantException.class, () -> service.creerProfilJoueur("Second Joueur", "pseudoTest", 1991, null, centres));
    }

    @Test
    void ajouterJoueurAvecPseudoUnique() {
        List<String> centres = new ArrayList<>();
        centres.add("Test");
        assertDoesNotThrow(() -> service.creerProfilJoueur("Silva Horeb", "uniquePseudo", 2004, Langues.Anglais, centres));
    }
}
