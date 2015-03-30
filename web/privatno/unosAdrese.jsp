<%-- 
    Document   : unosAdrese
    Created on : May 29, 2014, 9:13:21 PM
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
        <title>Unos adrese</title>
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
            <form method="POST" action="${pageContext.servletContext.contextPath}/UnosAdrese">
                <label for="adresa">Adresa: </label>
                <input name="adresa" id="adresa" type="text" style="width:400px"/>
                <input type="submit" value=" Unos adrese "/>
            </form>
        </div>
    </body>
</html>