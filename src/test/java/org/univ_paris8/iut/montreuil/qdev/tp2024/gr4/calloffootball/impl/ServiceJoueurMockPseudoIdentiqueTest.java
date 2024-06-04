package org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.services.modele.IservicesJoueur;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.enums.Langues;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.utlie.exception.PseudoDejaExistantException;


import java.util.ArrayList;
import java.util.HashSet;

public class ServiceJoueurMockPseudoIdentiqueTest {
    private IservicesJoueur service;
    @BeforeEach
    void setUp() {
        service = new ServiceJoueurMockPseudoIdentique();
    }

    @Test
    void ajouterDeuxFoisLeMemePseudo() {
        assertDoesNotThrow(() -> service.creerProfilJoueur("Premier Joueur", "pseudoTest", 2015, Langues.Anglais, new ArrayList<>()));
        assertThrows(PseudoDejaExistantException.class, () -> service.creerProfilJoueur("Second Joueur", "pseudoTest", 1991, null, new ArrayList<>()));
    }

    @Test
    void ajouterJoueurAvecPseudoUnique() {
        assertDoesNotThrow(() -> service.creerProfilJoueur("Silva Horeb", "uniquePseudo", 2004, Langues.Anglais, new ArrayList<>()));
    }
}
