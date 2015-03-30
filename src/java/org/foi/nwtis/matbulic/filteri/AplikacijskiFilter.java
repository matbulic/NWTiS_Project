/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.matbulic.filteri;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.foi.nwtis.matbulic.helperi.HelperZaBazu;
import org.foi.nwtis.matbulic.kontrole.Konfiguracija_projekt;
import org.foi.nwtis.matbulic.web.slusaci.SlusacAplikacije;

/**
 *
 * @author matbulic Klasa AFilter je klasa koja implementira sučelje filtera koji
 * učahuruje poslove koji se ponavljaju, u našem slučaju radi se o praćenju
 * dnevničkih poslova, praćenju aktivnosti korisnika, straničenje, filtriranje
 * po datumu, to okidanja događaja za pristup bazi i prikaz dobivenih rezultata
 * na stranici korisnika.
 */
public class AplikacijskiFilter implements Filter {

    private final String encoding = "utf-8";
    private long pocetnoVrijeme;
    private Konfiguracija_projekt konfig;
    int brojac = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        Random r = new Random();
        pocetnoVrijeme = System.currentTimeMillis();
        
    }

    /**
     * Filter je definiram i konfiguriran u opisniku isporuke web.xml-u Metoda
     * doFilter je osnovna za implementaciju filtera, njome su obuhvaćeni svi
     * događaji koji se mogu pojaviti u slučaju korisnikove aktivnosti.
     *
     * @param req - radi samo kada zahtjev dolazi direktno od korisnika
     * @param resp - šalje se odgovor na korisnikov zahtjev
     * @param chain - spremanje se obično obavlja prije nego se šalje zahtjev
     * slijedećem filteru u lancu. Za trajanje obrade potrebno je preuzeti
     * vrijeme prije početkaa obrade, izvršiti obradu (tj. poslati zahtjev
     * sljedeć em filteru u lancu filtera npr. chain.doFilter(...), preuzeti
     * vrijeme nakon obrade a razlikačini trajanje obrade.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        doBeforeProcessing(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        request.setCharacterEncoding(encoding);
        HttpSession session = request.getSession(false);
        String username = "";
        konfig = SlusacAplikacije.getProjektKonfig();
        HelperZaBazu upis = new HelperZaBazu(konfig);
        username = request.getRemoteUser();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh.mm.ss");
        String datum = sdf.format(new Date());
        //String zahtjev = request.getServletPath();
        String url = request.getRequestURL().toString();
        long vrijeme = (System.currentTimeMillis() - pocetnoVrijeme) / 1000;
        String filterAdresa = request.getParameter("filterAdresa");
        String filterKomandi = request.getParameter("filterKomandi");
        String datumOd = request.getParameter("datumOd");
        String datumDo = request.getParameter("datumDo");
        String datumOd2 = request.getParameter("datumOd2");
        String datumDo2 = request.getParameter("datumDo2");
        String datumDo5 = request.getParameter("datumDo5");
        String datumOd5 = request.getParameter("datumOd5");

        //provjera je li korisnik prijavljen
        if (username == null && !url.contains("privatno") && !url.contains("admin")) {
            upis.dodajZahtjevKorisnika(url + " neuspješna prijava", datum, vrijeme, username);
        } else if (!url.contains("privatno") && !url.contains("admin")) {
            upis.dodajZahtjevKorisnika(url + " uspješna prijava", datum, vrijeme, username);
        }
        //straničenje
        if (request.getParameter("stranicenje") != null && !request.getParameter("stranicenje").equals("svi")) {
            int i = Integer.parseInt(request.getParameter("stranicenje"));
            request.getSession().setAttribute("paginationValue", i);
        } else if (request.getParameter("stranicenje") != null && request.getParameter("stranicenje").equals("svi")) {
            request.getSession().setAttribute("paginationValue", "");
        } else {
            if (request.getSession().getAttribute("paginationValue") == null) {
                request.getSession().setAttribute("paginationValue", 5);
            }
        }

        //FILTER za pregledPrognoze.jsp
        if (filterAdresa != null && !filterAdresa.equals("")
                && datumOd != null && datumOd.equals("")
                && datumDo != null && datumDo.equals("")) {
            request.getSession().setAttribute("upit", "SELECT * FROM matbulic_meteo INNER JOIN matbulic_adrese ON matbulic_meteo.idAdresa=matbulic_adrese.idAdresa ORDER BY idMeteo DESC;");
            upis.dodajZahtjevKorisnika(url + " ... filtriranje meteo podataka", datum, vrijeme, username);
        } else if (request.getParameter("filterAdresa") != null && !request.getParameter("filterAdresa").equals("")
                && datumOd != null && datumOd.equals("")
                && datumDo != null && datumDo.equals("")) {
            System.out.println("ADRESA FILTERA:" + filterAdresa.toString());

            String item = URLDecoder.decode(request.getParameter("filterAdresa"), "UTF-8");
            request.getSession().setAttribute("upit", "SELECT * FROM matbulic_meteo INNER JOIN matbulic_adrese ON matbulic_meteo.idAdresa=matbulic_adrese.idAdresa WHERE adresa = '" + item + "';");
            upis.dodajZahtjevKorisnika(url + " ... filtriranje meteo podataka", datum, vrijeme, username);

        } else if (filterAdresa != null && filterAdresa.equals("")
                && datumOd != null && !datumOd.equals("")
                && datumDo != null && !datumDo.equals("")) {
            try {
                DateFormat sdfPom = new SimpleDateFormat("dd.MM.yyyy hh.mm.ss");
                Date datumOdPom = sdfPom.parse(datumOd);
                Date datumDoPom = sdfPom.parse(datumDo);
                String dOd = sdf.format(datumOdPom);
                String dDo = sdf.format(datumDoPom);
                request.getSession().setAttribute("upit", "SELECT * FROM matbulic_meteo INNER JOIN matbulic_adrese ON matbulic_meteo.idAdresa=matbulic_adrese.idAdresa WHERE vrijeme<'"
                        + dDo + "' AND vrijeme>'" + dOd + "'");

                upis.dodajZahtjevKorisnika(url + " ... filtriranje meteopodataka", datum, vrijeme, username);

            } catch (ParseException ex) {
                Logger.getLogger(AplikacijskiFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (filterAdresa != null && !filterAdresa.equals("")
                && datumOd != null && !datumOd.equals("")
                && datumDo != null && !datumDo.equals("")) {
            try {
                SimpleDateFormat sdfPom = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
                Date datumOdPom = sdfPom.parse(datumOd);
                Date datumDoPom = sdfPom.parse(datumDo);
                String dOd = sdf.format(datumOdPom);
                String dDo = sdf.format(datumDoPom);
                request.getSession().setAttribute("upit", "SELECT * FROM matbulic_meteo INNER JOIN matbulic_adrese ON matbulic_meteo.idAdresa=matbulic_adrese.idAdresa WHERE vrijeme<'"
                        + dDo + "' AND vrijeme>'"
                        + dOd + "' AND adresa = '" + filterAdresa.toString() + "'");
                upis.dodajZahtjevKorisnika(url + " ... filtriranje meteopodataka", datum, vrijeme, username);
            } catch (ParseException ex) {
                Logger.getLogger(AplikacijskiFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (request.getSession().getAttribute("upit") == null) {
                request.getSession().setAttribute("upit", "SELECT * FROM matbulic_meteo INNER JOIN matbulic_adrese ON matbulic_meteo.idAdresa=matbulic_adrese.idAdresa ORDER BY idMeteo DESC;");
            }
        }

        //FILTER za pregledAdresa.jsp
        if (request.getParameter("traziAdrese") != null && !request.getParameter("traziAdrese").equals("")) {
            String grad = request.getParameter("traziAdrese").toString();
            request.getSession().setAttribute("upit2", "SELECT * FROM matbulic_adrese Where adresa like '%" + grad + "%';");
            upis.dodajZahtjevKorisnika(url + " ... filtriranje adresa", datum, vrijeme, username);
        } else {
            if (request.getSession().getAttribute("upit2") == null) {
                request.getSession().setAttribute("upit2", "SELECT * FROM matbulic_adrese");
                upis.dodajZahtjevKorisnika(url + " ... pregled adresa", datum, vrijeme, username);
            }
        }

        //FILTER za ispisKorisnickihZahtjeva.jsp
        if (datumOd2 != null && datumOd2.equals("") && datumDo2 != null && datumDo2.equals("")) {
            request.getSession().setAttribute("upit3", "SELECT * FROM matbulic_korisnicki_dnevnik ORDER BY vrijeme ASC;");
            upis.dodajZahtjevKorisnika(url + " ... korisnički zahtjevi", datum, vrijeme, username);
        }  else if (datumOd2 != null && !datumOd2.equals("") && datumDo2 != null && !datumDo2.equals("")) {
            try {
                DateFormat sdfPom = new SimpleDateFormat("dd.MM.yyyy hh.mm.ss");
                Date datumOdPom = sdfPom.parse(datumOd2);
                Date datumDoPom = sdfPom.parse(datumDo2);
                String dOd = sdf.format(datumOdPom);
                String dDo = sdf.format(datumDoPom);
                request.getSession().setAttribute("upit3", "SELECT * FROM matbulic_korisnicki_dnevnik WHERE vrijeme<'"
                        + dDo + "' AND vrijeme>'" + dOd + "'");
                upis.dodajZahtjevKorisnika(url + " ... filtriranje korisnickih zahtjeva", datum, vrijeme, username);
            } catch (ParseException ex) {
                Logger.getLogger(AplikacijskiFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else{
            if (request.getSession().getAttribute("upit3") == null)
            request.getSession().setAttribute("upit3", "SELECT * FROM matbulic_korisnicki_dnevnik ORDER BY vrijeme ASC;");
        }
        
        //FILTER za oregledZahtjeva.jsp
        if (filterKomandi != null && filterKomandi.equals("")
                && datumOd5 != null && datumOd5.equals("")
                && datumDo5 != null && datumDo5.equals("")) {
            request.getSession().setAttribute("upitServera", "SELECT * FROM matbulic_dnevnik ORDER BY idDnevnik DESC;");
        } else if (filterKomandi != null && !filterKomandi.equals("")
                && datumOd5 != null && datumOd5.equals("")
                && datumDo5 != null && datumDo5.equals("")) {
            System.out.println("ADRESA FILTERA:" + filterKomandi.toString());
            upis.dodajZahtjevKorisnika(url + " ... filtriranje dnevnickih zahtjeva", datum, vrijeme, username);
            request.getSession().setAttribute("upitServera", "SELECT * FROM matbulic_dnevnik WHERE komanda Like '%" + filterKomandi + "%';");
        } else if (filterKomandi != null && filterKomandi.equals("")
                && datumOd5 != null && !datumOd5.equals("")
                && datumDo5 != null && !datumDo5.equals("")) {
            try {
                SimpleDateFormat sdfPom = new SimpleDateFormat("dd.MM.yyyy hh.mm.ss");
                String datumOd1 = datumOd5;
                String datumDo1 = datumDo5;
                Date datumOd1Pom = sdfPom.parse(datumOd1);
                Date datumDo1Pom = sdfPom.parse(datumDo1);
                String dOd1 = sdf.format(datumOd1Pom);
                String dDo1 = sdf.format(datumDo1Pom);
                request.getSession().setAttribute("upitServera", "SELECT * FROM matbulic_dnevnik WHERE vrijeme<'"
                        + dDo1 + "' AND vrijeme>'" + dOd1 + "'");
                upis.dodajZahtjevKorisnika(url + " ... filtriranje dnevnickih zahtjeva", datum, vrijeme, username);
            } catch (ParseException ex) {
                Logger.getLogger(AplikacijskiFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (filterKomandi != null && !filterKomandi.equals("")
                && datumOd5 != null && !datumOd5.equals("")
                && datumDo5 != null && !datumDo5.equals("")) {
            try {
                SimpleDateFormat sdfPom = new SimpleDateFormat("dd.MM.yyyy hh.mm.ss");
                String datumOd1 = datumOd5;
                String datumDo1 = datumDo5;
                Date datumOd1Pom = sdfPom.parse(datumOd1);
                Date datumDo1Pom = sdfPom.parse(datumDo1);
                String dOd1 = sdf.format(datumOd1Pom);
                String dDo1 = sdf.format(datumDo1Pom);
                request.getSession().setAttribute("upitServera", "SELECT * FROM matbulic_dnevnik WHERE vrijeme<'"
                        + dDo1 + "' AND vrijeme>'"
                        + dOd1 + "' AND komanda Like '%" + filterKomandi.toString() + "%'");
                upis.dodajZahtjevKorisnika(url + " ... filtriranje dnevnickih zahtjeva", datum, vrijeme, username);
            } catch (ParseException ex) {
                Logger.getLogger(AplikacijskiFilter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (request.getSession().getAttribute("upitServera") == null)
            request.getSession().setAttribute("upitServera", "SELECT * FROM matbulic_dnevnik ORDER BY idDnevnik DESC;");
        }
        

        chain.doFilter(req, resp);//sends request to next resource
    }

    @Override
    public void destroy() {

    }

}
