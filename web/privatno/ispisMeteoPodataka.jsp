<%-- 
    Document   : ispisMeteoPodataka
    Created on : May 28, 2014, 9:13:21 PM
    Author     : Bule
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ispis meteo podataka</title>
        <link href="${pageContext.servletContext.contextPath}/css/displaytag.css" type="text/css" rel="stylesheet"/>
        <link href="${pageContext.servletContext.contextPath}/css/header.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="header">
            matbulic_aplikacija 1
        </div>

        <div class="top">          
            <a class="line" href="${pageContext.servletContext.contextPath}/Kontroler">Index</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/UnosAdrese">Unos adrese</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/IspisAdresa">Adrese</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/IspisMeteoPodataka">Meteo podaci</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/IspisZahtjevaUpravljackogServera">Zahtjevi servera</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/IspisKorisnickihZahtjeva">Zahtjevi korisnika</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/Dokumentacija">Dokumentacija</a>
        </div>


        <div class="sadrzaj">
            <form action="${pageContext.servletContext.contextPath}/IspisMeteoPodataka" method="post">
                Broj prikazanih elemenata: 
                <input type="radio" name="stranicenje" value="5">5
                <input type="radio" name="stranicenje" value="10">10
                <input type="radio" name="stranicenje" value="20">20
                <input type="radio" name="stranicenje" value="50">50
                <input type="radio" name="stranicenje" value="100">100
                <input type="radio" name="stranicenje" value="svi">Svi<br/>
                Filtriraj po adresama: 
                <sql:setDataSource var="nwtisq"
                                   driver="${applicationScope.konfiguracija.getBpKonfiguracija().getDriver_database()}"
                                   url="${applicationScope.konfiguracija.getBpKonfiguracija().getServer_database()}${applicationScope.konfiguracija.getBpKonfiguracija().getUser_database()}"
                                   user="${applicationScope.konfiguracija.getBpKonfiguracija().getUser_username()}"
                                   password="${applicationScope.konfiguracija.getBpKonfiguracija().getUser_password()}"/>
                <sql:transaction dataSource="${nwtisq}">
                    <sql:query var="popisAdresa">
                        SELECT adresa FROM matbulic_adrese;
                    </sql:query>
                    <select id="filterAdresa" name="filterAdresa" >
                        <option value=""></option>
                        <c:forEach var="adr" items="${popisAdresa.rows}">
                            <option value="${adr.adresa}">${adr.adresa}</option>
                        </c:forEach>
                    </select>
                </sql:transaction>
                Filtriraj po datumu, od: <input type="text" name="datumOd" value="" />
                do: <input type="text" name="datumDo" value="" />
                <button type="submit">Osvježi</button><br/><br/>
            </form>


            <sql:setDataSource
                var="nwtis"
                driver="${applicationScope.konfiguracija.getBpKonfiguracija().getDriver_database()}"
                url="${applicationScope.konfiguracija.getBpKonfiguracija().getServer_database()}${applicationScope.konfiguracija.getBpKonfiguracija().getUser_database()}"
                user="${applicationScope.konfiguracija.getBpKonfiguracija().getUser_username()}"
                password="${applicationScope.konfiguracija.getBpKonfiguracija().getUser_password()}"
                />
            <sql:transaction dataSource="${nwtis}">
                <sql:query var="podaci">
                     ${sessionScope.upit}
                </sql:query>

                <display:table name="${podaci.rows}" pagesize="${sessionScope.paginationValue}" sort="list" defaultsort="3" defaultorder="descending">
                    <display:column sortable="true" headerClass="sortable" property="idMeteo" title="MeteoID"/>
                    <display:column sortable="true" headerClass="sortable" property="temperatura" title="Temperatura"/>
                    <display:column sortable="true" headerClass="sortable" property="tlak" title="Tlak"/>
                    <display:column sortable="true" headerClass="sortable" property="vlaga" title="Vlaga"/>
                    <display:column sortable="true" headerClass="sortable" property="vjetar" title="Vjetar"/>
                    <display:column sortable="true" headerClass="sortable" property="kisa" title="Kiša"/>
                    <display:column sortable="true" headerClass="sortable" property="snijeg" title="Snijeg"/>
                    <display:column sortable="true" headerClass="sortable" property="vrijeme" title="Vrijeme"/>
                    <display:column sortable="true" headerClass="sortable" property="adresa" title="Adresa"/>
                </display:table>
            </sql:transaction>
        </div>

    </body>
</html>
