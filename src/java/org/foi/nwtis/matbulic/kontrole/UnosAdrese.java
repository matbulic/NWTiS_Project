/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.matbulic.kontrole;

import org.foi.nwtis.matbulic.helperi.HelperZaBazu;
import org.foi.nwtis.matbulic.kontrole.Konfiguracija_projekt;
import org.foi.nwtis.matbulic.rest.klijenti.GoogleMapsKlijent;
import org.foi.nwtis.matbulic.web.podaci.Location;

/**
 * Zrno za dodavanje nove adrese u bazu podataka
 * @author Bule
 */
public class UnosAdrese {
    
    /**
     * Metoda koja dodaje novu adresu i njene geolokacijske info u bazu
     * @param adresa naziv adrese
     * @param config konfiguracije za spajanje
     */
    public void dodaj(String adresa, Konfiguracija_projekt config) {
        GoogleMapsKlijent gmk = new GoogleMapsKlijent();
        Location loc = gmk.getGeoLocation(adresa);
        
        if (loc != null) {
            HelperZaBazu hzb = new HelperZaBazu(config);
            hzb.dodajAdresu(adresa, Double.valueOf(loc.getLatitude()), Double.valueOf(loc.getLongitude()));         
        }
    }
}
