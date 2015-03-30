<%-- 
    Document   : prijavaKorisnika
    Created on : Jun 4, 2014, 7:17:30 PM
    Author     : Bule
--%>

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
            <a class="line" href="${pageContext.servletContext.contextPath}/PrijavaKorisnika">Prijava korisnika</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/UnosAdrese">Unos adrese</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/IspisAdresa">Adrese</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/IspisMeteoPodataka">Meteo podaci</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/IspisZahtjevaUpravljackogServera">Zahtjevi servera</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/IspisKorisnickihZahtjeva">Zahtjevi korisnika</a>
            <a class="line" href="${pageContext.servletContext.contextPath}/Dokumentacija">Dokumentacija</a>
        </div>

        <form method="POST" action="j_security_check">
            <table border="0">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="j_username"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="j_password"></td>
                </tr>
            </table>
            <input type="submit" value="Login!">
            </center>
        </form>
    </body>
</html>
