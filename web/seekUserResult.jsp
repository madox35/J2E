<%-- 
    Document   : seekUserResult
    Created on : 18 oct. 2017, 16:45:01
    Author     : Hugo Jové (sécurité)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Résultat de la recherche</title>
    </head>
    <body>
        <h1>Résultat de la recherche</h1>
        <c:choose>
            <c:when test="${ seekUser == null }">
                L'utilisateur recherché n'a pas été trouvé!
            </c:when>
            <c:otherwise>
                L'utilisateur, <c:out value="${ seekUser.prenom }"/> <c:out value="${ seekUser.nom }"/>, a bien été trouvé!
            </c:otherwise>
        </c:choose> 
                
        <div>
            <a href="seekUserForm.jsp">Recherche une nouvelle personne</a>
            <a href="index.jsp">Accueil</a>
        </div>
    </body>
</html>
