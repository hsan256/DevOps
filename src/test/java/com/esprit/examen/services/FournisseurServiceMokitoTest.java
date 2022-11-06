package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Fournisseur;

import com.esprit.examen.repositories.FournisseurRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceMokitoTest {


    @Mock //declaration d'un mock
    FournisseurRepository pr;
    @InjectMocks
    FournisseurServiceImpl psi;

    Fournisseur p = Fournisseur.builder().code("abc").libelle("test").categorieFournisseur(null).detailFournisseur(null).factures(null).secteurActivites(null).build();

    @DisplayName("Retrieving Fournisseur...!")
    @Test
    public void GetFournisseurTest() {

        List<Fournisseur> lst = new ArrayList<>();
        lst.add(new Fournisseur());

        Mockito.when(pr.findAll()).thenReturn(lst);
        List<Fournisseur> exp = psi.retrieveAllFournisseurs();
        assertEquals(exp, lst);
        log.info("get ps ==> " + exp.toString());
    }

    @DisplayName("Retrieve Fournisseur by ID")
    @Test
    public void GetbyID() {

        Mockito.when(pr.findById(Mockito.anyLong())).thenReturn(Optional.of(p));
        Fournisseur reg = psi.retrieveFournisseur(3L);
        assertNotNull(reg);
        log.info("get ==> " + reg.toString());
        verify(pr).findById(Mockito.anyLong());

    }

    @DisplayName("Adding Fournisseur...!")
    @Test
    public void AddFournisseurTest() {
        Fournisseur Fournisseur = new Fournisseur();
        Fournisseur.setLibelle("test");
        Mockito.lenient().when(pr.save(Fournisseur)).thenReturn(Fournisseur);
        Fournisseur newp = psi.addFournisseur(Fournisseur);
        assertEquals(Fournisseur.getLibelle(), newp.getLibelle());
        verify(pr).save(Fournisseur);
        log.info("Added ==> " + Fournisseur.toString());
        System.out.println("added Fournisseur with Mockito");
    }
}