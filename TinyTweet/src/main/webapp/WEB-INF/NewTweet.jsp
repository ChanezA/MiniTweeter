<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.google.appengine.api.users.*" %>
<% UserService userService = UserServiceFactory.getUserService(); %>

<html>
    <head>
        <meta charset="utf-8" />
        <title>NewTweet</title>
    </head>
    <body>
       <h1>Ecrivez votre tweet !</h1>
       
       <form method="post" action="publishaTweet">
            <fieldset>
                <legend>New Tweet</legend>
                <label for="pseudo">pseudo d utilisateur</label>
                <input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="20" />
                <br />
                 <label for="message">pseudo d utilisateur</label>
                <input type="text" id="pseudo" name="pseudo" value="" size="200" maxlength="200" />
                <br />
                <input type="submit" value="Publier" class="sansLabel" />
                <br />
            </fieldset>
        </form>
        <h1>afficher les derniers tweets</h1>
         <p>Bonjour <%= userService.getCurrentUser().getNickname() %></p>
    </body>
</html>