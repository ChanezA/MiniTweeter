<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.google.appengine.api.users.*" %>
<% UserService userService = UserServiceFactory.getUserService(); %>
<%@ page import="java.util.List" %>
<%@ page import="entites.Tweet" %>
<%@ page import="static com.googlecode.objectify.ObjectifyService.ofy"%>
<html>
    <head>
        <meta charset="utf-8" />
        <title>NewTweet</title>
    </head>
    <body>
    	<% long var = System.currentTimeMillis(); %>
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
          List<Tweet> tweet = ofy().load().type(Tweet.class).list();
            for (Tweet message : tweet) {
        %>
        <p>
            <strong><%= message.getOwner() %></strong> tweet :<br />
            <%= message.getMessage() %>
        </p>
        <%
            }
        %>
        <p>
        	Affichage en <%=(System.currentTimeMillis() - var) %> ms
        </p> 
    </body>
</html>