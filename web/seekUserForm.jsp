<%-- 
    Document   : seekUser
    Created on : 18 oct. 2017, 16:28:31
    Author     : Hugo Jové (sécurité)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche d'un utilisateur</title>
    </head>
    <body>
        <h1>Qui souhaitez-vous rechercher ?</h1>
        <form method="POST" action="/Exam/ServletSeekUser">
            Nom : <input type="text" name="nom" /><br>
            Prénom :<input type="text" name="prenom" />
            <input type="submit" value="Lancer la recherche"/>
        </form>
    </body>
</html>
