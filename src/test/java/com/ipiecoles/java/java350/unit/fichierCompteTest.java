package com.ipiecoles.java.java350.unit;

import com.ipiecoles.java.java350.FichierCompte;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import static org.mockito.Mockito.mock;

/**
 * Created by JDS on 06/11/2017.
 */
public class fichierCompteTest {

    @Test
    public void ouvrirTest() throws Exception {
        //Given
        FileInputStream fileStream=mock(FileInputStream.class);
        ObjectInputStream objectStream=mock(ObjectInputStream.class);
        PowerMockito.whenNew(FileInputStream.class).withAnyArguments().thenReturn(fileStream);
        PowerMockito.whenNew(ObjectInputStream.class).withAnyArguments().thenReturn(objectStream);
        FichierCompte fichierCompte = new FichierCompte();

        //When
        boolean ouvert=fichierCompte.ouvrir("R");
        //Then
        Assertions.assertThat(ouvert).isTrue();
        assertsOuvrirTestRL("R",fichierCompte);
        assertsOuvrirTestRL("L",fichierCompte);
        assertsOuvrirTestWE("E",fichierCompte);
        assertsOuvrirTestWE("W",fichierCompte);

    }

    public void assertsOuvrirTestRL(String s, FichierCompte fichierCompte) {
        Assertions.assertThat(fichierCompte.getfRo()).isNotNull();
        Assertions.assertThat(fichierCompte.getfWo()).isNull();
        Assertions.assertThat(fichierCompte.getMode()).isEqualTo(s);
        Assertions.assertThat(fichierCompte.ouvrir(s)).isEqualTo(true);

    }

    public void assertsOuvrirTestWE(String s, FichierCompte fichierCompte) {
        Assertions.assertThat(fichierCompte.getfRo()).isNull();
        Assertions.assertThat(fichierCompte.getfWo()).isNotNull();
        Assertions.assertThat(fichierCompte.getMode()).isEqualTo(s);
        Assertions.assertThat(fichierCompte.ouvrir(s)).isEqualTo(true);
    }

    @Test
    public void fermerTest() {

    }

}
