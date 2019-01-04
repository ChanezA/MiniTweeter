<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.google.appengine.api.users.*" %>
<% UserService userService = UserServiceFactory.getUserService(); %>
<%@ page import="java.util.List" %>
<%@ page import="entites.Tweet" %>
<html>
    <head>
        <meta charset="utf-8" />
        <title>NewTweet</title>
    </head>
    <body>
       <h1>Ecrivez votre tweet !</h1>
       
       <form method="post" action="publishaTweet">
            <fieldset>
                 <label for="message">message d utilisateur</label>
                <input type="text" id="message" name="message" value="" size="200" maxlength="200" />
                <br />
                <input type="submit" value="Publier" class="sansLabel" />
                <br />
            </fieldset>
        </form>
        
         <p>Bonjour <%= userService.getCurrentUser().getNickname() %></p>
         <h1>afficher les derniers tweets</h1>
          <%
          java.util.List<Tweet> messages =(List<Tweet>)request.getAttribute("tweets");
            for (Tweet message : messages) {
        %>
        <p>
            <strong><%= userService.getCurrentUser().getNickname() %></strong> tweet :<br />
            <%= message.getMessage() %>
        </p>
        <%
            }
        %>
    </body>
</html>