/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.foi.nwtis.matbulic.ws.serveri;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for weatherData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="weatherData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adrese_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="altimeter" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="altimeterRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="datumPrikupljanja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dewPoint" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="dewPointRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="feelsLike" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="heatIndex" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="humidity" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="humidityRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="iconCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observationTimeAdjustedLocal" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="observationTimeAdjustedLocalStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observationTimeLocal" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="observationTimeLocalStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observationTimeUtc" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="observationTimeUtcStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pressureSeaLevel" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="pressureSeaLevelRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="providerId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rainDaily" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="rainMonthly" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="rainRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="rainYearly" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="snowDaily" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="snowMonthly" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="snowRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="snowYearly" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="stationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="temperature" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="temperatureRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="visibility" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="visibilityRate" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="windChill" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="windDirection" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="windDirectionAvg" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="windGustDaily" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="windGustDirectionDaily" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="windGustDirectionHourly" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="windGustHourly" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="windGustTimeLocalDaily" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="windGustTimeLocalDailyStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="windGustTimeLocalHourly" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="windGustTimeLocalHourlyStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="windGustTimeUtcDaily" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="windGustTimeUtcDailyStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="windGustTimeUtcHourly" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="windGustTimeUtcHourlyStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="windSpeed" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="windSpeedAvg" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "weatherData", propOrder = {
    "adreseID",
    "altimeter",
    "altimeterRate",
    "datumPrikupljanja",
    "dewPoint",
    "dewPointRate",
    "feelsLike",
    "heatIndex",
    "humidity",
    "humidityRate",
    "iconCode",
    "key",
    "observationTimeAdjustedLocal",
    "observationTimeAdjustedLocalStr",
    "observationTimeLocal",
    "observationTimeLocalStr",
    "observationTimeUtc",
    "observationTimeUtcStr",
    "pressureSeaLevel",
    "pressureSeaLevelRate",
    "providerId",
    "rainDaily",
    "rainMonthly",
    "rainRate",
    "rainYearly",
    "snowDaily",
    "snowMonthly",
    "snowRate",
    "snowYearly",
    "stationId",
    "temperature",
    "temperatureRate",
    "visibility",
    "visibilityRate",
    "windChill",
    "windDirection",
    "windDirectionAvg",
    "windGustDaily",
    "windGustDirectionDaily",
    "windGustDirectionHourly",
    "windGustHourly",
    "windGustTimeLocalDaily",
    "windGustTimeLocalDailyStr",
    "windGustTimeLocalHourly",
    "windGustTimeLocalHourlyStr",
    "windGustTimeUtcDaily",
    "windGustTimeUtcDailyStr",
    "windGustTimeUtcHourly",
    "windGustTimeUtcHourlyStr",
    "windSpeed",
    "windSpeedAvg"
})
public class WeatherData {

    @XmlElement(name = "adrese_ID")
    protected String adreseID;
    protected Float altimeter;
    protected Float altimeterRate;
    protected String datumPrikupljanja;
    protected Float dewPoint;
    protected Float dewPointRate;
    protected Float feelsLike;
    protected Float heatIndex;
    protected Float humidity;
    protected Float humidityRate;
    protected String iconCode;
    protected String key;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar observationTimeAdjustedLocal;
    protected String observationTimeAdjustedLocalStr;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar observationTimeLocal;
    protected String observationTimeLocalStr;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar observationTimeUtc;
    protected String observationTimeUtcStr;
    protected Float pressureSeaLevel;
    protected Float pressureSeaLevelRate;
    protected int providerId;
    protected Float rainDaily;
    protected Float rainMonthly;
    protected Float rainRate;
    protected Float rainYearly;
    protected Float snowDaily;
    protected Float snowMonthly;
    protected Float snowRate;
    protected Float snowYearly;
    protected String stationId;
    protected Float temperature;
    protected Float temperatureRate;
    protected Float visibility;
    protected Float visibilityRate;
    protected Float windChill;
    protected Float windDirection;
    protected Float windDirectionAvg;
    protected Float windGustDaily;
    protected Float windGustDirectionDaily;
    protected Float windGustDirectionHourly;
    protected Float windGustHourly;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar windGustTimeLocalDaily;
    protected String windGustTimeLocalDailyStr;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar windGustTimeLocalHourly;
    protected String windGustTimeLocalHourlyStr;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar windGustTimeUtcDaily;
    protected String windGustTimeUtcDailyStr;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar windGustTimeUtcHourly;
    protected String windGustTimeUtcHourlyStr;
    protected Float windSpeed;
    protected Float windSpeedAvg;

    /**
     * Gets the value of the adreseID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdreseID() {
        return adreseID;
    }

    /**
     * Sets the value of the adreseID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdreseID(String value) {
        this.adreseID = value;
    }

    /**
     * Gets the value of the altimeter property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getAltimeter() {
        return altimeter;
    }

    /**
     * Sets the value of the altimeter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setAltimeter(Float value) {
        this.altimeter = value;
    }

    /**
     * Gets the value of the altimeterRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getAltimeterRate() {
        return altimeterRate;
    }

    /**
     * Sets the value of the altimeterRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setAltimeterRate(Float value) {
        this.altimeterRate = value;
    }

    /**
     * Gets the value of the datumPrikupljanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumPrikupljanja() {
        return datumPrikupljanja;
    }

    /**
     * Sets the value of the datumPrikupljanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumPrikupljanja(String value) {
        this.datumPrikupljanja = value;
    }

    /**
     * Gets the value of the dewPoint property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDewPoint() {
        return dewPoint;
    }

    /**
     * Sets the value of the dewPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setDewPoint(Float value) {
        this.dewPoint = value;
    }

    /**
     * Gets the value of the dewPointRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getDewPointRate() {
        return dewPointRate;
    }

    /**
     * Sets the value of the dewPointRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setDewPointRate(Float value) {
        this.dewPointRate = value;
    }

    /**
     * Gets the value of the feelsLike property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFeelsLike() {
        return feelsLike;
    }

    /**
     * Sets the value of the feelsLike property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFeelsLike(Float value) {
        this.feelsLike = value;
    }

    /**
     * Gets the value of the heatIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getHeatIndex() {
        return heatIndex;
    }

    /**
     * Sets the value of the heatIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setHeatIndex(Float value) {
        this.heatIndex = value;
    }

    /**
     * Gets the value of the humidity property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getHumidity() {
        return humidity;
    }

    /**
     * Sets the value of the humidity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setHumidity(Float value) {
        this.humidity = value;
    }

    /**
     * Gets the value of the humidityRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getHumidityRate() {
        return humidityRate;
    }

    /**
     * Sets the value of the humidityRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setHumidityRate(Float value) {
        this.humidityRate = value;
    }

    /**
     * Gets the value of the iconCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIconCode() {
        return iconCode;
    }

    /**
     * Sets the value of the iconCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIconCode(String value) {
        this.iconCode = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the observationTimeAdjustedLocal property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getObservationTimeAdjustedLocal() {
        return observationTimeAdjustedLocal;
    }

    /**
     * Sets the value of the observationTimeAdjustedLocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setObservationTimeAdjustedLocal(XMLGregorianCalendar value) {
        this.observationTimeAdjustedLocal = value;
    }

    /**
     * Gets the value of the observationTimeAdjustedLocalStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservationTimeAdjustedLocalStr() {
        return observationTimeAdjustedLocalStr;
    }

    /**
     * Sets the value of the observationTimeAdjustedLocalStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservationTimeAdjustedLocalStr(String value) {
        this.observationTimeAdjustedLocalStr = value;
    }

    /**
     * Gets the value of the observationTimeLocal property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getObservationTimeLocal() {
        return observationTimeLocal;
    }

    /**
     * Sets the value of the observationTimeLocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setObservationTimeLocal(XMLGregorianCalendar value) {
        this.observationTimeLocal = value;
    }

    /**
     * Gets the value of the observationTimeLocalStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservationTimeLocalStr() {
        return observationTimeLocalStr;
    }

    /**
     * Sets the value of the observationTimeLocalStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservationTimeLocalStr(String value) {
        this.observationTimeLocalStr = value;
    }

    /**
     * Gets the value of the observationTimeUtc property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getObservationTimeUtc() {
        return observationTimeUtc;
    }

    /**
     * Sets the value of the observationTimeUtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setObservationTimeUtc(XMLGregorianCalendar value) {
        this.observationTimeUtc = value;
    }

    /**
     * Gets the value of the observationTimeUtcStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservationTimeUtcStr() {
        return observationTimeUtcStr;
    }

    /**
     * Sets the value of the observationTimeUtcStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservationTimeUtcStr(String value) {
        this.observationTimeUtcStr = value;
    }

    /**
     * Gets the value of the pressureSeaLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPressureSeaLevel() {
        return pressureSeaLevel;
    }

    /**
     * Sets the value of the pressureSeaLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPressureSeaLevel(Float value) {
        this.pressureSeaLevel = value;
    }

    /**
     * Gets the value of the pressureSeaLevelRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPressureSeaLevelRate() {
        return pressureSeaLevelRate;
    }

    /**
     * Sets the value of the pressureSeaLevelRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPressureSeaLevelRate(Float value) {
        this.pressureSeaLevelRate = value;
    }

    /**
     * Gets the value of the providerId property.
     * 
     */
    public int getProviderId() {
        return providerId;
    }

    /**
     * Sets the value of the providerId property.
     * 
     */
    public void setProviderId(int value) {
        this.providerId = value;
    }

    /**
     * Gets the value of the rainDaily property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRainDaily() {
        return rainDaily;
    }

    /**
     * Sets the value of the rainDaily property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRainDaily(Float value) {
        this.rainDaily = value;
    }

    /**
     * Gets the value of the rainMonthly property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRainMonthly() {
        return rainMonthly;
    }

    /**
     * Sets the value of the rainMonthly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRainMonthly(Float value) {
        this.rainMonthly = value;
    }

    /**
     * Gets the value of the rainRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRainRate() {
        return rainRate;
    }

    /**
     * Sets the value of the rainRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRainRate(Float value) {
        this.rainRate = value;
    }

    /**
     * Gets the value of the rainYearly property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRainYearly() {
        return rainYearly;
    }

    /**
     * Sets the value of the rainYearly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRainYearly(Float value) {
        this.rainYearly = value;
    }

    /**
     * Gets the value of the snowDaily property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSnowDaily() {
        return snowDaily;
    }

    /**
     * Sets the value of the snowDaily property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSnowDaily(Float value) {
        this.snowDaily = value;
    }

    /**
     * Gets the value of the snowMonthly property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSnowMonthly() {
        return snowMonthly;
    }

    /**
     * Sets the value of the snowMonthly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSnowMonthly(Float value) {
        this.snowMonthly = value;
    }

    /**
     * Gets the value of the snowRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSnowRate() {
        return snowRate;
    }

    /**
     * Sets the value of the snowRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSnowRate(Float value) {
        this.snowRate = value;
    }

    /**
     * Gets the value of the snowYearly property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSnowYearly() {
        return snowYearly;
    }

    /**
     * Sets the value of the snowYearly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSnowYearly(Float value) {
        this.snowYearly = value;
    }

    /**
     * Gets the value of the stationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStationId() {
        return stationId;
    }

    /**
     * Sets the value of the stationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStationId(String value) {
        this.stationId = value;
    }

    /**
     * Gets the value of the temperature property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTemperature() {
        return temperature;
    }

    /**
     * Sets the value of the temperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTemperature(Float value) {
        this.temperature = value;
    }

    /**
     * Gets the value of the temperatureRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTemperatureRate() {
        return temperatureRate;
    }

    /**
     * Sets the value of the temperatureRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTemperatureRate(Float value) {
        this.temperatureRate = value;
    }

    /**
     * Gets the value of the visibility property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getVisibility() {
        return visibility;
    }

    /**
     * Sets the value of the visibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setVisibility(Float value) {
        this.visibility = value;
    }

    /**
     * Gets the value of the visibilityRate property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getVisibilityRate() {
        return visibilityRate;
    }

    /**
     * Sets the value of the visibilityRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setVisibilityRate(Float value) {
        this.visibilityRate = value;
    }

    /**
     * Gets the value of the windChill property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWindChill() {
        return windChill;
    }

    /**
     * Sets the value of the windChill property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWindChill(Float value) {
        this.windChill = value;
    }

    /**
     * Gets the value of the windDirection property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWindDirection() {
        return windDirection;
    }

    /**
     * Sets the value of the windDirection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWindDirection(Float value) {
        this.windDirection = value;
    }

    /**
     * Gets the value of the windDirectionAvg property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWindDirectionAvg() {
        return windDirectionAvg;
    }

    /**
     * Sets the value of the windDirectionAvg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWindDirectionAvg(Float value) {
        this.windDirectionAvg = value;
    }

    /**
     * Gets the value of the windGustDaily property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWindGustDaily() {
        return windGustDaily;
    }

    /**
     * Sets the value of the windGustDaily property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWindGustDaily(Float value) {
        this.windGustDaily = value;
    }

    /**
     * Gets the value of the windGustDirectionDaily property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWindGustDirectionDaily() {
        return windGustDirectionDaily;
    }

    /**
     * Sets the value of the windGustDirectionDaily property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWindGustDirectionDaily(Float value) {
        this.windGustDirectionDaily = value;
    }

    /**
     * Gets the value of the windGustDirectionHourly property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWindGustDirectionHourly() {
        return windGustDirectionHourly;
    }

    /**
     * Sets the value of the windGustDirectionHourly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWindGustDirectionHourly(Float value) {
        this.windGustDirectionHourly = value;
    }

    /**
     * Gets the value of the windGustHourly property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWindGustHourly() {
        return windGustHourly;
    }

    /**
     * Sets the value of the windGustHourly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWindGustHourly(Float value) {
        this.windGustHourly = value;
    }

    /**
     * Gets the value of the windGustTimeLocalDaily property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWindGustTimeLocalDaily() {
        return windGustTimeLocalDaily;
    }

    /**
     * Sets the value of the windGustTimeLocalDaily property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWindGustTimeLocalDaily(XMLGregorianCalendar value) {
        this.windGustTimeLocalDaily = value;
    }

    /**
     * Gets the value of the windGustTimeLocalDailyStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindGustTimeLocalDailyStr() {
        return windGustTimeLocalDailyStr;
    }

    /**
     * Sets the value of the windGustTimeLocalDailyStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindGustTimeLocalDailyStr(String value) {
        this.windGustTimeLocalDailyStr = value;
    }

    /**
     * Gets the value of the windGustTimeLocalHourly property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWindGustTimeLocalHourly() {
        return windGustTimeLocalHourly;
    }

    /**
     * Sets the value of the windGustTimeLocalHourly property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWindGustTimeLocalHourly(XMLGregorianCalendar value) {
        this.windGustTimeLocalHourly = value;
    }

    /**
     * Gets the value of the windGustTimeLocalHourlyStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindGustTimeLocalHourlyStr() {
        return windGustTimeLocalHourlyStr;
    }

    /**
     * Sets the value of the windGustTimeLocalHourlyStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindGustTimeLocalHourlyStr(String value) {
        this.windGustTimeLocalHourlyStr = value;
    }

    /**
     * Gets the value of the windGustTimeUtcDaily property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWindGustTimeUtcDaily() {
        return windGustTimeUtcDaily;
    }

    /**
     * Sets the value of the windGustTimeUtcDaily property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWindGustTimeUtcDaily(XMLGregorianCalendar value) {
        this.windGustTimeUtcDaily = value;
    }

    /**
     * Gets the value of the windGustTimeUtcDailyStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindGustTimeUtcDailyStr() {
        return windGustTimeUtcDailyStr;
    }

    /**
     * Sets the value of the windGustTimeUtcDailyStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindGustTimeUtcDailyStr(String value) {
        this.windGustTimeUtcDailyStr = value;
    }

    /**
     * Gets the value of the windGustTimeUtcHourly property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWindGustTimeUtcHourly() {
        return windGustTimeUtcHourly;
    }

    /**
     * Sets the value of the windGustTimeUtcHourly property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWindGustTimeUtcHourly(XMLGregorianCalendar value) {
        this.windGustTimeUtcHourly = value;
    }

    /**
     * Gets the value of the windGustTimeUtcHourlyStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWindGustTimeUtcHourlyStr() {
        return windGustTimeUtcHourlyStr;
    }

    /**
     * Sets the value of the windGustTimeUtcHourlyStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWindGustTimeUtcHourlyStr(String value) {
        this.windGustTimeUtcHourlyStr = value;
    }

    /**
     * Gets the value of the windSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWindSpeed() {
        return windSpeed;
    }

    /**
     * Sets the value of the windSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWindSpeed(Float value) {
        this.windSpeed = value;
    }

    /**
     * Gets the value of the windSpeedAvg property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getWindSpeedAvg() {
        return windSpeedAvg;
    }

    /**
     * Sets the value of the windSpeedAvg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setWindSpeedAvg(Float value) {
        this.windSpeedAvg = value;
    }

}

