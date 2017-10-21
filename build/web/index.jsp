<%-- 
    Document   : index
    Created on : 17 oct. 2017, 21:27:48
    Author     : Hugo Jové (sécurité)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
   
     <h1>Examen JEE</h1>
     
        <form method="POST" action="/Exam/Servlet">
            
            <table border="1">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Login</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" begin="0" end="3" step="1">
                        <tr>
                            <td><input type="text" name="nom" /></td>
                            <td><input type="text" name="prenom" /></td>
                            <td><input type="text" name="login" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
          
            <input type="submit" name="enregistrer" value="Enregistrer" />
            <input type="reset" name="reset" value="Réinitialiser" />
        </form>
     
        <a href="seekUserForm.jsp">Rechercher un utilisateur</a>
</html>

