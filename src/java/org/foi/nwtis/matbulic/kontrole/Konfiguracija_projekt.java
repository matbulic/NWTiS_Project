/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.matbulic.kontrole;
import org.foi.nwtis.matbulic.konfiguracije.Konfiguracija;
import org.foi.nwtis.matbulic.konfiguracije.KonfiguracijaApstraktna;
import org.foi.nwtis.matbulic.konfiguracije.NemaKonfiguracije;
import org.foi.nwtis.matbulic.konfiguracije.bp.BP_Konfiguracija;

/**
 * Klasa koja se bavi učitavanjem i pružanjem konfiguracijskih podataka servera
 * @author Bule
 */
public class Konfiguracija_projekt{ 
    //adresa mail poslužitelja

    private BP_Konfiguracija bp_konfig;
    private int interval;
    private int port;
    private Konfiguracija konfig;
    private String cKey;
    private String sKey;
    private String lozinka = "";
    private String kljucnaRijec;
    private String poslanePoruke;
    private String primateljEmailPoruke;
    private String adresaPosluzitelja = "";
    private String emailPort = "";
    private String korisnickoIme = "";

    /**
     * Konstruktor konfiguracijske klase
     *
     * @param datoteka Lokacija datoteke konfiguracije
     */
    public Konfiguracija_projekt(String datoteka) throws NemaKonfiguracije {
        //ucitaj konfiguraciju baze podataka
        bp_konfig = new BP_Konfiguracija(datoteka);
        //ucitaj ostale parametre web servera

        konfig = KonfiguracijaApstraktna.preuzmiKonfiguraciju(datoteka);
        this.interval = Integer.valueOf(konfig.dajPostavku("interval"));
        this.port = Integer.valueOf(konfig.dajPostavku("port"));
        this.cKey = konfig.dajPostavku("cKey");
        this.sKey = konfig.dajPostavku("sKey");
                
        this.adresaPosluzitelja = konfig.dajPostavku("adresaPosluzitelja");
        this.emailPort = konfig.dajPostavku("emailPort");
        this.korisnickoIme = konfig.dajPostavku("korisnickoIme");
        this.lozinka = konfig.dajPostavku("lozinka");
        this.poslanePoruke = konfig.dajPostavku("poslanePoruke");
        this.kljucnaRijec = konfig.dajPostavku("trazeniPredmet");
        this.primateljEmailPoruke=konfig.dajPostavku("primateljEmailPoruke");
    }


    public Konfiguracija getConfig() {
        return konfig;
    }

    public BP_Konfiguracija getBpKonfiguracija() {
        return bp_konfig;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAdresaPosluzitelja() {
        return adresaPosluzitelja;
    }

    public void setAdresaPosluzitelja(String adresaPosluzitelja) {
        this.adresaPosluzitelja = adresaPosluzitelja;
    }

    public String getEmailPort() {
        return emailPort;
    }

    public void setEmailPort(String emailPort) {
        this.emailPort = emailPort;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinkaKorisnika() {
        return lozinka;
    }

    public void setLozinkaKorisnika(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getDirPoslanePoruke() {
        return poslanePoruke;
    }

    public void setDirPoslanePoruke(String poslanePoruke) {
        this.poslanePoruke = poslanePoruke;
    }

    public String getPrimateljEmailPoruke() {
        return primateljEmailPoruke;
    }

    public void setPrimateljEmailPoruke(String primateljEmailPoruke) {
        this.primateljEmailPoruke = primateljEmailPoruke;
    }

    public String getTrazeniPredmet() {
        return kljucnaRijec;
    }

    public void setTrazeniPredmet(String kljucnaRijec) {
        this.kljucnaRijec = kljucnaRijec;
    }

    public String getcKey() {
        return cKey;
    }

    public void setcKey(String cKey) {
        this.cKey = cKey;
    }

    public String getsKey() {
        return sKey;
    }

    public void setsKey(String sKey) {
        this.sKey = sKey;
    }
    
    
    
}
