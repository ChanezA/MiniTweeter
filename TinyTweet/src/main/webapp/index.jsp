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
            <p><a href="<%= userService.createLoginURL("/") %>">Se connecter</a></p>
        <% }
        else { %>
            <p>Bonjour <%= userService.getCurrentUser().getNickname() %></p>
            <p><a href="<%= userService.createLogoutURL("/") %>">Se déconnecter</a></p>
        <% } %>
  	
  	
    <table>
      <tr>
        <td colspan="2" style="font-weight:bold;">Available Servlets:</td>        
      </tr>
      <tr>
        <td><a href='/hello'>The servlet</a></td>
        <td><a href='/initialisation'>The servlet init</a></td>
        <td><a href='/publishaTweet'>The servlet To publish a tweet</a></td>           
      </tr>
      <p>Fonctionnne</p>
    </table>
  </body>
</html>