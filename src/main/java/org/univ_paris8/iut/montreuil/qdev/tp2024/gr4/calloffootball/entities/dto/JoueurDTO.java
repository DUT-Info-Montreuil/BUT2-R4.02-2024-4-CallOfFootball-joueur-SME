package org.univ_paris8.iut.montreuil.qdev.tp2024.gr4.calloffootball.entities.dto;


import java.util.List;
import java.util.Objects;

public class JoueurDTO {
    String nom;
    String  pseudo;
    int     annéeNaissance;
    Enum    langues;
    List<String> centreInteret;


    public JoueurDTO(String nom, String pseudo, int annéeNaissance, Enum langues, List<String> centreInteret) {
        this.nom = nom;
        this.pseudo = pseudo;
        this.annéeNaissance = annéeNaissance;
        this.langues = langues;
        this.centreInteret = centreInteret;
    }

    public String getNom() {
        return nom;
    }

    public String getPseudo() {
        return pseudo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoueurDTO joueurDTO = (JoueurDTO) o;
        return annéeNaissance == joueurDTO.annéeNaissance && Objects.equals(nom, joueurDTO.nom) && Objects.equals(pseudo, joueurDTO.pseudo) && Objects.equals(langues, joueurDTO.langues) && Objects.equals(centreInteret, joueurDTO.centreInteret);
    }

    @Override
    public String toString() {
        return "JoueurDTO{" +
                "nom='" + nom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", annéeNaissance=" + annéeNaissance +
                ", langues=" + langues +
                ", centreInteret=" + centreInteret +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, pseudo, annéeNaissance, langues, centreInteret);
    }
}
