<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.google.appengine.api.users.*" %>
<% UserService userService = UserServiceFactory.getUserService(); %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <title>Hello App Engine</title>
  </head>

  <body>
    <h1>Tiny Tweet</h1>
  
  	  <% if (userService.getCurrentUser() == null) { %>
            <p><a href="<%= userService.createLoginURL("/createNFollowers") %>">Se connecter</a></p>
        <% }
        else { %>
            <p>Bonjour <%= userService.getCurrentUser().getNickname() %></p>
            <p><a href="<%= userService.createLogoutURL("/") %>">Se déconnecter</a></p>
        <% } %>
  	
  	
    
  </body>
</html>