/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.matbulic.helperi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.foi.nwtis.matbulic.kontrole.Konfiguracija_projekt;
import org.foi.nwtis.matbulic.rest.klijenti.GoogleMapsKlijent;
import org.foi.nwtis.matbulic.web.podaci.Location;

/**
 * Klasa za pomoćne fukncije unutar aplikacije , provjera korisnika unutar baze,
 * slanje email poruke
 *
 * @author Bule
 */
public class HelperZaZahtjeve {

    public String provjeraNadimkaKorisnika(Konfiguracija_projekt config, String korisnik_ime) {
        String nazivBaze = config.getBpKonfiguracija().getUser_database();
        String host = config.getBpKonfiguracija().getServer_database();
        if (korisnik_ime == null || korisnik_ime.length() == 0) {
            return "ERROR";
        }

        String url = host + nazivBaze;
        String sql = "SELECT matbulic_korisnik_uloge.uloga, ime, prezime, matbulic_korisnik.korIme FROM "
                + "matbulic_korisnik INNER JOIN matbulic_korisnik_uloge ON matbulic_korisnik.korIme = "
                + "matbulic_korisnik_uloge.korIme WHERE matbulic_korisnik.korIme = '" + korisnik_ime + "' ";
        try {
            Class.forName(config.getBpKonfiguracija().getDriver_database());
        } catch (Exception ex) {
            System.out.println("Driver baze ne postoji ili greška prilikom učitavanja !");
            System.out.println(ex.toString());
            return "ERROR";
        }

        try (
                Connection con = DriverManager.getConnection(url, config.getBpKonfiguracija().getUser_username(), config.getBpKonfiguracija().getUser_password());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);) {

            if (!rs.next()) {
                System.out.println("Ovo korisničko ime ne postoji u bazi ");
                return "ERROR";
            }
            return "OK";
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return "ERROR";
        }
    }

    public String provjeraAdmina(Konfiguracija_projekt config, String korIme, String korLozinka) {
        String nazivBaze = config.getBpKonfiguracija().getUser_database();
        String host = config.getBpKonfiguracija().getServer_database();
        if (korIme == null || korIme.length() == 0 || korLozinka == null || korLozinka.length() == 0) {
            return "ERROR";
        }

        String url = host + nazivBaze;
        String sql = "SELECT matbulic_korisnik_uloge.uloga, ime, prezime, matbulic_korisnik.korIme "
                + "FROM matbulic_korisnik INNER JOIN matbulic_korisnik_uloge ON matbulic_korisnik.korIme = "
                + "matbulic_korisnik_uloge.korIme WHERE matbulic_korisnik.korIme = '" + korIme + "'"
                + " AND matbulic_korisnik.lozinka = '" + korLozinka + "' ";
        try {
            Class.forName(config.getBpKonfiguracija().getDriver_database());
        } catch (Exception ex) {
            System.out.println("Driver baze ne postoji ili greška prilikom učitavanja !");
            System.out.println(ex.toString());
            return "ERROR";
        }

        try (
                Connection con = DriverManager.getConnection(url, config.getBpKonfiguracija().getUser_username(), config.getBpKonfiguracija().getUser_password());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);) {

            if (!rs.next()) {
                System.out.println("Ovo korisničko ime ne postoji u bazi ");
                return "ERROR";
            }
            return "OK";
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return "ERROR";
        }
    }

    public String getMeteoPodatkeZaAdresu(Konfiguracija_projekt config, String adresa) {
        DecimalFormat tempVlaga = new DecimalFormat("#0.00");
        DecimalFormat tlak = new DecimalFormat("###0.00");
        DecimalFormat geo = new DecimalFormat("##0.000000");

        String nazivBaze = config.getBpKonfiguracija().getUser_database();
        String host = config.getBpKonfiguracija().getServer_database();
        String url = host + nazivBaze;
        String odgovor = "ERR 52";
        String sql = "SELECT matbulic_meteo.*, latitude, longitude FROM matbulic_meteo "
                + "INNER JOIN matbulic_adrese ON matbulic_meteo.idAdresa ="
                + " matbulic_adrese.idAdresa AND matbulic_adrese.adresa = '" + adresa + "' ORDER BY idMeteo DESC LIMIT 1";

        try {
            Class.forName(config.getBpKonfiguracija().getDriver_database());
        } catch (Exception ex) {
            System.out.println("Driver baze ne postoji ili greška prilikom učitavanja !");
            System.out.println(ex.toString());
        }

        try (
                Connection con = DriverManager.getConnection(url, config.getBpKonfiguracija().getUser_username(), config.getBpKonfiguracija().getUser_password());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);) {

            if (!rs.isBeforeFirst()) {
                odgovor = "ERR 52";
            } else {
                rs.next();
                odgovor = "OK 10 TEMP " + tempVlaga.format(rs.getFloat("temperatura"))
                        + " VLAGA " + tempVlaga.format(rs.getFloat("vlaga"))
                        + " TLAK " + tlak.format(rs.getFloat("tlak"))
                        + " GEOSIR " + geo.format(rs.getDouble("latitude"))
                        + " GEODUZ " + geo.format(rs.getDouble("longitude")) + " ";
            }
        } catch (SQLException ex) {
            Logger.getLogger(HelperZaZahtjeve.class.getName()).log(Level.SEVERE, null, ex);
        }
        return odgovor;
    }

    public String dodajNovuAdresu(Konfiguracija_projekt config, String adresa, String korisnik) {
        String nazivBaze = config.getBpKonfiguracija().getUser_database();
        String host = config.getBpKonfiguracija().getServer_database();
        String url = host + nazivBaze;

        GoogleMapsKlijent gmk = new GoogleMapsKlijent();
        Location loc = gmk.getGeoLocation(adresa);
        String latitude = loc.getLatitude();
        String longitude = loc.getLongitude();
        System.out.println("LAT LONG" + latitude + longitude);

        String odgovor = "ERR 50";
        String sql = "INSERT INTO matbulic_adrese(adresa, latitude, longitude, korIme) VALUES('" + adresa + "','" + latitude + "','" + longitude + "', '" + korisnik + "')";
        try {
            try {
                Class.forName(config.getBpKonfiguracija().getDriver_database());
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver baze ne postoji ili greška prilikom učitavanja !");
                System.out.println(ex.toString());
            }
            Connection con = DriverManager.getConnection(url, config.getBpKonfiguracija().getUser_username(), config.getBpKonfiguracija().getUser_password());
            Statement st = con.createStatement();
            if (testirajAdresu(config, adresa).equalsIgnoreCase("ERR 51")) {
                st.executeUpdate(sql);
                odgovor = "OK 10";
            } else {
                odgovor = "ERR 50";
            }
            st.close();
        } catch (SQLException ex) {
            System.out.println("Greška pri komunikaciji s bazom:" + ex.toString());
        }
        return odgovor;
    }

    public String testirajAdresu(Konfiguracija_projekt config, String adresa) {
        String nazivBaze = config.getBpKonfiguracija().getUser_database();
        String host = config.getBpKonfiguracija().getServer_database();
        String url = host + nazivBaze;

        String odgovor = "ERR 51";
        String sql = "SELECT * FROM matbulic_adrese WHERE adresa = '" + adresa + "'";

        try {
            try {
                Class.forName(config.getBpKonfiguracija().getDriver_database());
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver baze ne postoji ili greška prilikom učitavanja !");
                System.out.println(ex.toString());
            }

            Connection con = DriverManager.getConnection(url, config.getBpKonfiguracija().getUser_username(), config.getBpKonfiguracija().getUser_password());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (!rs.isBeforeFirst()) {
                odgovor = "ERR 51";
            } else {
                odgovor = "OK 10";
            }
            st.close();

        } catch (SQLException ex) {
            System.out.println("Greška pri komunikaciji s bazom:" + ex.toString());
        }
        return odgovor;
    }

    public String dodajKorisnika(Konfiguracija_projekt config, String usernameNovo, String lozinkaNovo) {
        String nazivBaze = config.getBpKonfiguracija().getUser_database();
        String host = config.getBpKonfiguracija().getServer_database();
        String url = host + nazivBaze;
        String admin = "admin";
        String sql = "INSERT INTO matbulic_korisnik(korIme, lozinka) VALUES('" + usernameNovo + "','" + lozinkaNovo + "')";
        String sql1 = "INSERT INTO matbulic_korisnik_uloge(korIme, uloga) VALUES('" + usernameNovo + "', '"+ admin +"')";
        String odgovor = "OK";
        try {
            try {
                Class.forName(config.getBpKonfiguracija().getDriver_database());
            } catch (ClassNotFoundException ex) {
                System.out.println("Driver baze ne postoji ili greška prilikom učitavanja !");
                System.out.println(ex.toString());
            }
            Connection con = DriverManager.getConnection(url, config.getBpKonfiguracija().getUser_username(), config.getBpKonfiguracija().getUser_password());
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            st.executeUpdate(sql1);

        } catch (SQLException ex) {
            odgovor = "ERROR - user exists";
            System.out.println("Greška pri komunikaciji s bazom:" + ex.toString());
        }
        return odgovor;

    }

}
