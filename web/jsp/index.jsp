<%-- 
    Document   : index
    Created on : May 27, 2014, 5:25:29 PM
    Author     : Bule
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NWTiS projekt</title>
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
    </body>
</html>
