/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.matbulic.web.slusaci;

import org.foi.nwtis.matbulic.kontrole.Kontekst;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.foi.nwtis.matbulic.konfiguracije.NemaKonfiguracije;
import org.foi.nwtis.matbulic.kontrole.Konfiguracija_projekt;
import org.foi.nwtis.matbulic.web.dretve.DretvaZaObraduPoruka;

/**
 * Slušać aplikacije koji preuzima postavke, starta glavnu dretvu, zaustavlja tu istu dretvu
 * pri prestanku 
 *
 * @author Bule
 */
@WebListener()
public class SlusacAplikacije implements ServletContextListener {

    private ServerSocket server;
    private Kontekst ctx;
    private DretvaZaObraduPoruka dzmp;
    private static Konfiguracija_projekt config;


    public static Konfiguracija_projekt getProjektKonfig() {
        return config;
    }

    public static void setProjektKonfig(Konfiguracija_projekt konfig) {
        SlusacAplikacije.config = konfig;
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            String path = sce.getServletContext().getRealPath("WEB-INF");
            String datoteka = sce.getServletContext().getInitParameter("config");
            config = new Konfiguracija_projekt(path + File.separator + datoteka);
            sce.getServletContext().setAttribute("konfiguracija", config);
            setProjektKonfig(config);
            System.out.println("Aplikacija je pokrenuta.");
            try {
                server = new ServerSocket(config.getPort());
            } catch (IOException ex) {
                Logger.getLogger(SlusacAplikacije.class.getName()).log(Level.SEVERE, null, ex);
            }
            ctx = Kontekst.getInstance();
            ctx.setKontekst(sce.getServletContext());
            //pokrenuti dretvu za obradu
            dzmp = new DretvaZaObraduPoruka(config, server);
            dzmp.start();
        } catch (NemaKonfiguracije ex) {
            Logger.getLogger(SlusacAplikacije.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nepostojeća ili pogrešna konfiguracijska datoteka");
        }

    }

    public static Konfiguracija_projekt getConfig() {
        return config;
    }

    

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Zaustavljanje servera i dretve !");
        dzmp.interrupt();
        if (server != null && !server.isClosed()) {
            try {
                server.close();
            } catch (IOException ex) {
                Logger.getLogger(SlusacAplikacije.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // This manually deregisters JDBC driver, which prevents Tomcat 7 from complaining about memory leaks wrto this class
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println("Deregistering jdbc driver: " + driver.toString());

            } catch (SQLException ex) {
                System.out.println("Error deregistering driver: " + driver.toString());
            }
        }

    }
}
