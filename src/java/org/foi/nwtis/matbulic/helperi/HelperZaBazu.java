/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.matbulic.helperi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.foi.nwtis.matbulic.kontrole.Konfiguracija_projekt;

/**
 * Pomoć pri uspostavi veze s bazom, i neke metode oko nje
 * @author Bule
 */
public class HelperZaBazu {

    private Konfiguracija_projekt config;

    public HelperZaBazu(Konfiguracija_projekt config) {
        this.config = config;
    }

    public HelperZaBazu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Connection otvoriVezu() throws ClassNotFoundException, Exception, SQLException {
        Connection con;
        if (config == null) {
            throw new Exception();
        }
        String url = config.getBpKonfiguracija().getServer_database() + config.getBpKonfiguracija().getUser_database();
        Class.forName(config.getBpKonfiguracija().getDriver_database());
        con = DriverManager.getConnection(url, config.getBpKonfiguracija().getUser_username(), config.getBpKonfiguracija().getUser_password());
        return con;
    }

    public boolean dodajAdresu(String adresa, Double latitude, Double longitude) {
        String upit = "INSERT INTO matbulic_adrese (adresa, latitude, longitude)"
                + " VALUES ('" + adresa + "', '" + latitude + "', '" + longitude + "')";
        try {
            Connection con = otvoriVezu();
            Statement stmt = con.createStatement();
            stmt.execute(upit);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HelperZaBazu.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(HelperZaBazu.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void dodajZahtjevKorisnika(String zahtjev, String vrijeme, long trajanje, String username) {
        String sVrijeme = vrijeme;
        String upit = "INSERT INTO matbulic_korisnicki_dnevnik (zahtjev, vrijeme, trajanje, korisnik)"
                + " VALUES ('" + zahtjev + "', '" + sVrijeme + "', '" + trajanje + "', '" + username + "')";
        try {
            Connection con = otvoriVezu();
            Statement stmt = con.createStatement();
            stmt.execute(upit);
        } catch (SQLException ex) {
            Logger.getLogger(HelperZaBazu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HelperZaBazu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
