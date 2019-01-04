<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ page import="com.google.appengine.api.users.*" %>
<% UserService userService = UserServiceFactory.getUserService(); %>
<%@ page import="java.util.List" %>
<%@ page import="entites.Tweet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding a followed and follors for this one</title>
</head>
<body>

       <h1>Entrez le nom de la personne que vous voulez suivre</h1>
       <form method="post" action="FollowersAdding">
            <fieldset>
                 <label for="aajouter">message d utilisateur</label>
                <input type="text" id="aajouter" name="aajouter" value="" size="20" maxlength="20" />
                <br />
                <input type="submit" value="Ajouter" class="sansLabel" />
                <br />
            </fieldset>
        </form>
        <p>
         <% 
            String attribut = (String) request.getAttribute("resultat");
            out.println( attribut );
            %>
		</p>
</body>
</html>