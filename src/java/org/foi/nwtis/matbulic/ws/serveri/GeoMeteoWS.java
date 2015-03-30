/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foi.nwtis.matbulic.ws.serveri;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.foi.nwtis.matbulic.kontrole.Konfiguracija_projekt;
import org.foi.nwtis.matbulic.rest.klijenti.GoogleMapsKlijent;
import org.foi.nwtis.matbulic.rest.klijenti.WeatherBugKlijent;
import org.foi.nwtis.matbulic.web.podaci.Adresa;
import org.foi.nwtis.matbulic.web.podaci.Location;
import org.foi.nwtis.matbulic.web.slusaci.SlusacAplikacije;

/**
 *
 * @author ivanbulic
 */
@WebService(serviceName = "GeoMeteoWS")
public class GeoMeteoWS {

    /**
     * Web service operation, daj popis svih adresa za koje se prikazuju
     * meterološki podaci
     *
     * @return listu adresa
     */
    @WebMethod(operationName = "dajSveAdrese")
    public List<Adresa> dajSveAdrese() {
        GeoMeteoWSAPI gmapi = new GeoMeteoWSAPI();
        return gmapi.dohvatiSveAdrese();
    }

    /**
     * Web service operation, daje zadnje meteo podatke za traženu adresu
     *
     * @param adresa ulazna adresa
     * @return listu adresa
     */
    @WebMethod(operationName = "dajVazeceMeteoPodatkeZaAdresu")
    public WeatherData dajVazeceMeteoPodatkeZaAdresu(@WebParam(name = "adresa") final String adresa) {
        Konfiguracija_projekt wk = SlusacAplikacije.getConfig();
        String cKey = wk.getcKey();
        String sKey = wk.getsKey();
        if (adresa != null && adresa.length() > 0) {
            GoogleMapsKlijent gmk = new GoogleMapsKlijent();
            Location loc = gmk.getGeoLocation(adresa);
            WeatherBugKlijent wbk = new WeatherBugKlijent(cKey, sKey);
            WeatherData wd = wbk.getRealTimeWeather(loc.getLatitude(), loc.getLongitude());
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
            Date date = new Date();
            wd.setDatumPrikupljanja(dateFormat.format(date));
            return wd;
        }
        return null;
    }

    /**
     * Web service operation, vraća zadnje poznate meteo podatke iz evidencije
     *
     * @param adresa ulazna adresa
     * @return listu adresa
     */
    @WebMethod(operationName = "dajZadnjeMeteoPodatkeZaAdresu")
    public WeatherData dajZadnjeMeteoPodatkeZaAdresu(@WebParam(name = "adresa") final String adresa) {
        GeoMeteoWSAPI gmapi = new GeoMeteoWSAPI();
        Integer idAdresa = gmapi.dohvatiIdAdrese(adresa);

        if (idAdresa != null) {
            return gmapi.dohvatiZadnjeMeteoPodatkeZaAdresu(idAdresa);
        }
        return null;
    }

    /**
     * Web service operation, dohvaća sve meteo podatke iz evidencije za traženu
     * adresu
     *
     * @param adresa ulazna adresa
     * @return listu adresa
     */
    @WebMethod(operationName = "dajSveMeteoPodatkeZaAdresu")
    public List<WeatherData> dajSveMeteoPodatkeZaAdresu(@WebParam(name = "adresa") final String adresa) {
        GeoMeteoWSAPI gmapi = new GeoMeteoWSAPI();
        Integer idAdresa = gmapi.dohvatiIdAdrese(adresa);

        if (idAdresa != null) {
            return gmapi.dohvatiSveMeteoPodatkeZaAdresu(idAdresa);
        }
        return null;
    }

    /**
     * Web service operation Daj rang listu top n adresa za koje je prikupljeno
     * najviše podataka.
     *
     * @param topN koliko adresa se želi prikazati
     * @return lista adresa
     */
    @WebMethod(operationName = "dajRangListu")
    public List<Adresa> dajRangListu(@WebParam(name = "topN") int topN) {
        GeoMeteoWSAPI gmapi = new GeoMeteoWSAPI();
        return gmapi.dajRangListuAdresa(topN);
    }

    /**
     * Web service operation Daje listu posljednih n meteo podataka za adresu
     *
     * @param adresa ulazna adresa
     * @param n broj koliki se želi meteo podataka prikazati
     * @return lista adresa
     */
    @WebMethod(operationName = "dajPosljednjihNMeteoPodatakaZaAdresu")
    public List<WeatherData> dajPosljednjihNMeteoPodatakaZaAdresu(@WebParam(name = "adresa") String adresa, @WebParam(name = "n") int n) {
        GeoMeteoWSAPI gmapi = new GeoMeteoWSAPI();
        return gmapi.dajZadnjihNMeteoPodatakaZaAdresu(adresa, n);
    }

    /**
     * !! java.util.Date se u inputu očekuje kao xml.Gregorian format ??? Web
     * service operation
     *
     * @param adresa
     * @param odDatum
     * @param doDatum
     * @return
     */
    @WebMethod(operationName = "dajMeteoPodatkeZaAdresuUIntervalu")
    public List<WeatherData> dajMeteoPodatkeZaAdresuUIntervalu(@WebParam(name = "adresa") String adresa, @WebParam(name = "odDatum") String odDatum, @WebParam(name = "doDatum") String doDatum) {
        GeoMeteoWSAPI gmapi = new GeoMeteoWSAPI();
        return gmapi.getIntervalMeteoPodatke(adresa, odDatum, doDatum);
    }
}
