/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author sami
 */
public class Nollaa implements Komento {
    
    TextField tuloste;
    TextField syote;
    Button nollaa;
    Button undo;
    Sovelluslogiikka sovellus;
    int arvo = 0;
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloste = tuloskentta;
        this.syote = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        this.arvo = sovellus.tulos();
        sovellus.nollaa();
            
        syote.setText("");
        tuloste.setText("" + sovellus.tulos());
        
        nollaa.disableProperty().set(true);
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        sovellus.plus(arvo);
        
        syote.setText("");
        tuloste.setText("" + sovellus.tulos());
        
        undo.disableProperty().set(true);
    }
    
}
