<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.google.appengine.api.users.*" %>
<% UserService userService = UserServiceFactory.getUserService(); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
      <tr>
        <td colspan="2" style="font-weight:bold;">Available Servlets:</td>        
      </tr>
      <tr>
        
        <td><a href='/publishaTweet'>Publish a tweet</a></td>                     
        <td><a href="<%= userService.createLogoutURL("/") %>">Se déconnecter</a></td>
                       
      </tr>
    </table>
    <p>Heyyyy fonctioooonnne </p>
    	     	<%String pseudo = (String) session.getAttribute( "pseudo" ); %>
	    	  
</body>
</html>
