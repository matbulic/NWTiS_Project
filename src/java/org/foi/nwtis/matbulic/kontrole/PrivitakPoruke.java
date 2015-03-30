/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.matbulic.kontrole;

/**
 * Struktura privitka poruke
 * @author Bule
 */
public class PrivitakPoruke {

    private int broj;
    private String vrsta;
    private int velicina;
    private String datoteka;

    public PrivitakPoruke(int broj, String vrsta, int velicina, String datoteka) {
        this.broj = broj;
        this.vrsta = vrsta;
        this.velicina = velicina;
        this.datoteka = datoteka;
    }

    public int getBroj() {
        return broj;
    }

    public String getDatoteka() {
        return datoteka;
    }

    public int getVelicina() {
        return velicina;
    }

    public String getVrsta() {
        return vrsta;
    }

}
