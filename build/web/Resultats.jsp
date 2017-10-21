<%--
    Document   : Bonus
    Created on : 17 oct. 2017, 21:29:01
    Author     : Hugo Jové (sécurité)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
            td{
                width:20%;
                height:30px;
            }
        </style>
        <h1>Affichages des utilisateurs</h1>
        
        <h2> Ensemble des utilisateurs de la BDD (<c:out value="${ nb_users }" />)</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Login</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ allUsers }" var="user">
                    <tr>
                        <td><c:out value="${ user.nom }" /></td>
                        <td><c:out value="${ user.prenom }" /></td>
                        <td><c:out value="${ user.login }" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <h2> Voici le dernier utilisateur que vous avez ajouté </h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Login</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><c:out value="${ lastUserAdded.nom }" /></td>
                    <td><c:out value="${ lastUserAdded.prenom }" /></td>
                    <td><c:out value="${ lastUserAdded.login }" /></td>
                </tr>
            </tbody>
        </table>        
    </body>
</html>
